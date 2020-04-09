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
		System.out.println("������"+key+"\n");
		if (key.equals("BS")) {
			// �û�����"Backspace"��
			handleBackspace();
		} else if (key.equals("CE")) {
			// �û�����"CE"��
			display.setText("0");
		} else if (key.equals("C")) {
			// �û�����"C"��
			handleC();
		} else if ("0123456789.".indexOf(key) >= 0) {
			// �û��������ּ�����С�����
			handleNumber(key);
			// handlezero(zero);
		} else {
			// �û������������
			handleOperator(key);
		}
		
	}

	private void handleOperator(String key) {
		// TODO Auto-generated method stub
		oper=key;
		num1=display.getText();
		num1set=true; //��������1
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
