package algorytmus.labyrinth.dijkstra.model;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
    private int xPosition;
    private int yPosition;
    private List<Edge> adjaciencies = new ArrayList<>();
    private Vertex previousVertex;
    private boolean isPortal = false;

    //minimum number Of moves it takes to get from start vertex to this vertex
    private int distance = Integer.MAX_VALUE;

    public Vertex(int xPosition, int yPosition, List<Edge> adjaciencies) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.adjaciencies = adjaciencies;
    }

    public Vertex(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void addAdjacency(Edge edge){
        adjaciencies.add(edge);
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public List<Edge> getAdjaciencies() {
        return adjaciencies;
    }

    public void setAdjaciencies(List<Edge> adjaciencies) {
        this.adjaciencies = adjaciencies;
    }

    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isPortal() {
        return isPortal;
    }

    public void setPortal(boolean portal) {
        isPortal = portal;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Integer.compare(this.distance, otherVertex.distance);
    }

    @Override
    public String toString() {
        return  xPosition + " " + yPosition;
    }
}
