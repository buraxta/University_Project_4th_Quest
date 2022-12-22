import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private class Node{
        private String label;

        Map<Node, Integer> adjacentNodes = new HashMap<>();

        public Node(String label) {
            this.label = label;
        }
        public void addDestination(Node destination, int distance) {
            adjacentNodes.put(destination, distance);
        }

        @Override
        public String toString() {
            return label;
        }
    }
    //Here I use Map, because I want to be make sure that there's only one node here,
    // so I do this with the help of Map's putIfAbsent method.
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        //once we add a node, we want to add this adjecency list as well
        adjacencyList.putIfAbsent(node, new ArrayList<>());

    }

    public void addEdge(String from, String to, int dest){
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
        adjacencyList.get(toNode).add(fromNode);
        fromNode.addDestination(toNode, dest);
        toNode.addDestination(fromNode, dest);

    }

    public void print(){
        for (var source : adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);

        }
    }
    public void distance(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode.adjacentNodes.get(toNode) != null){
            System.out.println("Distance between " + from + " to " + to + " is " + fromNode.adjacentNodes.get(toNode));
        }else {
            System.out.println("There is no such connection");
        }

    }
}
