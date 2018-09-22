package algorytmus.labyrinth.dijkstra;

import algorytmus.labyrinth.dijkstra.model.Edge;
import algorytmus.labyrinth.dijkstra.model.Graph;
import algorytmus.labyrinth.dijkstra.model.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    private Graph graph;

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
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex){
        List<Vertex> shortestPathToTarget = new ArrayList<>();

        for(Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPreviousVertex()){
            shortestPathToTarget.add(vertex);
        }

        Collections.reverse(shortestPathToTarget);

        return shortestPathToTarget;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
