public class Main {
    public static void main(String[] args) {

        var graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addNode("H");
        graph.addEdge("A", "D", 20);
        graph.addEdge("A", "C", 17);
        graph.addEdge("A", "B", 12);
        graph.addEdge("B", "C", 21);
        graph.addEdge("B", "H", 19);
        graph.addEdge("C", "D", 4);
        graph.addEdge("C", "G", 6);
        graph.addEdge("C", "E", 88);
        graph.addEdge("H", "E", 19);
        graph.addEdge("G", "D", 13);
        graph.addEdge("G", "E", 37);
        graph.addEdge("F", "D", 15);
        graph.addEdge("F", "G", 44);
        graph.addEdge("F", "E",30);

        graph.distance("A", "B");
        graph.print();
    }
}