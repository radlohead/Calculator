package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class ActionEventCreate<T> extends Frame implements ActionListener, WindowListener {
	Panel p;
	Button number0, number1, number2, number3, number4, number5, number6, number7, number8, number9, 
		   plusOperator, minusOperator, multiplicationOperator, divisionOperator, signOperator, exit;
	TextArea ta;
	private int result = 0;
	private List<String> list = new ArrayList<String>();
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
		
//		ta.setBounds(0, 0, 50, 50);
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
		
		if(val.equals("0")) {
			ta.append("0");
			list.add(val);
		}
		
		if(val.equals("1")) {
			ta.append("1");
			list.add(val);
		}
		
		if(val.equals("2")) {
			ta.append("2");
			list.add(val);
		}
		
		if(val.equals("3")) {
			ta.append("3");
			list.add(val);
		}
		
		if(val.equals("4")) {
			ta.append("4");
			list.add(val);
		}
		
		if(val.equals("5")) {
			ta.append("5");
			list.add(val);
		}
		
		if(val.equals("6")) {
			ta.append("6");
			list.add(val);
		}
		
		if(val.equals("7")) {
			ta.append("7");
			list.add(val);
		}
		
		if(val.equals("8")) {
			ta.append("8");
			list.add(val);
		}
		
		if(val.equals("9")) {
			ta.append("9");
			list.add(val);
		}
		
		if(val.equals("+")) {
			ta.append("+");
			lastOperator = "+";
			
			if (list.size() == 0) {
				return;
			}
			
			result += Integer.parseInt(list.get(0));
			list.removeAll(list);
			System.out.println(result);
		}
		
		if(val.equals("-")) {
			ta.append("-");
			lastOperator = "-";
			
			if (list.size() == 0) {
				return;
			}
			
			result -= Integer.parseInt(list.get(0));
			list.removeAll(list);
			System.out.println(result);
		}
		
		if(val.equals("*")) {
			ta.append("*");
			lastOperator = "*";
			
			if (list.size() == 0) {
				return;
			}
			
			result *= Integer.parseInt(list.get(0));
			list.removeAll(list);
			System.out.println(result);
		}
		
		if(val.equals("/")) {
			ta.append("/");
			lastOperator = "/";
			
			if (list.size() == 0) {
				return;
			}
			
			result /= Integer.parseInt(list.get(0));
			list.removeAll(list);
			System.out.println(result);
		}
		
		if(val.equals("=")) {
			ta.append("=");
			
			switch(lastOperator) {
				case "+":
					result += Integer.parseInt(list.get(0));
					list.removeAll(list);
					break;
				case "-":
					result -= Integer.parseInt(list.get(0));
					list.removeAll(list);
					break;
				case "*":
					result *= Integer.parseInt(list.get(0));
					list.removeAll(list);
					break;
				case "/":
					result /= Integer.parseInt(list.get(0));
					list.removeAll(list);
					break;
			}
			
			ta.append(Integer.toString(result));
		}
		
//		System.out.println(lastOperator);
		System.out.println(result);
//		System.out.println(list);
		
		if (val.equals("종료")) {
			System.exit(0);			
		}
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
//		FrameCreate f = new FrameCreate();
//		ButtonCreate b = new ButtonCreate();
//		RadioButtonCreate radio = new RadioButtonCreate();
//		TextFieldCreate tf = new TextFieldCreate();
//		WindowEventCreate we = new WindowEventCreate();
		ActionEventCreate ae = new ActionEventCreate();
	}
}
