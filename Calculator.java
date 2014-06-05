//Simple calculator program using java swing and javascript engine.
//@author  Conor Hughes


import javax.swing.*;
import javax.swing.border.Border;
import javax.script.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator
{
	private String equation = "";
	private String display = "";
	private JLabel showScreen = new JLabel(equation);
	
    public JPanel createContentPane ()
	{
        JPanel calculator = new JPanel();
        JPanel buttons = new JPanel(new GridLayout(6, 3, 3, 3));
		
		//screen to show equation
		Border lineBorder = BorderFactory.createLineBorder(Color.black);
		JPanel screen = new JPanel();
		screen.setBackground(Color.WHITE);
		screen.setPreferredSize(new Dimension(210, 30)); 
		screen.add(showScreen);
		screen.setBorder(lineBorder);
	
		//buttons for numbers
		JButton num1 = new JButton("1");	
		num1.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '1';
				display += '1';
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton num2 = new JButton("2");	
		num2.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '2';
				display += '2';
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton num3 = new JButton("3");	
		num3.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '3';
				display += '3';
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton num4 = new JButton("4");	
		num4.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '4';
				display += '4';
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton num5 = new JButton("5");	
		num5.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '5';
				display += '5';
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton num6 = new JButton("6");	
		num6.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '6';
				display += '6';
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton num7 = new JButton("7");	
		num7.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '7';
				display += '7';
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton num8 = new JButton("8");	
		num8.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '8';
				display += '8';
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton num9 = new JButton("9");	
		num9.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '9';
				display += '9';
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton num0 = new JButton("0");	
		num0.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '0';
				display += '0';
				showScreen.setText(new String(display)); 
            }
        }); 
		
		//buttons for mathematical symbols
		JButton plus = new JButton("+");	
		plus.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '+';
				display += '+';
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton minus = new JButton("-");	
		minus.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '-';
				display += '-';
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton multiply = new JButton(Character.toString ((char) 215));	
		multiply.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '*';
				display += ((char) 215);
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton divide = new JButton(Character.toString ((char) 247));	
		divide.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation += '/';
				display += ((char) 247);
				showScreen.setText(new String(display)); 
            }
        }); 
		JButton equals = new JButton("=");	
		equals.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				try
				{
					ScriptEngineManager mgr = new ScriptEngineManager();
					ScriptEngine engine = mgr.getEngineByName("JavaScript");
					display = String.valueOf(engine.eval(equation));
					showScreen.setText(new String(display));
					equation = "";
					display = "";
				}
				catch(Exception ex) {}
            }
        });		
		JButton delete = new JButton("Delete");	
		delete.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				display = display.substring(0, display.length() - 1);
				equation = equation.substring(0, equation.length() - 1);
				showScreen.setText(new String(display));
            }
        }); 
		JButton clear = new JButton("Clear");	
		clear.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				equation = "";
				display = "";
				showScreen.setText(new String(display));
            }
        }); 
		JButton exit = new JButton("Exit");	
		exit.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
            {
				System.exit(0);
            }
        }); 
		
		buttons.add(num7);
		buttons.add(num8);
		buttons.add(num9);
		buttons.add(num4);
		buttons.add(num5);
		buttons.add(num6);
		buttons.add(num1);
		buttons.add(num2);
		buttons.add(num3);
		buttons.add(num0);
		buttons.add(multiply);
		buttons.add(divide);
		buttons.add(plus);
		buttons.add(minus);
		buttons.add(equals);
		buttons.add(delete);
		buttons.add(clear);
		buttons.add(exit);
		
		equals.setPreferredSize(new Dimension(70, 70)); 
      
		//add both JPanels to main one
        calculator.add(screen);
		calculator.add(buttons);
        calculator.setOpaque(true);
        return calculator;
    }

    private static void createAndShowGUI() 
	{
        JFrame frame = new JFrame("Calculator");
		ImageIcon img = new ImageIcon("./calc.png");

		Calculator demo = new Calculator();
        frame.setContentPane(demo.createContentPane());
		frame.setPreferredSize(new Dimension(300,520));
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
	{
        SwingUtilities.invokeLater(new Runnable() 
		{
            public void run() 
			{
                createAndShowGUI();
            }
        });
    }
}