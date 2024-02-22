package studio4;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
		String shape = in.next();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		boolean fill = in.nextBoolean();
		double x1 = in.nextDouble();
		double y1 = in.nextDouble();
		double x2 = in.nextDouble();
		double y2 = in.nextDouble();
		
		Color custom = new Color(r,g,b);
		StdDraw.setPenColor(custom);
		
		
		if (shape.equals("ellipse")) {
			if (fill == true) {
				StdDraw.filledEllipse(x1, y1, x2, y2);
			}
			StdDraw.ellipse(x1, y1, x2, y2);
		
		}
		if (shape.equals("rectangle")) {
			if (fill == true) {
				StdDraw.filledRectangle(x1, y1, x2, y2);
			}
			StdDraw.rectangle(x1, y1, x2, y2);
		
		}
		if (shape.equals("triangle")) {
			double x3 = in.nextDouble();
			double y3 = in.nextDouble();
			
			double coordinatesx[] = {x1, x2, x3};
			double coordinatesy[] = {y1, y2, y3};

			if (fill == true) {
				StdDraw.filledPolygon(coordinatesx, coordinatesy);
			}
			StdDraw.polygon(coordinatesx, coordinatesy);
		
		}
		
		
	}
}
