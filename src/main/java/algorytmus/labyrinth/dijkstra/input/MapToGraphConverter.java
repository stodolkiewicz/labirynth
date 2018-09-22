package algorytmus.labyrinth.dijkstra.input;

import algorytmus.labyrinth.dijkstra.model.Graph;
import algorytmus.labyrinth.dijkstra.model.Vertex;

public class MapToGraphConverter {

    public void convertMapToGraph(int[][] map){
        Graph graph = new Graph();
        int mapRows = map.length;
        int mapColumns = map[0].length;

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
                    graph.setDestinationVertex(vertex);
                }
                else if(currentFieldValue > 6 && currentFieldValue < 100){
                    Vertex vertex = createVertexAndAddToGraph(graph, mapRows, i, j);
                    vertex.setPortal(true);
                }
            }
        }
    }

    public void updateAdjacencies(){

    }

    private Vertex createVertexAndAddToGraph(Graph graph, int mapRows, int i, int j) {
        Vertex vertex = new Vertex(j, mapRows - i - 1);
        graph.addVertex(vertex);
        return vertex;
    }
}
