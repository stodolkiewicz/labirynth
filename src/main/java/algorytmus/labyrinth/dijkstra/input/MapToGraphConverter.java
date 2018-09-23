package algorytmus.labyrinth.dijkstra.input;

import algorytmus.labyrinth.dijkstra.model.Edge;
import algorytmus.labyrinth.dijkstra.model.Graph;
import algorytmus.labyrinth.dijkstra.model.Vertex;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapToGraphConverter {

    public Graph convertMapToGraph(int[][] map){
        Graph graph = new Graph();
        int mapRows = map.length;
        int mapColumns = map[0].length;
        Vertex targetVertex = null;
        for(int i = 0; i < mapRows; i++){
            for(int j = 0; j < mapColumns; j++){
                int currentFieldValue = map[i][j];

                if(currentFieldValue == 1) {}
                else if(currentFieldValue == 0){
                    createVertexAndAddToGraph(graph, mapRows, i, j);
                }
                else if(currentFieldValue == 2){
                    Vertex vertex = createVertexAndAddToGraph(graph, mapRows, i, j);
                    graph.setSourceVertex(vertex);
                }
                else if(currentFieldValue == 3){
                    Vertex vertex = createVertexAndAddToGraph(graph, mapRows, i, j);
                    targetVertex = vertex;
                    graph.setTargetVertex(targetVertex);
                }
                else if(currentFieldValue > 6 && currentFieldValue < 100){
                    Vertex vertex = createVertexAndAddToGraph(graph, mapRows, i, j);
                    vertex.setPortalNumber(currentFieldValue);
                    vertex.setPortal(true);
                }
            }
        }

        //Updating all vertexes with the targetVertex so that we can use some heuristic
        //by changing the implementation of compareTo method in Vertex class (order in priorityQueue depends on it)
        updateTargetVertexForAllVertexes(graph, targetVertex);

        return graph;
    }

    private void updateTargetVertexForAllVertexes(Graph graph, Vertex targetVertex) {
        for(Vertex vertex: graph.getVertexes()){
            vertex.setTargetVertex(targetVertex);
        }
    }

    public void updateAdjacencies(Graph graph){
        graph.getVertexes().stream()
                .forEach(vertexProcessed -> {
                    int xPosition = vertexProcessed.getxPosition();
                    int yPosition = vertexProcessed.getyPosition();

                    Optional<Vertex> v1 = getVertexWithPosition(graph, xPosition - 1, yPosition);
                    Optional<Vertex> v2 = getVertexWithPosition(graph, xPosition + 1, yPosition);
                    Optional<Vertex> v3 = getVertexWithPosition(graph, xPosition, yPosition - 1);
                    Optional<Vertex> v4 = getVertexWithPosition(graph, xPosition, yPosition + 1);

                    updateVertexAdjacencies(graph, vertexProcessed, v1);
                    updateVertexAdjacencies(graph, vertexProcessed, v2);
                    updateVertexAdjacencies(graph, vertexProcessed, v3);
                    updateVertexAdjacencies(graph, vertexProcessed, v4);
                });
    }

    private void updateVertexAdjacencies(Graph graph, Vertex vertexProcessed, Optional<Vertex> v1) {
        v1.ifPresent(vertex1 -> {
            if(vertex1.isPortal()){
                Optional<Vertex> exitPortal = getExitPortal(graph, vertex1);

                exitPortal.ifPresent(exitVertex -> {
                    vertexProcessed.addAdjacency(new Edge(vertexProcessed, exitVertex));
                });
            }else{
                vertexProcessed.addAdjacency(new Edge(vertexProcessed, vertex1));
            }
        });
    }

    private Optional<Vertex> getVertexWithPosition(Graph graph, int xPosition, int yPosition){
        List<Vertex> vertexesWithGivenPosition = graph.getVertexes().stream()
                .filter(vertex -> vertex.getxPosition() == xPosition && vertex.getyPosition() == yPosition)
                .collect(Collectors.toList());

        if(vertexesWithGivenPosition.size() == 0){
            return Optional.empty();
        }else{
            return Optional.of(vertexesWithGivenPosition.get(0));
        }
    }

    private Optional<Vertex> getExitPortal(Graph graph, Vertex entryPortal){
        List<Vertex> vertexesWithGivenPortalNumber= graph.getVertexes().stream()
                .filter(vertex -> vertex.getPortalNumber() == entryPortal.getPortalNumber())
                .collect(Collectors.toList());

        if(vertexesWithGivenPortalNumber.size() == 0){
            return Optional.empty();
        }else if(vertexesWithGivenPortalNumber.size() == 1){
            return Optional.of(entryPortal);
        }else{
            if(vertexesWithGivenPortalNumber.get(0).getxPosition() == entryPortal.getxPosition() &&
                vertexesWithGivenPortalNumber.get(0).getyPosition() == entryPortal.getyPosition()){
                return Optional.of(vertexesWithGivenPortalNumber.get(1));
            }
            return Optional.of(vertexesWithGivenPortalNumber.get(0));
        }
    }

    private Vertex createVertexAndAddToGraph(Graph graph, int mapRows, int i, int j) {
        Vertex vertex = new Vertex(j, mapRows - i - 1);
        graph.addVertex(vertex);
        return vertex;
    }
}
