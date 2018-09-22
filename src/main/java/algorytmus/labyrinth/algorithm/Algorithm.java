package algorytmus.labyrinth.algorithm;

import algorytmus.labyrinth.model.Edge;
import algorytmus.labyrinth.model.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {

    public void computePaths(Vertex sourceVertex){
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
}
