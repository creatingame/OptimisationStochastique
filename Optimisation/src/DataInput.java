import java.util.*;
import java.io.*;

public class DataInput {
	private double xMax;
	private double xMin;
	private double yMax;
	private double yMin;
	private int dimension = 280;
	private int readDimension;
	private double[][] coordinate;
	private double proportion;

	private String fileAddress = "C:\\Users\\vince\\Documents\\eclipse-workspace\\CoodinateResult\\src\\a280-result.tsp";

	public DataInput(String fileAddress1) {
		this.fileAddress = fileAddress1;
		try {

			Scanner scan = new Scanner(new File(fileAddress));
			coordinate = new double[dimension][3];
			int i = 0;
			int j = 0;
			double n = 0;
			double m = 0;

			xMax = -1;
			xMin = -1;
			yMax = -1;
			yMin = -1;

			while (scan.hasNextLine()) {
				String line = scan.nextLine().trim();
				String[] arr = line.split("\\s+");

				j = Integer.parseInt(arr[0]);
				n = Double.parseDouble(arr[1]);
				m = Double.parseDouble(arr[2]);

				if (xMax == -1 || n > xMax)
					xMax = n;
				if (xMin == -1 || n < xMin)
					xMin = n;
				if (yMax == -1 || m > yMax)
					yMax = m;
				if (yMin == -1 || m < yMin)
					yMin = m;

				coordinate[i][0] = j;
				coordinate[i][1] = n;
				coordinate[i][2] = m;

				i++;

			}
			readDimension = i;
			scan.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void outputInfo() {
		System.out.println("Dimension:" + readDimension);
		System.out.println("xMin:" + xMin);
		System.out.println("xMax:" + xMax);
		System.out.println("yMin:" + yMin);
		System.out.println("yMax:" + yMax);
	}

	public double[][] getCoordinate() {
		return coordinate;
	}

	public double getxMax() {
		return xMax;
	}

	public double getxMin() {
		return xMin;
	}

	public double getyMax() {
		return yMax;
	}

	public double getyMin() {
		return yMin;
	}

	public double getProportion() {
		if ((xMax - xMin) > (710 / 480 * (yMax - yMin)))
			proportion = 710 / (xMax - xMin);
		else
			proportion = 480 / (yMax - yMin);
		return proportion;
	}

}
