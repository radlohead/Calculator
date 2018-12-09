package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class ActionEventCreate<T> extends Frame implements ActionListener, WindowListener {
	Panel p;
	Button plusOperator, minusOperator, multiplicationOperator, divisionOperator, signOperator, exit;
	List<Button> listButtons = new ArrayList<Button>();
	TextArea ta;
	private int result = 0;
	private String tempStr = "";
	private String prevOperator = "";
	private String lastOperator = "";
	
	public ActionEventCreate(){
		super("ActionEventCreate");
		
		p = new Panel();
		Label defaultExit = new Label("종료버튼을 눌러주세요");
		
		add(defaultExit);
		
		plusOperator = new Button("+");
		minusOperator = new Button("-");
		multiplicationOperator = new Button("*");
		divisionOperator = new Button("/");
		signOperator = new Button("=");
		exit = new Button("종료");
		ta = new TextArea();
		
		plusOperator.addActionListener(this);
		minusOperator.addActionListener(this);
		multiplicationOperator.addActionListener(this);
		divisionOperator.addActionListener(this);
		signOperator.addActionListener(this);
		exit.addActionListener(this);
		
		addWindowListener(this);

		for(int i=0; i<=9; i++) {
			Button number = new Button(Integer.toString(i));
			listButtons.add(number);
			listButtons.get(i).addActionListener(this);
			p.add(listButtons.get(i));
		}
		
		p.add(plusOperator);
		p.add(minusOperator);
		p.add(multiplicationOperator);
		p.add(divisionOperator);
		p.add(signOperator);
		p.add(exit);
		
		add(ta, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		
		setBounds(500,100,300,400);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String val;
		val = ae.getActionCommand();
		
		final String regex = "[0-9]";
		Pattern p = Pattern.compile(regex);
		
		if(p.matcher(val).find()) {
			if(lastOperator != "") {
				prevOperator = lastOperator;	
				lastOperator = "";
				ta.setText("");
			}
			
			if(lastOperator == "=") {
				lastOperator = "";
				tempStr = "";
				result = 0;
			}
			
			tempStr += val;
			ta.append(val);
		}
		
		switch(val) {
			case "+":
				lastOperator = "+";
				this.finalOperator();
				break;
			case "-":
				lastOperator = "-";
				this.finalOperator();
				break;
			case "*":
				lastOperator = "*";
				this.finalOperator();
				break;
			case "/":
				lastOperator = "/";
				this.finalOperator();
				break;
			case "=":
				this.finalOperator();
				break;
		}
		
		if (val.equals("종료")) {
			System.exit(0);			
		}
	}
	
	private void finalOperator() {
		if (tempStr == "") {
			return;
		}
		
		if(prevOperator == "") {
			prevOperator = lastOperator;
		}
		
		switch(prevOperator) {
			case "+":
				result += Integer.parseInt(tempStr);
				tempStr = "";
				break;
			case "-":
				result -= Integer.parseInt(tempStr);
				tempStr = "";
				break;
			case "*":
				if(result == 0) {
					result = 1;
				}
				
				result *= Integer.parseInt(tempStr);
				tempStr = "";
				break;
			case "/":
				if(result == 0) {
					result = Integer.parseInt(tempStr) * 2;
				}
				
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
