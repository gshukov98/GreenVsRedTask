import java.util.Arrays;
import java.util.Scanner;

public class Game {
	int[] gridXandY;
	int x,y,x1,y1,n;
	int[][] generationZero;
	int[] gameArgs;
	
	public void Game() {
		gridXandY = gridXY();
		while (gridXandY[0] > gridXandY[1] || gridXandY[1] >= 1000 )
			gridXandY = gridXY();
		x = gridXandY[0];
		y = gridXandY[1];
		
		
		generationZero = generationZero(x, y);
		printArray(generationZero);
		gameArgs = inputArguments();
		x1 = gameArgs[0];
		y1 = gameArgs[1];
		n = gameArgs[2];

	}

	public int[] gridXY() {
		Scanner input = new Scanner(System.in);
		int[] grid = new int[2];
		System.out.println("Въведете X и Y със разделител space: ");
		for (int i = 0; i < grid.length; i++) {
			grid[i] = (input.hasNext() == true ? input.nextInt() : null);
		}

		return grid;
	}

	public int[][] generationZero(int cols, int rows) {
		 Scanner input = new Scanner(System.in);
		 System.out.printf("Въведете по %d елемента на ред %d реда. С разделител space.\n",cols,rows);
		 int[][] array = new int[rows][cols];
	        for (int i = 0; i < array.length; i++) 
	        {
	            for (int j = 0; j < array[i].length; j++)
	                array[i][j] = input.nextInt();
	        }
	        return array;
	    }
		

	public void printArray(int array[][]) {
		// обхожда всички редове на масива
		for (int[] row : array)

			// принтира текущия ред
			System.out.println(Arrays.toString(row));
	}

	public int[] inputArguments() {
		Scanner input = new Scanner(System.in);
		int[] gameArguments = new int[3];
		System.out.println("Въведете X1, Y1 и N със разделител space: ");
		for (int i = 0; i < gameArguments.length; i++) {
			gameArguments[i] = (input.hasNext() == true ? input.nextInt() : null);
		}
		return gameArguments;
	}
	
	//getters and setters
	
	public int[] getGridXandY() {
		return gridXandY;
	}

	public void setGridXandY(int[] gridXandY) {
		this.gridXandY = gridXandY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int[][] getGenerationZero() {
		return generationZero;
	}

	public void setGenerationZero(int[][] generationZero) {
		this.generationZero = generationZero;
	}

	public int[] getGameArgs() {
		return gameArgs;
	}

	public void setGameArgs(int[] gameArgs) {
		this.gameArgs = gameArgs;
	}


}
