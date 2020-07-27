import java.util.ArrayList;
import java.util.Random;

/**
 * Class for creating grid objects 
 * @author A.Odaybat
 */
public class Grid {
	
	private int x;
	private int y;
	private Cell[][] grid;
	
	public Grid(int width, int height) {
		x = width;
		y = height;
		grid = new Cell[y][x];
		generate();
	}
	
	/** Method for generating the grid (i.e GenerationZero) 
	*/
	public void generate() {
		Random generator = new Random();
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				grid[i][j] = new Cell(generator.nextInt(2));  // generates random number between 0 and 1
			}
		}
	}
	
	/** Next 3 methods are simple accessors 
	 * @return width, height and grid, respectively
	 */
	public int getWidth() {
		return x;
	}
	
	public int getHeight() {
		return y;
	}
	
	public Cell[][] getGrid() {
		return grid;
	}
	
	/** 
	 * Method for pritning the grid in the console
	 */
	public void printGrid() {
		for(int i = 0; i < y; i++) {
			System.out.println();
			for(int j = 0; j < x; j++) {
				System.out.print(grid[i][j].getValue());
			}
		}
	}

	/** Method for counting the green neighbours of a cell
	* @param The coordinates of the cell 
	* @return The number of green neighbours
	*/
	public int count(int x1, int y1) {
		int count = 0;
		ArrayList<int[]> arr = neighbours(x1, y1);
		for(int[] elem: arr) {
			if(grid[elem[0]][elem[1]].getValue() == 1) { // if cell is green(1) then we increment count
				count++;
			}
		}
		return count;
	}
	
	/** Method for getting all the neighbours coordinates of a cell 
	* @param The coordinates of the cell 
	* @return List of neighbours with their coordinates 
	*/
	public ArrayList<int[]> neighbours(int x1, int y1) {
		int[][] arr = {{x1-1, y1-1}, {x1, y1-1}, {x1+1, y1-1}, {x1-1, y1},
				{x1+1, y1}, {x1-1, y1+1}, {x1, y1+1}, {x1+1,y1+1}}; // all potential coordinates 
		ArrayList<int[]> neighbours = new ArrayList<>();
		for(int[] element: arr) {
			// we must check if the coordinates are within the bound
			if(element[0] >= 0 && element[1] >= 0 && element[0] < y && element[1] < x) {
				neighbours.add(element);
			}
		}
		return neighbours;  
	}
	
	/**
	 * Method for esitmating how many time the cell was green 
	 * @param Cell's coordinates and the number of generations
	 * @return The number of time the cell was green
	 */
	public int countGreen(int x1, int y1, int N) {
		int count = 0;
		Rules rules = new Rules();
		for(int i = 0; i <= N; i++) {
			if(grid[x1][y1].getValue() == 1) {
				count++;
			}
			rules.apply(this);
		}
		return count;
	}
	
	/**
	 * Simple method for copying grid
	 * @return The copy of the grid
	 */
	public Grid copyGrid() {
		Grid copy = new Grid(x, y);
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				copy.getGrid()[i][j] = new Cell(grid[i][j].getValue());
			}
		}
		return copy;
	}
}