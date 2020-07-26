import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static int countGreen = 0;

	public static void main(String[] args) {
		Game game = new Game();

		game.Game();

		int[][] array = game.generationZero;

		for (int i = 1; i <= game.getN(); i++) {
			loopOverArray(array, game.getX1(), game.getY1());
		}
		;

		// System.out.println("x1 " + game.getX1() + " y1 " + game.getY1());
		// System.out.println("N " + game.getN());

		System.out.println("green => " + countGreen);
	}

	public static ArrayList<Integer> getSurroundings(int[][] array, int x, int y) {

		ArrayList<Integer> al = new ArrayList<Integer>();
		int width = 1; // change the value of width, according to the requirement
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if ((i == (x - width) && ((y + width) >= j && j >= (y - width)))
						|| (i == (x + width) && ((y + width) >= j && j >= (y - width)))
						|| (j == (y - width) && ((x + width) >= i && i >= (x - width)))
						|| (j == (y + width) && ((x + width) >= i && i >= (x - width)))) {

					{
						al.add(array[i][j]);
					}
				}
			}
		}
		// System.out.println(al);
		return al;
	}

	public static int[][] loopOverArray(int[][] array, int x, int y) {

		int green = 0;
		int red = 0;

		if (array[x][y] == 1)
			countGreen++;
		
		int[][] copyArray = array;

		for (int col = 0; col < array.length; col++) {
			for (int row = 0; row < array.length; row++) {

				// System.out.println(array[col][row]);
				ArrayList<Integer> arrayList = getSurroundings(array, col, row);
				for (Integer integer : arrayList) {
					if (integer == 0)
						red++;
					if (integer == 1)
						green++;
				}
				// System.out.println("green: " + green);
				// System.out.println("red: " + red);

				if (array[col][row] == 0) {
					if (green == 3 || green == 6)
						copyArray[col][row] = 1;
					if (green == 0 || green == 1 || green == 4 || green == 5 || green == 7 || green == 8)
						copyArray[col][row] = 0;
				}
				
				if (array[col][row] == 1) {
					if (green == 0 || green == 1 || green == 4 || green == 5 || green == 7 || green == 8)
						copyArray[col][row] = 0;
					if (green == 2 || green == 3 || green == 6)
						copyArray[col][row] = 1;
				}

				green = 0;
				red = 0;

			}
		}
		return copyArray;
	}

}
