package Chow.Fiona.Chapter7.Java.Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame frame;
	private JTextField textField_numerator;
	private JTextField textField_denominator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_numerator = new JTextField();
		textField_numerator.setBounds(10, 44, 86, 20);
		frame.getContentPane().add(textField_numerator);
		textField_numerator.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numerator");
		lblNewLabel.setBounds(10, 30, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_denominator = new JTextField();
		textField_denominator.setBounds(10, 100, 86, 20);
		frame.getContentPane().add(textField_denominator);
		textField_denominator.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Denominator");
		lblNewLabel_1.setBounds(10, 85, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_divisionCalculation = new JLabel("Division Calculation");
		lblNewLabel_divisionCalculation.setBounds(150, 18, 174, 14);
		frame.getContentPane().add(lblNewLabel_divisionCalculation);
		
		JButton btnNewButton_calculate = new JButton("Calculate");
		

	
		btnNewButton_calculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				// store value of numerator text field in variable called "numerator"
				double numerator = Double.parseDouble(textField_numerator.getText());
				
				// store value of denominator text field in variable called "denominator"
				double denominator = Double.parseDouble(textField_denominator.getText());				
				
				// instantiate SimpleMath class
				SimpleMath MathObject = new SimpleMath();
								
				// use a try/catch statement to catch division exceptions when you divide a number by 0
				try {
					
					// store results of SimpleMath divide() method in variable called "result", pass the divide method on the numerator and denominator variables you just created
					Double result = MathObject.divide(numerator, denominator);
					
					// in try block, set JLabel text to the result of the divide() method
					lblNewLabel_divisionCalculation.setText(result.toString());
										
				} catch (Exception ArithmeticException) {
					
					// in catch block, set JLabel text to: "Cannot divide by 0"
					lblNewLabel_divisionCalculation.setText("Cannot divide by 0");
					
				}	
				
			}
		});
		
		btnNewButton_calculate.setBounds(151, 43, 89, 23);
		frame.getContentPane().add(btnNewButton_calculate);
	}
}
