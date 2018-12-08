package Event;

import java.awt.*;
import java.awt.event.*;

class FrameCreate {
	FrameCreate(){
		Frame f = new Frame();
		
		f.setTitle("Frame Test!");
		f.setSize(300, 300);
		f.setVisible(true);
	}
}

class ButtonCreate {
	ButtonCreate(){
		Frame f = new Frame();
		Panel p = new Panel();
		
		Button b1 = new Button();
		Button b2 = new Button("출력");
		
		p.add(b1);
		p.add(b2);
		f.add(p);
		
		f.setLocation(300,300);
		f.setSize(300,100);
		f.setVisible(true);
	}
}

class RadioButtonCreate {
	RadioButtonCreate(){
		Frame f = new Frame();
		Panel p = new Panel();
		
		CheckboxGroup group = new CheckboxGroup();
		Checkbox radio1 = new Checkbox("고졸",group,false);
		Checkbox radio2 = new Checkbox("전문대",group,false);
		Checkbox radio3 = new Checkbox("대졸",group,true);
		
		p.add(radio1);
		p.add(radio2);
		p.add(radio3);
		
		f.add(p);
		f.setSize(300,100);
		f.setVisible(true);
	}
}

class TextFieldCreate {
	TextFieldCreate(){
		Frame f = new Frame();
		Panel p = new Panel();
		
		TextField tf1 = new TextField("아이디를 입력하세요", 12);
		TextField tf2 = new TextField("비밀번호를 입력하세요", 10);
		
		tf1.selectAll();
		tf2.selectAll();
		
		tf2.setEchoChar('*');
		
		p.add(tf1);
		p.add(tf2);
		
		f.add(p);
		
		f.setSize(300,300);
		f.setVisible(true);
	}
}

class WindowEventCreate extends Frame implements WindowListener {
	public WindowEventCreate(){
		super("WindowEvent Test");
		
		Label exit = new Label("프레임의 종료버튼을 눌러주세요");
		
		add(exit);
		setBounds(300,300,200,200);
		setVisible(true);
		
		addWindowListener((WindowListener) this);
	}
	
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
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

class ActionEventCreate extends Frame implements ActionListener, WindowListener {
	Panel p;
	Button input, exit;
	TextArea ta;
	
	public ActionEventCreate(){
		super("ActionEventCreate");
		
		p = new Panel();
		
		input = new Button("입력");
		exit = new Button("종료");
		ta = new TextArea();
		
		input.addActionListener(this);
		exit.addActionListener(this);
		
		addWindowListener(this);
		
		p.add(input);
		p.add(exit);
		
		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		
		setBounds(300,300,300,200);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String name;
		name = ae.getActionCommand();
		
		if(name.equals("입력")) {
			ta.append("버튼이 입력되었습니다.\n");
		} else {
			ta.append("프로그램을 종료합니다.\n");
			try {
				Thread.sleep(2000);
			} catch(Exception e) {
				System.exit(0);
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
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

public class Example {
	public static void main(String[] args) {
//		FrameCreate f = new FrameCreate();
//		ButtonCreate b = new ButtonCreate();
//		RadioButtonCreate radio = new RadioButtonCreate();
//		TextFieldCreate tf = new TextFieldCreate();
//		WindowEventCreate we = new WindowEventCreate();
		ActionEventCreate ae = new ActionEventCreate();
	}
}
