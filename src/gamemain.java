import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class GameMain {
    static int GRIDSIZE = 10;
    // This is the main class for the game conway's game of life
    //rule 1: any live cell with fewer than two live neighbors dies, as if by underpopulation
    //rule 2: any live cell with two or three live neighbors lives on to the next generation
    //rule 3: any live cell with more than three live neighbors dies, as if by overpopulation
    //rule 4: any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction

    public static void main(String[] args){

        //printing grid
        GameMain game = new GameMain();
        int [][] gameGrid = new int[GRIDSIZE][GRIDSIZE];
        game.gridPrint(gameGrid);
        System.out.println("how many cells would you like to start with?");
        Scanner input = new Scanner(System.in);
        int numCells = input.nextInt();
        for(int i = 0; i < numCells; i++){
            System.out.println("enter the x coordinate of cell " + (i+1));
            int x = input.nextInt();
            System.out.println("enter the y coordinate of cell " + (i+1));
            int y = input.nextInt();
            gameGrid[x][y] = 1;
            game.gridPrint(gameGrid);
        }
        System.out.println("how many generations would you like to simulate?");
        int numGens = input.nextInt();
        for(int i = 0; i < numGens; i++){
            game.neighborCheck(gameGrid);
            game.gridPrint(gameGrid);
            try{TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e){};
        }
}
    static void gridPrint(int[][] gameGrid) { //prints grid
        for (int i = 0; i < GRIDSIZE; i++) {
            for (int j = 0; j < GRIDSIZE; j++) {
                System.out.print(gameGrid[i][j] + " ");
            }
            System.out.println();
        }
    }
    //checking neighbours
    static void neighborCheck(int[][] gameGrid){
    for(int i = 0; i < GRIDSIZE; i++){
        for(int j = 0; j < GRIDSIZE; j++){
            int neighbors = 0;
            int cell = gameGrid[i][j];
            if(i > 0 && j > 0 && gameGrid[i-1][j-1] == 1){
                neighbors++;
            }
            if(i > 0 && gameGrid[i-1][j] == 1){
                neighbors++;
            }
             if(i > 0 && gameGrid[i-1][j+1] == 1){
                neighbors++;
            }
             if(i > 0 && gameGrid[i][j-1] == 1){
                neighbors++;
            }
            if(i > 0 && gameGrid[i][j+1] == 1){
                neighbors++;
            }
            if(i > 0 && gameGrid[i+1][j-1] == 1){
                neighbors++;
            }
            if(i > 0 && gameGrid[i+1][j] == 1){
                neighbors++;
            }
            if(i > 0 && gameGrid[i+1][j+1] == 1){
                neighbors++;
            }
            if(neighbors < 2){
                gameGrid[i][j] = 0;
            }
            if(neighbors == 2 && cell ==1 || neighbors == 3 && cell == 1){
                gameGrid[i][j] = 1;
            }
            if(neighbors > 3){
                gameGrid[i][j] = 0;
            }
            if(neighbors == 3 && cell == 0){
                gameGrid[i][j] = 1;
            }
        }
    }

}
}
