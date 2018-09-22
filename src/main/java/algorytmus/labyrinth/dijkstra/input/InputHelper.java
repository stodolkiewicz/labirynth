package algorytmus.labyrinth.dijkstra.input;

import algorytmus.labyrinth.dijkstra.model.Graph;
import algorytmus.labyrinth.dijkstra.model.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputHelper {

    public List<int[][]> getListOfMapsFromFile(String filePath){
        List<int[][]> maps = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            //skip first line
            br.readLine();

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] split = sCurrentLine.trim().replaceAll(" +", " ").split(" ");

                int y = Integer.valueOf(split[0]);
                int x = Integer.valueOf(split[1]);

                int[][] table = new int[x][y];
                for(int i = 0; i < x; i++){
                    String[] numbersInLine = br.readLine().trim().replaceAll(" +", " ").split(" ");
                    for(int j = 0; j < y; j++){
                        table[i][j] = Integer.valueOf(numbersInLine[j]);
                    }
                }
                maps.add(table);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maps;
    }

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

    private Vertex createVertexAndAddToGraph(Graph graph, int mapRows, int i, int j) {
        Vertex vertex = new Vertex(j, mapRows - i - 1);
        graph.addVertex(vertex);
        return vertex;
    }
}
