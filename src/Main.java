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
            boolean north = canIGoNorth(r);
            boolean south = canIGoSouth(r, maze);
            boolean east = canIGoEast(c, maze);
            boolean west = canIGoWest(c);
            if (!north && south && east && !west) {
                if (maze[r][c + 1].equals(".")) {
                    goRight(r, c, maze);
                    c++;
                }
                else if (maze[r + 1][c].equals(".")) {
                    goDown(r, c, maze);
                    r++;
                }
            }
            else if (!north && south && !east && west) {
                if (maze[r][c - 1].equals(".")) {
                    goLeft(r, c, maze);
                    c--;
                }
                else if (maze[r + 1][c].equals(".")) {
                    goDown(r, c, maze);
                    r++;
                }
            }
            else if (!north) {
                if (maze[r][c - 1].equals(".")) {
                    goLeft(r, c, maze);
                    c--;
                }
                else if (maze[r][c + 1].equals(".")) {
                    goRight(r, c, maze);
                    c++;
                }
                else if (maze[r + 1][c].equals(".")) {
                    goDown(r, c, maze);
                    r++;
                }
            }
            else if (north && !south && east && !west) {
                if (maze[r - 1][c].equals(".")) {
                    goUp(r, c, maze);
                    r--;
                }
                else if (maze[r][c + 1].equals(".")) {
                    goRight(r, c, maze);
                    c++;
                }
            }
            else if (north && !south && !east && west) {
                if (maze[r - 1][c].equals(".")) {
                    goUp(r, c, maze);
                    r--;
                }
                else if (maze[r][c - 1].equals(".")) {
                    goLeft(r, c, maze);
                    c--;
                }
            }
            else if (!south) {
                if (maze[r][c - 1].equals(".")) {
                    goLeft(r, c, maze);
                    c--;
                }
                else if (maze[r][c + 1].equals(".")) {
                    goRight(r, c, maze);
                    c++;
                }
                else if (maze[r - 1][c].equals(".")) {
                    goUp(r, c, maze);
                    r--;
                }
            }
            else if (!west) {
                if (maze[r][c + 1].equals(".")) {
                    goRight(r, c, maze);
                    c++;
                }
                else if (maze[r - 1][c].equals(".")) {
                    goUp(r, c, maze);
                    r--;
                }
                else if (maze[r + 1][c].equals(".")) {
                    goDown(r, c, maze);
                    r++;
                }
            }
            else if (!east) {
                if (maze[r][c - 1].equals(".")) {
                    goLeft(r, c, maze);
                    c--;
                }
                else if (maze[r + 1][c].equals(".")) {
                    goDown(r, c, maze);
                    r++;
                }
                else if (maze[r - 1][c].equals(".")) {
                    goUp(r, c, maze);
                    r--;
                }
            }
            else {
                if (maze[r + 1][c].equals(".")) {
                    goDown(r, c, maze);
                    r++;
                }
                else if (maze[r - 1][c].equals(".")) {
                    goUp(r, c, maze);
                    r--;
                }
                else if (maze[r][c + 1].equals(".")) {
                    goRight(r, c, maze);
                    c++;
                }
                else if (maze[r][c - 1].equals(".")) {
                    goLeft(r, c, maze);
                    c--;
                }
            }
            String newSpot = "(" + r + ", " + c + ")";
            answerKey.add(newSpot);
        }
        return answerKey;
    }
    public static boolean canIGoNorth(int x) {
        boolean yes = true;
        if (x == 0) {
            yes = false;
        }
        return yes;
    }
    public static boolean canIGoSouth(int x, String[][] maze) {
        boolean yes = true;
        if (x == maze.length - 1) {
            yes = false;
        }
        return yes;
    }
    public static boolean canIGoEast (int y, String[][] maze) {
        boolean yes = true;
        if (y == maze[0].length - 1) {
            yes = false;
        }
        return yes;
    }
    public static boolean canIGoWest (int y) {
        boolean weast = true;
        if (y == 0) {
            weast = false;
        }
        return weast;
    }
    public static void goUp (int x, int y, String[][] maze) {
        maze[x][y] = "#";
        x--;
    }
    public static void goDown (int x, int y, String[][] maze) {
        maze[x][y] = "#";
        x++;
    }
    public static void goLeft (int x, int y, String[][] maze) {
        maze[x][y] = "#";
        y--;
    }
    public static void goRight (int x, int y, String[][] maze) {
        maze[x][y] = "#";
        y++;
    }
}