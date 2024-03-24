import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
public class GeometricShapesJTextArea {

	public static void main(String[] args) {
		int shapeNumber, userConfirmation = 3;
		double radius, height;
		String displayProp;
		do {
			shapeNumber = getShape();
			//System.out.println(shapeNumber); - testing purposes
			if (shapeNumber == -1) {
				userConfirmation = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
			}
			else if (shapeNumber == 2) {
				ImageIcon img = new ImageIcon("Sphere.jpg");
				radius = getInput("Radius");
				displayProp = getSphereProperties(radius);
				displayProperties(displayProp, "Sphere", img);
			}
			else if (shapeNumber == 1) {
				ImageIcon img = new ImageIcon("Cylinder.jpg");
				radius = getInput("Radius");
				height = getInput("Height");
				displayProp = getCylinderProperties(radius, height);
				displayProperties(displayProp, "Cylinder", img);
			}
			else {
				ImageIcon img = new ImageIcon("Circle.jpg");
				radius = getInput("Radius");
				displayProp = getCircleProperties(radius);
				displayProperties(displayProp, "Circle", img);
			}
		}//end of do-while loop
		while (userConfirmation != 0);
		JOptionPane.showMessageDialog(null, "End of Program");
	}//end of main method
	
	public static int getShape() {
		String[] shapes = {"Circle", "Cylinder", "Sphere"};
		int shapeNum;
		shapeNum = JOptionPane.showOptionDialog(null, "Select a shape:", "Geometric Shapes", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, shapes, shapes[0]);
		return shapeNum;
	}//end of getShape method
	
	public static double getInput (String message) {
		String measurement;
		double measurementTwo;
		
		measurement = JOptionPane.showInputDialog(null, message, "Enter the " + message, JOptionPane.QUESTION_MESSAGE);
		measurementTwo = Double.parseDouble(measurement);

		return measurementTwo;
	}//end of getMeasurements method
	
	public static String getCircleProperties(double radCircle)
	{
		String output;
		double area, circumference;
		area = (Math.PI)*Math.pow(radCircle, 2);
		area = Math.round(area*100)/100.0;
		circumference = 2*(Math.PI)*(radCircle);
		circumference = Math.round(circumference*100)/100.0;
		output = "Area:\t" + area + "\nCircumference:\t"+ circumference;
		return output;
	}
	
	public static String getCylinderProperties(double radCylinder, double heightCylinder)
	{
		String output;
		double volume, surfaceArea;
		volume = (Math.PI)*Math.pow(radCylinder, 2)*heightCylinder;
		volume = Math.round(volume*100)/100.0;
		surfaceArea = 2*(Math.PI)*(radCylinder)*(radCylinder+heightCylinder);
		surfaceArea = Math.round(surfaceArea*100)/100.0;
		output = "Volume:\t" + volume + "\nSurface Area:\t"+ surfaceArea;
		return output;
	}
	
	public static String getSphereProperties(double radSphere)
	{
		String output;
		double volume, surfaceArea;
		volume = (4/3.0)*(Math.PI)*Math.pow(radSphere, 3);
		volume = Math.round(volume*100)/100.0;
		surfaceArea = 4*(Math.PI)*Math.pow(radSphere, 2);
		surfaceArea = Math.round(surfaceArea*100)/100.0;
		output = "Volume:\t" + volume + "\nSurface Area:\t"+ surfaceArea;
		return output;
	}
	
	//Displaying the properties using the parameters of the output string and a title string.
	public static void displayProperties(String displayShapeProperties, String title, ImageIcon img)
	{
		JTextArea myArea = new JTextArea();
		Font font = new Font ("Calibri", Font.BOLD, 12);
		myArea.setBackground(Color.gray);
		myArea.setForeground(Color.white);
		myArea.setFont(font);
		myArea.setText(displayShapeProperties);	//Use JTextArea class to use the \t in Dialog Box.
		JOptionPane.showMessageDialog(null, myArea, title, JOptionPane.PLAIN_MESSAGE, img);
	}
}//end of class