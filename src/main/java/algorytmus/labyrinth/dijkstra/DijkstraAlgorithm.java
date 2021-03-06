package algorytmus.labyrinth.dijkstra;

import algorytmus.labyrinth.dijkstra.model.Edge;
import algorytmus.labyrinth.dijkstra.model.Graph;
import algorytmus.labyrinth.dijkstra.model.Vertex;

import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    private Graph graph;

    public DijkstraAlgorithm() {}

    public DijkstraAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public void computePaths(){
        Vertex sourceVertex = graph.getSourceVertex();
        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);

        while(!priorityQueue.isEmpty()){
            Vertex currentVertex = priorityQueue.poll();

            for(Edge edge : currentVertex.getAdjaciencies()){
                Vertex adjacentVertex = edge.getTargetVertex();
                int newDistance = currentVertex.getDistance() + edge.getWeight();

                if(newDistance < adjacentVertex.getDistance()){
                    priorityQueue.remove(adjacentVertex);
                    adjacentVertex.setDistance(newDistance);
                    adjacentVertex.setPreviousVertex(currentVertex);
                    priorityQueue.add(adjacentVertex);
                    //stop execution if we got to target Vertex
                    if(adjacentVertex.equals(adjacentVertex.getTargetVertex())){
                        return;
                    }
                }
            }
        }
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
