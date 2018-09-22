package algorytmus.labyrinth.dijkstra.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputHelper {
    List<int[][]> maps = new ArrayList<>();

    public List<int[][]> getListOfMapsFromFile(String filePath){
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
        this.maps = maps;
        return maps;
    }

}
