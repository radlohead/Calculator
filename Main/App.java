package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class ActionEventCreate<T> extends Frame implements ActionListener, WindowListener {
	Panel p;
	Button number0, number1, number2, number3, number4, number5, number6, number7, number8, number9, 
		   plusOperator, minusOperator, multiplicationOperator, divisionOperator, signOperator, exit;
	TextArea ta;
	private int result = 0;
	private String tempStr = "";
	private String lastOperator = "";
	
	public ActionEventCreate(){
		super("ActionEventCreate");
		
		p = new Panel();
		Label defaultExit = new Label("프레임의 종료버튼을 눌러주세요");
		
		add(defaultExit);
		
		number0 = new Button("0");
		number1 = new Button("1");
		number2 = new Button("9");
		number3 = new Button("2");
		number4 = new Button("3");
		number5 = new Button("4");
		number6 = new Button("5");
		number7 = new Button("6");
		number8 = new Button("7");
		number9 = new Button("8");
		plusOperator = new Button("+");
		minusOperator = new Button("-");
		multiplicationOperator = new Button("*");
		divisionOperator = new Button("/");
		signOperator = new Button("=");
		exit = new Button("종료");
		ta = new TextArea();
		
		number0.addActionListener(this);
		number1.addActionListener(this);
		number2.addActionListener(this);
		number3.addActionListener(this);
		number4.addActionListener(this);
		number5.addActionListener(this);
		number6.addActionListener(this);
		number7.addActionListener(this);
		number8.addActionListener(this);
		number9.addActionListener(this);
		plusOperator.addActionListener(this);
		minusOperator.addActionListener(this);
		multiplicationOperator.addActionListener(this);
		divisionOperator.addActionListener(this);
		signOperator.addActionListener(this);
		exit.addActionListener(this);
		
		addWindowListener(this);
		
		p.add(number0);
		p.add(number1);
		p.add(number2);
		p.add(number3);
		p.add(number4);
		p.add(number5);
		p.add(number6);
		p.add(number7);
		p.add(number8);
		p.add(number9);
		p.add(plusOperator);
		p.add(minusOperator);
		p.add(multiplicationOperator);
		p.add(divisionOperator);
		p.add(signOperator);
		p.add(exit);
		
		add(ta, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		
		setBounds(500,100,500,500);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String val;
		val = ae.getActionCommand();
		
//		if(name.equals("입력")) {
//			ta.append("버튼이 입력되었습니다.\n");
//		} else {
//			ta.append("프로그램을 종료합니다.\n");
//			try {
//				Thread.sleep(2000);
//			} catch(Exception e) {
//				System.exit(0);
//			}
//		}
		
		final String regex = "[0-9]";
		Pattern p = Pattern.compile(regex);
		
		if(p.matcher(val).find()) {
			ta.append(val);
			tempStr += val;
			ta.setText("");
			ta.append(Integer.toString(result));
		}
		
		if(val.equals("+")) {
			this.sum();
		}
		
		if(val.equals("-")) {
			this.minus();
		}
		
		if(val.equals("*")) {
			this.multiplicationOperator();
		}
		
		if(val.equals("/")) {
			this.divisionOperator();
		}
		
		if(val.equals("=")) {
			this.switchOperator();
		}
		
		if (val.equals("종료")) {
			System.exit(0);			
		}
	}
	
	public void sum() {
		lastOperator = "+";
		
		if (tempStr == "") {
			return;
		}
		
		result += Integer.parseInt(tempStr);
		tempStr = "";
		ta.setText("");
		ta.append(Integer.toString(result));
	}
	
	private void minus() {
		lastOperator = "-";
		
		if (tempStr == "") {
			return;
		}
		
		result -= Integer.parseInt(tempStr);
		tempStr = "";
		ta.setText("");
		ta.append(Integer.toString(result));
	}
	
	private void multiplicationOperator() {
		lastOperator = "*";
		
		if (tempStr == "") {
			return;
		}
		
		result *= Integer.parseInt(tempStr);
		tempStr = "";
		ta.setText("");
		ta.append(Integer.toString(result));
	}
	
	private void divisionOperator() {
		lastOperator = "/";
		
		if (tempStr == "") {
			return;
		}
		
		result /= Integer.parseInt(tempStr);
		tempStr = "";
		ta.setText("");
		ta.append(Integer.toString(result));
	}
	
	private void switchOperator() {
		switch(lastOperator) {
			case "+":
				result += Integer.parseInt(tempStr);
				tempStr = "";
				break;
			case "-":
				result -= Integer.parseInt(tempStr);
				tempStr = "";
				break;
			case "*":
				result *= Integer.parseInt(tempStr);
				tempStr = "";
				break;
			case "/":
				result /= Integer.parseInt(tempStr);
				tempStr = "";
				break;
		}
		
		ta.setText("");
		ta.append(Integer.toString(result));
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}	
}

public class App {
	public static void main(String[] args) {
		ActionEventCreate ae = new ActionEventCreate();
	}
}
