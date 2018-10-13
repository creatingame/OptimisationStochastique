import javax.swing.*;
import java.awt.*;

public class DrawLine extends JPanel {
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawLine(50, 50, 200, 250);
	}
}
