import java.util.Scanner;

public class GameMain {
    static int GRIDSIZE = 10;
    // This is the main class for the game conway's game of life
    //rule 1: any live cell with fewer than two live neighbors dies, as if by underpopulation
    //rule 2: any live cell with two or three live neighbors lives on to the next generation
    //rule 3: any live cell with more than three live neighbors dies, as if by overpopulation
    //rule 4: any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction

    public static void main(String[] args) {
        GameMain game = new GameMain();
        //printing grid

        System.out.println("Welcome to Conway's Game of Life!");
        System.out.println("press 1 to start a new game, press 2 to quit");
        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();
        switch (choice) {
            case 1:
                game.gameStart();
                break;
            case 2:
                System.out.println("Thanks for playing!");
                break;
            default:
                System.out.println("invalid input");
                break;
        }
    }
        public void gameStart () {
            int[][] gameGrid = new int[GRIDSIZE][GRIDSIZE];
            GameMain.gridPrint(gameGrid);
            System.out.println("how many cells would you like to start with?");
            Scanner input = new Scanner(System.in);
            int numCells = input.nextInt();
            for (int i = 0; i < numCells; i++) {
                System.out.println("enter the x coordinate of cell " + (i + 1));
                int x = input.nextInt() - 1;
                System.out.println("enter the y coordinate of cell " + (i + 1));
                int y = input.nextInt() - 1;
                gameGrid[y][x] = 1;
                GameMain.gridPrint(gameGrid);
            }

            System.out.println("how many generations would you like to simulate?");
            int numGens = input.nextInt();
            for (int i = 0; i < numGens; i++) {
                System.out.println("generation " + (i + 1));
                int[][] tempGrid = new int[GRIDSIZE][GRIDSIZE];
                for (int x = 0; x < GRIDSIZE; x++) {
                    for (int y = 0; y < GRIDSIZE; y++) {
                        int neighbors = neighborCheck(gameGrid, x, y);
                        tempGrid[x][y] = neighbors;
                    }
                }
                for (int x = 0; x < GRIDSIZE; x++) {
                    for (int y = 0; y < GRIDSIZE; y++) {
                        cellGeneration(tempGrid, gameGrid, x, y);
                    }
                }
                GameMain.gridPrint(gameGrid);
                int secondsToSleep = 1;
                try {
                    Thread.sleep(secondsToSleep * 1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }

            }
            main(null);
        }
        static void gridPrint ( int[][] gameGrid){ //prints grid
            for (int i = 0; i < GRIDSIZE; i++) {
                for (int j = 0; j < GRIDSIZE; j++) {
                    System.out.print(gameGrid[i][j] + " ");
                }
                System.out.println();
            }
        }

        //checking neighbours
        int neighborCheck ( int[][] gameGrid, int i, int j){
            int neighbors = 0;
            if (i > 0) {
                neighbors += gameGrid[i - 1][j]; //cell above
                //System.out.println("cell above" + gameGrid[i - 1][j] + neighbors);
                if (j > 0) {
                    neighbors += gameGrid[i - 1][j - 1]; //cell above and to the left
                    //   System.out.println("cell above and to the left"+gameGrid[i - 1][j - 1]+neighbors);
                }
                if (j < GRIDSIZE - 1) {
                    neighbors += gameGrid[i - 1][j + 1]; //cell above and to the right
                    //   System.out.println("cell above and to the right"+gameGrid[i - 1][j + 1]+neighbors);
                }
            }
            if (i < GRIDSIZE - 1) {
                neighbors += gameGrid[i + 1][j]; //cell below
                //   System.out.println("cell below"+gameGrid[i+1][j]+neighbors);
                if (j > 0) {
                    neighbors += gameGrid[i + 1][j - 1]; //cell below and to the left
                    //   System.out.println("cell below and to the left"+gameGrid[i + 1][j - 1]+neighbors);
                }
                if (j < GRIDSIZE - 1) {
                    neighbors += gameGrid[i + 1][j + 1]; //cell below and to the right
                    //  System.out.println("cell below and to the right"+gameGrid[i + 1][j + 1]+neighbors);
                }
            }
            if (j > 0) {
                neighbors += gameGrid[i][j - 1]; //cell to the left
                //  System.out.println("cell to the left"+gameGrid[i][j - 1]+neighbors);
            }
            if (j < GRIDSIZE - 1) {
                neighbors += gameGrid[i][j + 1]; //cell to the right
                // System.out.println("cell to the right"+gameGrid[i][j + 1]+neighbors);
            }
            return neighbors;
        }

        public static void cellGeneration ( int[][] tempGrid, int[][] gameGrid, int i, int j){

            int cell = gameGrid[i][j];
            int neighborCount = tempGrid[i][j];
            if (cell == 1 && neighborCount < 2) {
                gameGrid[i][j] = 0;
            }
            if (cell == 1 && neighborCount > 3) {
                gameGrid[i][j] = 0;
            }
            if (cell == 0 && neighborCount == 3) {
                gameGrid[i][j] = 1;
            }
        }
    }
