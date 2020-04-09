package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class HandleInput implements ActionListener{

	JTextField display;
	
	
	HandleInput(JTextField display){
		this.display=display;
	}
	
	String oper,num1,num2;
	boolean num1set,num2set,operset;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String key=arg0.getActionCommand();
//		JFrame ui = (JFrame) arg0.getSource();
		System.out.println("按下了"+key+"\n");
		if (key.equals("BS")) {
			// 用户按了"Backspace"键
			handleBackspace();
		} else if (key.equals("CE")) {
			// 用户按了"CE"键
			display.setText("0");
		} else if (key.equals("C")) {
			// 用户按了"C"键
			handleC();
		} else if ("0123456789.".indexOf(key) >= 0) {
			// 用户按了数字键或者小数点键
			handleNumber(key);
			// handlezero(zero);
		} else {
			// 用户按了运算符键
			handleOperator(key);
		}
		
	}

	private void handleOperator(String key) {
		// TODO Auto-generated method stub
		oper=key;
		num1=display.getText();
		num1set=true; //储存数字1
		if(key.equals("=")) {
			if(num1set&&operset) {
				num2=display.getText();
				display.setText(cal(num1,oper,num2));
			}
			
		}
	}

	private String cal(String num1, String oper, String num2) {
		// TODO Auto-generated method stub
		
		return null;
	}

	private void handleNumber(String key) {
		// TODO Auto-generated method stub
		display.setText(display.getText()+key);
		
			
	}

	private void handleC() {
		// TODO Auto-generated method stub

			
		display.setText("0");
		
	}

	private void handleBackspace() {
		// TODO Auto-generated method stub
		String dis=display.getText();
		dis=dis.substring(0,-1);
		if(dis.length()<1)
			dis="0";
		display.setText(dis);
	}
	
}
