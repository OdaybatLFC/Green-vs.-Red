import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The driver class that reads the input and prints the result
 * @author A.Odaybat
 */
public class Driver {

	public static void main(String[] args) {
		System.out.println("Welcome to Aleksandar Odaybat's 'Green vs. Red' assignment solution!");
		System.out.println("Please specify the grid size. ");
		Scanner input = new Scanner(System.in);
		int width, height, x1, y1, N;
		while(true) {
			System.out.println("Width(x): ");
			try {
				width = input.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input! Width must be an integer!");
				input.next();
				continue;
			}
			if(width > 999 || width < 1) {
				System.out.println("Invalid input! Width must be a positive integer less than 1000!");
				continue;
			}
			break;
		}
		while(true) {
			System.out.println("Height(y): ");
			try {
				height = input.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input! Height must be an integer!");
				input.next();
				continue;
			}
			if(height > 999 || height < width) {
				System.out.println("Invalid input! Height must be between [" + width + ", 999]!");
				continue;
			}
			break;
		}
		Grid g = new Grid(width, height);
		g.printGrid();
		System.out.println("\n\nNow specify the coordinates of a cell in the grid.");
		while(true) {
			System.out.println("X: ");
			try {
				x1 = input.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input! x must be an integer!");
				input.next();
				continue;
			}
			if(x1 < 0 || x1 >= width) {
				System.out.println("Invalid input! Your x coordinate is out of bound! It must be between [" + 0 + ", " + (width-1) + "].");
				continue;
			}
			break;
		}
		while(true) {
			System.out.println("Y: ");
			try {
				y1 = input.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input! y must be an integer!");
				input.next();
				continue;
			}
			if(y1 < 0 || y1 >= height) {
				System.out.println("Invalid input! Your y coordinate is out of bound! It must be between [" + 0 + ", " + (height-1) + "].");
				continue;
			}
			break;
		}
		while(true) {
			System.out.println("Finally choose the number of generations to test how many times the cell will be green:");
			try {
				N = input.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input! N must be an integer!");
				input.next();
				continue;
			}
			if(N < 0) {
				System.out.println("Invalid input! N must not be negative!");
				continue;
			}
			break;
		}
		int result = g.countGreen(y1, x1, N);
		System.out.println("The cell with coordinates [" + x1 + ", " + y1 +"] was " + result + " time(s) green"
				+ " between Generation 0 and Generation " + N + "!");
		input.close();
		System.exit(0);
	}

}
