package algorytmus.labyrinth.dijkstra.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
    private List<Vertex> vertexes = new ArrayList<>();
    List<Vertex> shortestPathToTarget = new ArrayList<>();
    private Vertex sourceVertex;
    private Vertex targetVertex;

    public Graph() {
    }

    public List<Vertex> computeShortestPathToTargetVertex(){
        for(Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPreviousVertex()){
            shortestPathToTarget.add(vertex);
        }

        Collections.reverse(shortestPathToTarget);

        return shortestPathToTarget;
    }

    public List<Vertex> getShortestPathTo(Vertex alternativeTargetVertex){
        List<Vertex> shortestPathToTarget = new ArrayList<>();

        for(Vertex vertex = alternativeTargetVertex; vertex != null; vertex = vertex.getPreviousVertex()){
            shortestPathToTarget.add(vertex);
        }

        Collections.reverse(shortestPathToTarget);

        return shortestPathToTarget;
    }


    public void addVertex(Vertex vertex){
        this.vertexes.add(vertex);
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public void setVertexes(List<Vertex> vertexes) {
        this.vertexes = vertexes;
    }

    public Vertex getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(Vertex sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    @Override
    public String toString() {
        String graphString = "";
        for(Vertex vertex: vertexes){
            graphString += vertex.toString();
        }
        graphString += "\n";

        return graphString;
    }
}
