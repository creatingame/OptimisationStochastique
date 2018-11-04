import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class MyPanel extends JPanel {

	private double[][] coordinateData;
	private double proportion;

	public MyPanel(double[][] coordinateData1, double proportion1) {
		this.coordinateData = coordinateData1;
		this.proportion = proportion1;
	}

	public MyPanel() {
		this.coordinateData = new double[0][3];
		proportion = 1;

	}

	public void setCoordinate(double[][] coordinate1) {
		this.coordinateData = coordinate1;
	}

	public void setProportion(double proportion1) {
		this.proportion = proportion1;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.RED);

		for (int i = 1; i < coordinateData.length; i++) {
			g.drawOval((int) (coordinateData[i - 1][1] * proportion) - 1,
					(int) (coordinateData[i - 1][2] * proportion) - 1, 2, 2);
			g.drawLine((int) (coordinateData[i - 1][1] * proportion), (int) (coordinateData[i - 1][2] * proportion),
					(int) (coordinateData[i][1] * proportion), (int) (coordinateData[i][2] * proportion));
		}
		g.drawOval((int) (coordinateData[coordinateData.length-1][1] * proportion) - 1,
				(int) (coordinateData[coordinateData.length-1][2] * proportion) - 1, 2, 2);
		g.drawLine((int) (coordinateData[coordinateData.length-1][1] * proportion), (int) (coordinateData[coordinateData.length-1][2] * proportion),
				(int) (coordinateData[0][1] * proportion), (int) (coordinateData[0][2] * proportion));

		/*
		 * for (int i = 0; i < 10; i++) { g.drawLine(10, 10 + i * 20, this.getWidth() -
		 * 10, 10 + i * 20); }
		 * 
		 * for (int i = 0; i < 10; i++) { g.drawLine(10 + i * 20, 10, 10 + i * 20,
		 * this.getHeight() - 10); }
		 */

	}
	/*
	 * public static void main(String[] args) { JFrame f1 = new JFrame();
	 * f1.setSize(400, 400); f1.setLocationRelativeTo(null);
	 * f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * 
	 * MyPanel panel = new MyPanel(); f1.add(panel, BorderLayout.CENTER);
	 * f1.setVisible(true); }
	 */
}
