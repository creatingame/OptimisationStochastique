import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class CircuitPanel extends JPanel {

	private Ville[] villes;
	private double[][] coordinateData;
	private double proportion;

	public CircuitPanel(double[][] coordinateData1, double proportion1) {
		this.coordinateData = coordinateData1;
		this.proportion = proportion1;
	}

	public CircuitPanel() {
		villes = new Ville[0];
		this.coordinateData = new double[0][3];
		proportion = 1;

	}

	public void setVilles(Ville[] villes1) {
		// TODO Auto-generated method stub
		this.villes = villes1;
		double xMax = -1;
		double xMin = -1;
		double yMax = -1;
		double yMin = -1;
		for (int i = 0; i < villes.length; i++) {
			if (xMax == -1 || villes[i].x > xMax)
				xMax = villes[i].x;
			if (xMin == -1 || villes[i].x < xMin)
				xMin = villes[i].x;
			if (yMax == -1 || villes[i].y > yMax)
				yMax = villes[i].y;
			if (yMin == -1 || villes[i].y < yMin)
				yMin = villes[i].y;
		}
		if ((xMax - xMin) > (710 / 480 * (yMax - yMin)))
			proportion = 710 / (xMax - xMin);
		else
			proportion = 480 / (yMax - yMin);
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

		for (int i = 1; i < villes.length; i++) {
			g.drawOval((int) (villes[i - 1].x * proportion) - 1,
					(int) (villes[i -1].y * proportion) - 1, 2, 2);
			g.drawLine((int) (villes[i - 1].x * proportion), (int) (villes[i -1].y * proportion),
					(int) (villes[i].x * proportion), (int) (villes[i].y * proportion));
		}
		g.drawOval((int) (villes[villes.length - 1].x * proportion) - 1,
				(int) (villes[villes.length - 1].y * proportion) - 1, 2, 2);
		g.drawLine((int) (villes[villes.length - 1].x * proportion),
				(int) (villes[villes.length - 1].y * proportion),
				(int) (villes[0].x * proportion), (int) (villes[0].y * proportion));
		/*
		for (int i = 1; i < coordinateData.length; i++) {
			g.drawOval((int) (coordinateData[i - 1][1] * proportion) - 1,
					(int) (coordinateData[i - 1][2] * proportion) - 1, 2, 2);
			g.drawLine((int) (coordinateData[i - 1][1] * proportion), (int) (coordinateData[i - 1][2] * proportion),
					(int) (coordinateData[i][1] * proportion), (int) (coordinateData[i][2] * proportion));
		}
		g.drawOval((int) (coordinateData[coordinateData.length - 1][1] * proportion) - 1,
				(int) (coordinateData[coordinateData.length - 1][2] * proportion) - 1, 2, 2);
		g.drawLine((int) (coordinateData[coordinateData.length - 1][1] * proportion),
				(int) (coordinateData[coordinateData.length - 1][2] * proportion),
				(int) (coordinateData[0][1] * proportion), (int) (coordinateData[0][2] * proportion));
		*/
	}

}
