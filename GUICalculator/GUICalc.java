package GUICalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUICalc implements ActionListener
{

	// Calculator logic instance
	private Calculator calc = new Calculator();
	private float firstNum;
	private float SecondNum;
	private String operator;
	private JPanel panel;
	private JFrame frame;
	private JTextField answer;
	private JButton[] buttons = new JButton[10];
	private JButton[] operations = new JButton[4];
	private JButton result;
	private boolean justEvaluated = false;
	private JButton decimal;
	private JButton clear;

	// Constructor to setup the GUI
	public GUICalc() 
	{
		panel = new JPanel();
		frame = new JFrame();

		frame.setSize(350,350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);

		// Text field to display answer, not editable by user
		answer = new JTextField();
		answer.setBounds(10, 10, 212, 30);
		answer.setEditable(false);
		panel.add(answer);

		// Create buttons 0-9
		for(int i = 0; i < 10; i++) 
		{
			String number = String.valueOf(i);
			buttons[i] = new JButton(number);
		}

		// Position number buttons in calculator layout
		buttons[7].setBounds(10, 38, 45, 45);
		buttons[8].setBounds(65, 38, 45, 45);
		buttons[9].setBounds(120, 38, 45, 45);

		buttons[4].setBounds(10, 93, 45, 45);
		buttons[5].setBounds(65, 93, 45, 45);
		buttons[6].setBounds(120, 93, 45, 45);

		buttons[1].setBounds(10, 148, 45, 45);
		buttons[2].setBounds(65, 148, 45, 45);
		buttons[3].setBounds(120, 148, 45, 45);

		buttons[0].setBounds(65, 203, 45, 45);

		// Add number buttons to panel and register listener
		for (int i = 0; i < 10; i++) {
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}

		// Create operation buttons +, /, -, x
		int opX = 175;
		int opY = 39;

		String[] symbols = {"+", "/", "-", "x"};

		for(int i = 0; i < 4; i++) 
		{
			operations[i] = new JButton(symbols[i]);
			operations[i].setBounds(opX,opY,45,45);
			operations[i].addActionListener(this);
			panel.add(operations[i]);  
			opY += 55;
		}

		// Equals button
		result = new JButton("=");
		result.setBounds(120,203,45,45);
		result.addActionListener(this);
		panel.add(result);

		// Decimal point button

		decimal = new JButton(".");
		decimal.setBounds(10, 203, 45, 45); 
		decimal.addActionListener(this);
		panel.add(decimal);

		// Clear button to reset calculator

		clear = new JButton("C");
		clear.setBounds(230, 10, 50, 30);
		clear.addActionListener(this);
		panel.add(clear);

		frame.setVisible(true);
	}

	public static void main(String[] args) 
	{
		new GUICalc();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Clear all inputs and reset state
		if(e.getSource() == clear) {
			answer.setText("");
			firstNum = 0;
			SecondNum = 0;
			operator = null;
			justEvaluated = false;
		}

		float resultNum = 0;

		// Handle number button presses
		for(int i = 0; i < 10; i++) 
		{
			if(e.getSource() == buttons[i]) 
			{
				// If calculation just finished, reset input for new number
				if(justEvaluated) 
				{
					if(!answer.getText().equals("0."))
					{
						answer.setText("");
					}
					justEvaluated = false;
				}

				// Append clicked number to current input
				answer.setText(answer.getText() + buttons[i].getText());
			}

			// Handle decimal button click - allow only one decimal point
			if(e.getSource() == decimal) 
			{		
				if(!answer.getText().contains(decimal.getText())) 
				{
					if(answer.getText().isEmpty()) 
					{
						answer.setText("0.");
					}
					else
					{
						answer.setText(answer.getText() + decimal.getText());		
					}
				}
			}
		}

		// Store the first number and operator when operation button is clicked
		for(int i = 0; i < 4; i++) 
		{
			if(e.getSource() == operations[i]) 
			{
				String currentText = answer.getText();

				if(!currentText.isEmpty()) 
				{
					this.firstNum = Float.parseFloat(currentText);
					answer.setText(""); // Prepare input for second number
				}

				this.operator = operations[i].getText();
			}
		}

		// Calculate and display result when equals button clicked
		if (e.getSource() == result && operator != null) 
		{
			String currentText = answer.getText();

			// Only update second number if new input and calculation not just done
			if(!currentText.isEmpty() && !justEvaluated) 
			{
				this.SecondNum = Float.parseFloat(currentText);
			}

			switch(operator) 
			{
			case "+":
				resultNum = calc.addition(firstNum,SecondNum);
				break;
			case "-":
				resultNum = calc.subtraction(firstNum,SecondNum);
				break;
			case "/":
				resultNum = calc.division(firstNum,SecondNum);
				break;
			case "x":
				resultNum = calc.multiplication(firstNum,SecondNum);
				break;
			}

			firstNum = resultNum;
			justEvaluated = true;
			answer.setText(String.valueOf(resultNum));
		}

	}

}
