package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class HandleInput implements ActionListener{

	JTextField display;
	
	
	HandleInput(JTextField display){
		this.display=display;
		oper="=";
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
		
		
		if(key.equals("=")) {
//			if(num1set&&operset&&num2set) {
//			if(num1set) {
//			有运算符就直接计算
			if(!oper.equals("=")) {
				num2=display.getText();
				num1=cal(num1,oper,num2);
			}
			//重置运算符&显示
				display.setText(num1);
				oper="=";
			
			//输入一个数按等于号
//			if(num1set&&operset&&!num2set) {
				
//			}
		}else {
			num1=display.getText(); //储存数字1			
			oper=key;
		}
	}

	private String cal(String num1, String oper, String num2) {
		// TODO Auto-generated method stub
		BigDecimal bnum1,bnum2,ans = null;
		bnum1 = new BigDecimal(num1);
		bnum2 = new BigDecimal(num2);
		
		if(oper.equals("+")) {
			ans=bnum1.add(bnum2);
		}
		else if(oper.equals("-")) {
			ans=bnum1.subtract(bnum2);
		}
		else if(oper.equals("*")) {
			ans=bnum1.multiply(bnum2);
		}
		else if(oper.equals("/")) {
			ans=bnum1.divide(bnum2);
		}
		else
			ans=bnum1;
		
		return ans.toString();
	}

	private void handleNumber(String key) {
		// TODO Auto-generated method stub
		
			
//			num1set=true;
		if(!oper.equals("=")||display.getText().equals("0"))
			display.setText(key);
		else
			display.setText(display.getText()+key);
		
			
	}

	private void handleC() {
		// TODO Auto-generated method stub
		display.setText("0");
		num1="0";
		num2="0";
		oper="=";
		
	}

	private void handleBackspace() {
		// TODO Auto-generated method stub
		String str=display.getText();
		
		if(str.length()<=1)
			display.setText("0");
		else {
			str=str.substring(0, str.length()-1);
			display.setText(str);
		}
		
	}
	
}
