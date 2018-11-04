import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import java.awt.Component;
import java.awt.Canvas;
import javax.swing.JButton;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

public class GUIWindow {

	private JFrame frmProblemeDuVoyager;
	private MyPanel canvas;
	
	private static int algorithmChosenIndex;
	private static String dataAddress; // The address of data chosen by client
	
	private int numbreSommets; // numbreSommets must be haven by Manager.
	
	private DataInput data; // The result of algorithm.
	private double longeurOptimal; // The result of algorithm.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIWindow window = new GUIWindow();
					window.frmProblemeDuVoyager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIWindow() {
		
		initialize();
		
		/**
		 * 1) numbreSommets must be haven by Manager.
		 * 2) longeurOptimal must be haven by Algorithm. 
		 */
		numbreSommets = 280; // numbreSommets must be haven by Manager.
		longeurOptimal = 23154.12; //longeurOptimal must be haven by Algorithm. 
		
		/**
		 * 1) The 1st parameter of DataInput data is the document of the result of algorithm.
		 * We use "C:\\Users\\vince\\Documents\\eclipse-workspace\\CoodinateResult\\src\\a280-result.tsp" for example.
		 * 2) data.outputInfo() is just for checking the data information in the console. It can be deleted.
		 */
		data = new DataInput(
				"C:\\Users\\vince\\Documents\\eclipse-workspace\\CoodinateResult\\src\\a280-result.tsp",numbreSommets); //Address of result must be haven by Algorithm.  
		data.outputInfo();
		
		//initialize();
		
		canvas.setCoordinate(data.getCoordinate());
		canvas.setProportion(data.getProportion());


	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProblemeDuVoyager = new JFrame();
		frmProblemeDuVoyager.setTitle("Probl\u00E8me du voyager de commerce");
		frmProblemeDuVoyager.setBounds(100, 100, 1080, 640);
		frmProblemeDuVoyager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProblemeDuVoyager.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		int numParametre = 4;
		int panelHeight;
		if (40 * numParametre < 310)
			panelHeight = 40 * numParametre;
		else
			panelHeight = 310;
		panel.setBounds(22, 228, 240, panelHeight);
		frmProblemeDuVoyager.getContentPane().add(panel);
		panel.setLayout(new GridLayout(numParametre, 2, 10, 10));
		
		//parameter of "recuit pour le TSP (deterministe)" as default
		panel.add(new JLabel("Temp "));
		JTextField jtfName = new JTextField();
		jtfName.setSize(10, 5);
		panel.add(jtfName);
		panel.add(new JLabel("iter "));
		JTextField jtfName1 = new JTextField();
		jtfName1.setSize(10, 5);
		panel.add(jtfName1);
		panel.add(new JLabel("refroid "));
		JTextField jtfName2 = new JTextField();
		jtfName1.setSize(10, 5);
		panel.add(jtfName2);
		panel.add(new JLabel("kopt "));
		JTextField jtfName3 = new JTextField();
		jtfName1.setSize(10, 5);
		panel.add(jtfName3);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "recuit pour le TSP (d\u00E9terministe)", "recuit pour le TSP (stochastique)",
						"programme lin\u00E9aire (d\u00E9terministe)", "programme lin\u00E9aire (stochastique)" }));
		comboBox.setBounds(22, 40, 240, 22);
		frmProblemeDuVoyager.getContentPane().add(comboBox);
		// splitPane.add(comboBox,1);
		
		 // 添加条目选中状态改变的监听器
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("algorithmChosenIndex: " + comboBox.getSelectedIndex() + " = " + comboBox.getSelectedItem());
                    algorithmChosenIndex = comboBox.getSelectedIndex();
                    
                    switch(comboBox.getSelectedIndex()) {
                    case 0: // select recuit pour le TSP (deterministe)
                    	panel.removeAll();
                    	panel.repaint();
                    	int numParametre = 4;
                		//panelHeight = 40 * numParametre;
                		panel.setBounds(22, 228, 240, 40*4);
                		frmProblemeDuVoyager.getContentPane().add(panel);
                		panel.setLayout(new GridLayout(numParametre, 2, 10, 10));
                		panel.add(new JLabel("temp "));
            			JTextField jtfName = new JTextField();
            			jtfName.setSize(10, 5);
            			panel.add(jtfName);
            			panel.add(new JLabel("iter "));
            			JTextField jtfName1 = new JTextField();
            			jtfName1.setSize(10, 5);
            			panel.add(jtfName1);
            			panel.add(new JLabel("refroid "));
            			JTextField jtfName2 = new JTextField();
            			jtfName1.setSize(10, 5);
            			panel.add(jtfName2);
            			panel.add(new JLabel("kopt "));
            			JTextField jtfName3 = new JTextField();
            			jtfName1.setSize(10, 5);
            			panel.add(jtfName3);
            			panel.revalidate();
                    	break;
                    case 1:
                    	panel.removeAll();
                    	panel.repaint();
                    	int numParametre1 = 5;
                		//panelHeight = 40 * numParametre;
                		panel.setBounds(22, 228, 240, 40*5);
                		frmProblemeDuVoyager.getContentPane().add(panel);
                		panel.setLayout(new GridLayout(numParametre1, 2, 10, 10));
                		panel.add(new JLabel("temp "));
            			JTextField jtfName4 = new JTextField();
            			jtfName4.setSize(10, 5);
            			panel.add(jtfName4);
            			panel.add(new JLabel("iter "));
            			JTextField jtfName5 = new JTextField();
            			jtfName5.setSize(10, 5);
            			panel.add(jtfName5);
            			panel.add(new JLabel("refroid "));
            			JTextField jtfName6 = new JTextField();
            			jtfName5.setSize(10, 5);
            			panel.add(jtfName6);
            			panel.add(new JLabel("kopt "));
            			JTextField jtfName7 = new JTextField();
            			jtfName5.setSize(10, 5);
            			panel.add(jtfName7);
            			panel.add(new JLabel("variance "));
            			JTextField jtfName8 = new JTextField();
            			jtfName5.setSize(10, 5);
            			panel.add(jtfName8);
            			panel.revalidate();
                    	break; 
                    case 2:
                    case 3:
                    	panel.removeAll();
                    	panel.repaint();
                    	int numParametre2 = 5;
                    	panel.setBounds(22, 228, 240, 40*5);
                		frmProblemeDuVoyager.getContentPane().add(panel);
                		panel.setLayout(new GridLayout(numParametre2, 2, 10, 10));
                    	for (int i = 0; i < numParametre2; i++) {
                			panel.add(new JLabel("Parametre " + (i + 1)));
                			JTextField jtfName11 = new JTextField();
                			jtfName11.setSize(10, 5);
                			panel.add(jtfName11);
                		}
                    	panel.revalidate();
                    	break; 
                    }
                }
            }
        });

        // 设置默认选中的条目
        //comboBox.setSelectedIndex(0);

		/*
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Data 1", "Data 2", "Data 3", "Data 4" }));
		comboBox_1.setBounds(22, 118, 240, 22);
		frmProblemeDuVoyager.getContentPane().add(comboBox_1);
		// splitPane.add(comboBox_1);
		*/
		
		JTextArea dataChosenText = new JTextArea();
		dataChosenText.setLineWrap(true);
		dataChosenText.setBounds(22, 118, 240, 22);
		frmProblemeDuVoyager.getContentPane().add(dataChosenText);
		
		JButton openBtn = new JButton("Ouvrir le fichier");
		openBtn.setBounds(22, 146, 240, 24);
		openBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFileOpenDialog(frmProblemeDuVoyager, dataChosenText);
            }
        });
		frmProblemeDuVoyager.getContentPane().add(openBtn);
		

		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setLabelFor(dataChosenText);
		lblNewLabel.setBounds(22, 96, 240, 19);
		frmProblemeDuVoyager.getContentPane().add(lblNewLabel);

		JLabel lblAlgorithme = new JLabel("Algorithme");
		lblAlgorithme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAlgorithme.setBounds(22, 18, 240, 19);
		frmProblemeDuVoyager.getContentPane().add(lblAlgorithme);

		JLabel lblParamtre = new JLabel("Param\u00E8tre");
		lblParamtre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblParamtre.setBounds(22, 198, 240, 19);
		frmProblemeDuVoyager.getContentPane().add(lblParamtre);


		canvas = new MyPanel();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(297, 41, 750, 500);
		canvas.setVisible(true);
		canvas.setFocusable(false);
		frmProblemeDuVoyager.getContentPane().add(canvas);

		JLabel lblGraphe = new JLabel("Graphe");
		lblGraphe.setLabelFor(canvas);
		lblGraphe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblGraphe.setBounds(297, 18, 240, 19);
		frmProblemeDuVoyager.getContentPane().add(lblGraphe);

		JButton btnNewButton = new JButton("Commencer");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(22, 554, 240, 28);
		frmProblemeDuVoyager.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Nombre de sommets:");
		lblNewLabel_1.setBounds(297, 551, 141, 16);
		frmProblemeDuVoyager.getContentPane().add(lblNewLabel_1);

		JLabel lblLongeurOptimalTrouv = new JLabel("Longeur optimal trouv\u00E9:");
		lblLongeurOptimalTrouv.setBounds(297, 568, 141, 16);
		frmProblemeDuVoyager.getContentPane().add(lblLongeurOptimalTrouv);
		
		JLabel lblNewLabel_3 = new JLabel(""+ numbreSommets);
		lblNewLabel_1.setLabelFor(lblNewLabel_3);
		lblNewLabel_3.setBounds(475, 551, 47, 16);
		frmProblemeDuVoyager.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(""+ longeurOptimal);
		lblLongeurOptimalTrouv.setLabelFor(lblNewLabel_4);
		lblNewLabel_4.setBounds(475, 568, 62, 16);
		frmProblemeDuVoyager.getContentPane().add(lblNewLabel_4);

		/*
		for (int i = 0; i < numParametre; i++) {
			panel.add(new JLabel("Parametre " + (i + 1)));
			JTextField jtfName = new JTextField();
			jtfName.setSize(10, 5);
			panel.add(jtfName);
		}
		*/

	}
	
	/*
     * Ouvrir le fichier
     */
    private static void showFileOpenDialog(Component parent, JTextArea msgTextArea) {
        // 创建一个默认的文件选取器
        JFileChooser fileChooser = new JFileChooser();

        // 设置默认显示的文件夹为当前文件夹
        fileChooser.setCurrentDirectory(new File("./src"));

        // 设置文件选择的模式（只选文件、只选文件夹、文件和文件均可选）
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // 设置是否允许多选
        fileChooser.setMultiSelectionEnabled(false);

        /*
        // 添加可用的文件过滤器（FileNameExtensionFilter 的第一个参数是描述, 后面是需要过滤的文件扩展名 可变参数）
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("zip(*.zip, *.rar)", "zip", "rar"));
        // 设置默认使用的文件过滤器
        fileChooser.setFileFilter(new FileNameExtensionFilter("image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));
		*/
        
        // 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
        int result = fileChooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {
            // 如果点击了"确定", 则获取选择的文件路径
            File file = fileChooser.getSelectedFile();

            // 如果允许选择多个文件, 则通过下面方法获取选择的所有文件
            // File[] files = fileChooser.getSelectedFiles();

            //msgTextArea.append("打开文件: " + file.getAbsolutePath() + "\n\n");
            msgTextArea.append(file.getName());
            
            dataAddress = file.getAbsolutePath(); 
        }
    }

}
