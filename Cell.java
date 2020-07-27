/**
 * Class for creating Cell objects
 * @author A.Odaybat
 */
public class Cell {
	
	private int value;
	
	public Cell(int value) {
		this.value = value;
	}

	/**
	 * Getting the value of the cell 
	 * @return The value of the cell
	 */
	public int getValue() {
		return value;
	}
    /**
    * Changing the value of the cell
    * @param The value to be inserted
    */
	public void setValue(int v) {
		value = v;
	}

}