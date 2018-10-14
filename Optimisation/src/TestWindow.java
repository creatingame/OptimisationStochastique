import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.image.BufferStrategy;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JButton;

public class TestWindow {

	private JFrame frmProblmeDuVoyager;
	private MyPanel canvas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow window = new TestWindow();
					window.frmProblmeDuVoyager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestWindow() {
		initialize();
		DataInput data1 = new DataInput(
				"C:\\Users\\vince\\Documents\\eclipse-workspace\\CoodinateResult\\src\\a280-result.tsp");
		data1.outputInfo();
		canvas.setCoordinate(data1.getCoordinate());
		canvas.setProportion(data1.getProportion());

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProblmeDuVoyager = new JFrame();
		frmProblmeDuVoyager.setTitle("Probl\u00E8me du voyager de commerce");
		frmProblmeDuVoyager.setBounds(100, 100, 1080, 640);
		frmProblmeDuVoyager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProblmeDuVoyager.getContentPane().setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "recuit pour le TSP (d\u00E9terministe)", "recuit pour le TSP (stochastique)",
						"programme lin\u00E9aire (d\u00E9terministe)", "programme lin\u00E9aire (stochastique)" }));
		comboBox.setBounds(22, 40, 240, 22);
		frmProblmeDuVoyager.getContentPane().add(comboBox);
		// splitPane.add(comboBox,1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Data 1", "Data 2", "Data 3", "Data 4" }));
		comboBox_1.setBounds(22, 118, 240, 22);
		frmProblmeDuVoyager.getContentPane().add(comboBox_1);
		// splitPane.add(comboBox_1);

		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setLabelFor(comboBox_1);
		lblNewLabel.setBounds(22, 96, 240, 19);
		frmProblmeDuVoyager.getContentPane().add(lblNewLabel);

		JLabel lblAlgorithme = new JLabel("Algorithme");
		lblAlgorithme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAlgorithme.setBounds(22, 18, 240, 19);
		frmProblmeDuVoyager.getContentPane().add(lblAlgorithme);

		JLabel lblParamtre = new JLabel("Param\u00E8tre");
		lblParamtre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblParamtre.setBounds(22, 168, 240, 19);
		frmProblmeDuVoyager.getContentPane().add(lblParamtre);

		JPanel panel = new JPanel();
		int numParametre = 9;
		int panelHeight;
		if (40 * numParametre < 340)
			panelHeight = 40 * numParametre;
		else
			panelHeight = 340;
		panel.setBounds(22, 198, 240, panelHeight);
		frmProblmeDuVoyager.getContentPane().add(panel);
		panel.setLayout(new GridLayout(numParametre, 2, 10, 10));

		canvas = new MyPanel();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(297, 41, 750, 500);
		canvas.setVisible(true);
		canvas.setFocusable(false);
		frmProblmeDuVoyager.getContentPane().add(canvas);

		JLabel lblGraphe = new JLabel("Graphe");
		lblGraphe.setLabelFor(canvas);
		lblGraphe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblGraphe.setBounds(297, 18, 240, 19);
		frmProblmeDuVoyager.getContentPane().add(lblGraphe);

		JButton btnNewButton = new JButton("Commencer");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(22, 554, 240, 28);
		frmProblmeDuVoyager.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Nombre de sommets:");
		lblNewLabel_1.setBounds(297, 551, 141, 16);
		frmProblmeDuVoyager.getContentPane().add(lblNewLabel_1);

		JLabel lblLongeurOptimalTrouv = new JLabel("Longeur optimal trouv\u00E9:");
		lblLongeurOptimalTrouv.setBounds(297, 568, 141, 16);
		frmProblmeDuVoyager.getContentPane().add(lblLongeurOptimalTrouv);

		for (int i = 0; i < numParametre; i++) {
			panel.add(new JLabel("Parametre " + (i + 1)));
			JTextField jtfName = new JTextField();
			jtfName.setSize(10, 5);
			panel.add(jtfName);
		}

	}

}
