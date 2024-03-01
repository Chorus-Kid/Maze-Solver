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
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[0].length; c++) {
                if (r == 0 && c == 0) {
                    if (maze[r][c + 1].equals(".")) {
                        maze[r][c] = "#";
                        c++;
                    } else if (maze[r + 1][c].equals(".")) {
                        maze[r][c] = "#";
                        r++;
                    }
                    String newSpot = "(" + r + ", " + c + ")";
                    answerKey.add(newSpot);
                } else if (r == 0 && c != 0) {
                    if (maze[r][c + 1].equals(".")) {
                        maze[r][c] = "#";
                        c++;
                    } else if (maze[r + 1][c].equals(".")) {
                        maze[r][c] = "#";
                        r++;
                    }
                    String newSpot = "(" + r + ", " + c + ")";
                    answerKey.add(newSpot);
                } else if (c == 0 && r != 0) {
                    if (maze[r][c + 1].equals(".")) {
                        maze[r][c] = "#";
                        c++;
                    } else if (maze[r + 1][c].equals(".")) {
                        maze[r][c] = "#";
                        r++;
                    }
                    String newSpot = "(" + r + ", " + c + ")";
                    answerKey.add(newSpot);
                }
            }
        }
        return answerKey;
    }
}