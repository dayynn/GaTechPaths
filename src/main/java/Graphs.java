import org.jgrapht.Graph;
import org.jgrapht.VertexFactory;
import org.jgrapht.alg.shortestpath.FloydWarshallShortestPaths;
import org.jgrapht.generate.CompleteGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Graphs {

    //private static final int SIZE = 10;


    public static void main(String[] args) {
        String[] nodes = {"Biomedical Quad","Tech Square","Klaus/Coc","Howey","MRDC","West Village","Love","Boggs",
                "Van Leer","Architecture", "Tech Tower", "Culc/Skiles", "Student Center", "IC","CRC"
        };

        SimpleWeightedGraph<String, DefaultWeightedEdge> weighted_graph = new SimpleWeightedGraph(DefaultWeightedEdge.class);
        //add vertices
        for (int i = 0; i < nodes.length; i++) {
            weighted_graph.addVertex(nodes[i]);
        }

        //add edges with weight being time in seconds
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Biomedical Quad", "Klaus/Coc"), 154);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Tech Square", "Klaus/Coc"), 477);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Howey", "Klaus/Coc"), 119);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Howey", "MRDC"), 199);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("MRDC", "West Village"), 430);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("West Village", "Love"), 395);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Love", "MRDC"), 52);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("MRDC", "Boggs"), 120);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Boggs", "Howey"), 201);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Howey", "Van Leer"), 162);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Van Leer", "Architecture"), 86);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Architecture", "Klaus/Coc"), 61);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Love", "CRC"), 100);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("CRC", "IC"), 88);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("IC", "Love"), 149);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("IC", "Boggs"), 122);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("IC", "Student Center"), 233);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Student Center", "Boggs"), 70);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Student Center", "Van Leer"), 125);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Student Center", "Culc/Skiles"), 150);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Culc/Skiles", "Van Leer"), 77);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Culc/Skiles", "Architecture"), 65);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Culc/Skiles", "Tech Tower"), 220);
        weighted_graph.setEdgeWeight(weighted_graph.addEdge("Tech Tower", "Architecture"), 377);

        //create a floyd warshall
        FloydWarshallShortestPaths<String, DefaultWeightedEdge> shortestPaths = new FloydWarshallShortestPaths<>(weighted_graph);
        //print shortest path
        for (int i = 0; i < nodes.length; i++) {
            for (int j = (i + 1) % nodes.length; j != i; j = (j + 1) % nodes.length) {
                System.out.println("Shortest time (in seconds) between " + nodes[i] + " and " + nodes[j] + " CRC:");
                System.out.println(shortestPaths.getPathWeight(nodes[i], nodes[j]));
            }
        }





        /*System.out.println("Hello");
        // Create the graph object
        Graph<String, DefaultEdge> completeGraph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

        // Create the CompleteGraphGenerator object
        CompleteGraphGenerator<String, DefaultEdge> completeGenerator =
                new CompleteGraphGenerator<String, DefaultEdge>(SIZE);

        // Create the VertexFactory so the generator can create vertices
        VertexFactory<String> vFactory = new VertexFactory<String>()
        {
            private int id = 0;

            @Override
            public String createVertex()
            {
                return "v" + id++;
            }
        };

        // Use the CompleteGraphGenerator object to make completeGraph a
        // complete graph with [size] number of vertices
        completeGenerator.generateGraph(completeGraph, vFactory, null);

        // Print out the graph to be sure it's really complete
        Iterator<String> iter = new DepthFirstIterator<>(completeGraph);
        while (iter.hasNext()) {
            String vertex = iter.next();
            System.out.println(
                    "Vertex " + vertex + " is connected to: "
                            + completeGraph.edgesOf(vertex).toString());
        }
        */
    }
}
