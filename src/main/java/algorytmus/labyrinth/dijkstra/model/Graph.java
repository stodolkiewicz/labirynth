package algorytmus.labyrinth.dijkstra.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertexes = new ArrayList<>();
    private Vertex sourceVertex;

    //optimization purposes
    private Vertex destinationVertex;

    public Graph() {
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

    public Vertex getDestinationVertex() {
        return destinationVertex;
    }

    public void setDestinationVertex(Vertex destinationVertex) {
        this.destinationVertex = destinationVertex;
    }
}
