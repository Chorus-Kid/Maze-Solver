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
        ArrayList<String> answersMwehehehe = mazeAnswer(maze);
        for (String coordinate : answersMwehehehe) {
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
        String[][] aSurpriseToolThatWillHelpUsLater = new String[maze.length][maze[0].length];
        for (int row = 0; row < maze.length; row++) {
            for (int column = 0; column < maze[0].length; column++) {
                aSurpriseToolThatWillHelpUsLater[row][column] = maze[row][column];
            }
        }
        answerKey.add("(0,0)");
        int r = 0;
        int c = 0;
        while (r <= maze.length - 1 && c <= maze[0].length - 1) {
            boolean up = upQuestionMark(r, c, maze);
            boolean down = downQuestionMark(r, c, maze);
            boolean left = leftQuestionMark(r, c, maze);
            boolean right = rightQuestionMark(r, c, maze);
            if (up && !down && !left && !right) {
                maze[r][c] = "#";
                r--;
            }
            else if (down && !up && !left && !right) {
                maze[r][c] = "#";
                r++;
            }
            else if (left && !up && !down && !right) {
                maze[r][c] = "#";
                c--;
            }
            else if (right && !up && !down && !left) {
                maze[r][c] = "#";
                c++;
            }
            String newSpot = "(" + r + "," + c + ")";
            answerKey.add(newSpot);
        }
        return answerKey;
    }

    public static boolean upQuestionMark(int r, int c, String[][] maze) {
        boolean upped = false;
        if (r != 0) {
            if (maze[r - 1][c].equals(".")) {
                upped = true;
            }
        }
        return upped;
    }
    public static boolean downQuestionMark(int r, int c, String[][] maze) {
        boolean downed = false;
        if (r != maze.length - 1) {
            if (maze[r + 1][c].equals(".")) {
                downed = true;
            }
        }
        return downed;
    }
    public static boolean leftQuestionMark(int r, int c, String[][] maze) {
        boolean lefted = false;
        if (c != 0) {
            if (maze[r][c - 1].equals(".")) {
                lefted = true;
            }
        }
        return lefted;
    }
    public static boolean rightQuestionMark(int r, int c, String[][] maze) {
        boolean righted = false;
        if (c != maze[0].length - 1) {
            if (maze[r][c + 1].equals(".")) {
                righted = true;
            }
        }
        return righted;
    }
}