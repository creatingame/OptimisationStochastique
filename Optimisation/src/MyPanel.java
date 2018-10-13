import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {

	private double[][] coordinate;
	private double proportion;

	public MyPanel(double[][] coordinate1, double proportion1) {
		this.coordinate = coordinate1;
		this.proportion = proportion1;
	}

	public MyPanel() {
		this.coordinate = new double[0][3];
		proportion = 1;

	}

	public void setCoordinate(double[][] coordinate1) {
		this.coordinate = coordinate1;
	}

	public void setProportion(double proportion1) {
		this.proportion = proportion1;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.RED);

		for (int i = 1; i < coordinate.length; i++) {
			g.drawLine((int) (coordinate[i - 1][1] * proportion), (int) (coordinate[i - 1][2] * proportion),
					(int) (coordinate[i][1] * proportion), (int) (coordinate[i][2] * proportion));
		}

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
