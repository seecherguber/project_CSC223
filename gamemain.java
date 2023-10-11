public class gamemain {
   static int GRIDSIZE = 10;
    // This is the main class for the game conway's game of life
    //rule 1: any live cell with fewer than two live neighbors dies, as if by underpopulation
    //rule 2: any live cell with two or three live neighbors lives on to the next generation
    //rule 3: any live cell with more than three live neighbors dies, as if by overpopulation
    //rule 4: any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction
    int [][] gameGrid = new int[GRIDSIZE][GRIDSIZE];
    public static void main(String[] args){
  
   
}

 static void neighborCheck(int [][] gameGrid){
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