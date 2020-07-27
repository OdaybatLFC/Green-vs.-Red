/**
 * Class repsresenting all the rules
 * @author A.Odaybat
 */
public class Rules {
	
	/**
	 * Method for applying all the rules 
	 */
	public void apply(Grid g) {
		Cell[][] grid = g.getGrid();
		Grid copy = g.copyGrid(); // We need a copy 
		for(int i = 0; i < g.getHeight(); i++) {
			for(int j = 0; j < g.getWidth(); j++) {
				Cell current = grid[i][j];
				// Check green cell count of the copy grid which is not being modified 
				if(current.getValue() == 0 && (copy.count(i, j) == 3 || copy.count(i, j) == 6)) {
					current.setValue(1); // modify the original grid
				}
				if(current.getValue() == 1 && !(copy.count(i, j) == 2 || copy.count(i, j) == 3 || copy.count(i, j) == 6)) {						
					current.setValue(0);
				}
			}
		}
	}
	
}