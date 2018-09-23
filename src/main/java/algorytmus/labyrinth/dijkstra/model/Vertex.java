package algorytmus.labyrinth.dijkstra.model;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
    private int xPosition;
    private int yPosition;
    private List<Edge> adjaciencies = new ArrayList<>();
    private Vertex previousVertex;
    private Vertex targetVertex;
    private boolean isPortal = false;
    private int portalNumber;

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

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
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

    public int getPortalNumber() {
        return portalNumber;
    }

    public void setPortalNumber(int portalNumber) {
        this.portalNumber = portalNumber;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        int valueOfCurrentVertex = this.distance + Math.abs(this.getxPosition() - this.targetVertex.getxPosition()) +
                Math.abs(this.getyPosition() - this.targetVertex.getyPosition());
        int valueOfTargetVertex = otherVertex.distance + Math.abs(otherVertex.getxPosition() - this.targetVertex.getxPosition()) +
                Math.abs(otherVertex.getyPosition() - this.targetVertex.getyPosition());

        return Integer.compare(valueOfCurrentVertex, valueOfTargetVertex);
    }

    @Override
    public String toString() {
        return  "(" + xPosition + "," + yPosition + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (getxPosition() != vertex.getxPosition()) return false;
        return getyPosition() == vertex.getyPosition();
    }

    @Override
    public int hashCode() {
        int result = getxPosition();
        result = 31 * result + getyPosition();
        return result;
    }
}
