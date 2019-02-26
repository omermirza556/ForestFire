import java.awt.Color;
import java.awt.Graphics;

public class Square {
	private int x;
	private int y;
	private int side;
	private int row;
	private int col;
	private Color color;
	boolean isOnFire;
	public Model myModel;
	private Square[][] field;

	public Square(int x, int y, int side, Color color, int row, int col, Model myModel) {
		this.x = x;
		this.y = y;
		this.side = side;
		this.color = color;
		isOnFire = false;
		field = myModel.returnSquares();
		this.row = row;
		this.col = col;

	}

	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.side, this.side);
	}

	public void onFire() {
		if (isOnFire == false) {
			isOnFire = true;
		}
	}

	public Square left() {
		if (row > 0 && row < 255) {
			field[row - 1][col].onFire();
			return field[row - 1][col];

		}
		return null;

	}

	public Square right() {
		if (row > 0 && row < 255) {
			field[row + 1][col].onFire();
			return field[row + 1][col];
		}
		return null;
	}

	public Square down() {
		if (col > 0 && col < 191) {
			field[row][col + 1].onFire();
			return field[row][col + 1];
		}
		return null;
	}

	public Square up() {
		if (col > 0 && col < 191) {
			field[row][col - 1].onFire();
			return field[row][col - 1];
		}
		return null;
	}

	public Square rightUp() {
		if ((row > 0 && row < 255) && (col > 0 && col < 191)) {
			field[row + 1][col - 1].onFire();
			return field[row + 1][col - 1];
		}
		return null;
	}

	public Square rightDown() {
		if ((row > 0 && row < 255) && (col > 0 && col < 191)) {
			field[row + 1][col + 1].onFire();
			return field[row + 1][col + 1];
		}
		return null;
	}

	public Square leftUp() {
		if ((row > 0 && row < 255) && (col > 0 && col < 191)) {
			field[row - 1][col - 1].onFire();
			return field[row - 1][col - 1];
		}
		return null;
	}

	public Square leftDown() {
		if ((row > 0 && row < 255) && (col > 0 && col < 191)) {
			field[row - 1][col + 1].onFire();
			return field[row - 1][col + 1];
		}
		return null;
	}

	public void update(Model sender) {

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

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
