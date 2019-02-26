import java.awt.Color;

public class Tree extends Square {

	public Tree(int x, int y, int side, Color color, int row, int col, Model myModel) {
		super(x, y, side, color, row, col, myModel);
		
	}

	@Override
	public void update(Model sender) { 
		updateState();
		updateNeighbors(sender);
	}

	private void updateNeighbors(Model sender) { 
		
		Square[] n = { left(), right(), up(), down(), leftUp(), leftDown(), rightUp(), rightDown() };

		for (int i = 0; i < n.length; i++) {
			System.out.println(" neigbor :" + i);
			updateIndividualNeigh(n[i], sender);
		}
	}

	private void updateIndividualNeigh(Square sq, Model sender) { 
		if (sq != null && sq instanceof Tree) {
			Tree tree = (Tree) sq;

			if (tree.getColor().equals(Color.GREEN)) {

				if (isOnFire) {
					tree.setColor(Color.red);
					sender.ThisWIllBeOnFire.add(tree);
				}
			}
		}
		

	}

	private void updateState() { 

		if (this.getColor().equals(Color.red)) {
			this.setColor(Color.ORANGE);
		} else if (this.getColor().equals(Color.ORANGE)) {
			this.setColor(Color.DARK_GRAY);
		}
		

	}

}
