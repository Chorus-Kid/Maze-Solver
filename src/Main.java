import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
public class Main {
    public static void main(String[] args) {
        String file = "data/Maze";
        String[][] maze = getMaze(file);
        for (String[] r : maze) {
            for (String c : r) {
                System.out.print(c);
            }
            System.out.println();
        }
        ArrayList<String> answersHehhehheh = mazeAnswer(maze);
        for (String coordinate : answersHehhehheh) {
            System.out.println(coordinate);
        }
     }

    public static String[][] getMaze(String fileName){
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;

    }
    public static ArrayList<String> mazeAnswer(String[][] maze) {
        ArrayList<String> answerKey = new ArrayList<String>();
        answerKey.add("(0,0)");
        int r = 0;
        int c = 0;
        while (r < maze.length && c < maze[0].length) {

            String newSpot = "(" + r + ", " + c + ")";
            answerKey.add(newSpot);
        }
        return answerKey;
    }

}