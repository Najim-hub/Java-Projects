package testpack;

public class Cube {

	
	private int side;

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public Cube(int side) {
		super();
		this.side = side;
	}

	public Cube() {
		super();
		
	}
	
	public int getVolume(int side) {
		
		
		side = side*side*side;
		
		return side;
		
		
	}
	
	
	
}
