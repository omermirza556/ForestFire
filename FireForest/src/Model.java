import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Model {
	Square[][] SQuare;
	int row;
	int col;
	int side;

	ArrayList<Square> THISSQUAREISONFIRE;
	ArrayList<Square> ThisWIllBeOnFire;

	public Model() {
		THISSQUAREISONFIRE = new ArrayList<Square>();
		ThisWIllBeOnFire = new ArrayList<Square>();
		row = 256;
		col = 192;
		side = 4;
		SQuare = new Square[row][col];
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {

				if (randomColor().equals(Color.gray)) {
					SQuare[i][k] = new Square(side * i, side * k, side, Color.GRAY, i, k, this);
				} else {
					SQuare[i][k] = new Tree(side * i, side * k, side, Color.GREEN, i, k, this);
				}

			}
		}

	}

	public void checkFire() {
		ArrayList<Square> trash = new ArrayList<Square>();

		for (int i = 0; i < ThisWIllBeOnFire.size(); i++) {
			THISSQUAREISONFIRE.add(ThisWIllBeOnFire.get(i));
		}

		ThisWIllBeOnFire.clear();

		for (Square plot : THISSQUAREISONFIRE) {

			plot.update(this);
			if (plot.getColor().equals(Color.DARK_GRAY)) {
				trash.add(plot);
			}

		}

		for (Square plot : trash) {
			THISSQUAREISONFIRE.remove(plot);
		}
	}

	private Color randomColor() {
		Random rand = new Random();
		int theColorNumber = rand.nextInt(100);

		if (theColorNumber < 50) {
			return Color.gray;
		} else {
			return Color.GREEN;
		}
	}

	public Square[][] returnSquares() {
		return SQuare;
	}

	public void clicked(int x, int y) {
		if (SQuare[x / side][y / side].getColor() == Color.GREEN) {
			SQuare[x / side][y / side].setColor(Color.red);
			SQuare[x / side][y / side].onFire();
			THISSQUAREISONFIRE.add(SQuare[x / side][y / side]);
		}

	}

	public int returnRowLength() {
		return row;
	}

	public int returnColLength() {
		return col;
	}

	public ArrayList<Square> returnSquaresArray() {
		return THISSQUAREISONFIRE;
	}

}
