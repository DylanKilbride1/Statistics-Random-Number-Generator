import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.util.Random;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField textField;
	private JFormattedTextField textField_1;
	private JFormattedTextField textField_2;
	int start, end, amntNumbers;
	Random r = new Random();
	private MaskFormatter maskF = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Random Number Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblStatisticsRandomNumber = new JLabel("Statistics Random Number Generator");
		lblStatisticsRandomNumber.setForeground(Color.BLUE);
		lblStatisticsRandomNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		panel_1.add(lblStatisticsRandomNumber);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl1 = new JLabel("Enter First Value:");
		lbl1.setPreferredSize(new Dimension(150,40));
		lbl1.setFont(new Font("Ebrima", Font.PLAIN, 15));
		panel_2.add(lbl1, BorderLayout.WEST);
		
		try {
			maskF = new MaskFormatter("#########");
		    maskF.setPlaceholderCharacter(' ');
		} catch (ParseException e) {
		    e.printStackTrace();
		}       
		
		textField = new JFormattedTextField(/*maskF*/);
		//textField.setText("1");
		textField.selectAll();
		panel_2.add(textField, BorderLayout.CENTER);
		textField.setColumns(20);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl2 = new JLabel("Enter Last Value:");
		lbl2.setPreferredSize(new Dimension(150,40));
		lbl2.setFont(new Font("Ebrima", Font.PLAIN, 15));
		panel_3.add(lbl2, BorderLayout.WEST);
		
		textField_1 = new JFormattedTextField(/*maskF*/);
		//textField_1.setText("100");
		textField_1.selectAll();
		panel_3.add(textField_1, BorderLayout.CENTER);
		textField_1.setColumns(20);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl3 = new JLabel("Amount of Numbers:");
		lbl3.setPreferredSize(new Dimension(150,40));
		lbl3.setFont(new Font("Ebrima", Font.PLAIN, 15));
		panel_4.add(lbl3, BorderLayout.WEST);
		
		textField_2 = new JFormattedTextField(/*maskF*/);
		//textField_2.setText("1");
		textField_2.selectAll();
		panel_4.add(textField_2, BorderLayout.CENTER);
		textField_2.setColumns(20);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.controlHighlight);
		textArea.setForeground(Color.BLACK);
		contentPane.add(scroll, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.SOUTH);
	
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start =  Integer.parseInt(textField.getText());
				end =  Integer.parseInt(textField_1.getText());
				amntNumbers = Integer.parseInt(textField_2.getText());
				textArea.setText(null);
				
				//Validation for ints here
				for(int i = start; i <= amntNumbers; i++){
					Random r = new Random();
					int randInt = r.nextInt(end-start) + start;
					textArea.append(Integer.toString(randInt) + "\t");
				}
				
			}
		});
		panel_5.add(btnRun);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textArea.setText("");
				
			}
		});
		panel_5.add(btnClearFields);
		panel_5.add(btnNewButton);
		}
		
	
	
		
	}


