/**
  * ITCC 11 B - Event Handlers Calculator
  *   Keisha Anne J. Avila
  *   October 15,2020
  **/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calcu  implements ActionListener {

	private JFrame mainframe;
	private JPanel mPanel;
	private JPanel btnPanel;
	private JTextField disp;
	private int arr =10;
	JButton[] numbtn = new JButton[arr];
	JButton[] funcbtn = new JButton[arr];
	private JButton addBtn, subBtn, mulBtn, divBtn;
	private JButton decBtn, clrBtn, eqBtn, bckspace, negBtn, percentBtn;
	
	
	
	
	Font text =new Font("Segoe Print", Font.BOLD,20);
	
	
	double num1=0, num2=0, res=0, n=1;
	String op;
	
	public Calcu() {
		
		//frame attributes
    	
		mainframe = new JFrame ("My Calculator");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(350,500);
        mainframe.setResizable(false);
        mainframe.setLayout(null);	
        mainframe.setLocationRelativeTo(null);
        mainframe.getContentPane().setBackground(Color.BLACK);
        mainframe.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        
        
        //mainpanel, funcpanel & btnpanel
        mPanel = new JPanel(new BorderLayout());
        mPanel.setBounds(17, 22, 300, 50);
        mPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
 
        btnPanel = new JPanel(new GridLayout(5,4,5,5));
        btnPanel.setBackground(Color.BLACK);
        btnPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        btnPanel.setBounds(17,90,300,350);
        
      
        
        
        //textfield
        disp = new JTextField();
		disp.setHorizontalAlignment(JTextField.RIGHT);
		disp.setEditable(false);
		disp.setBackground(Color.WHITE);
		disp.setOpaque(true);
		disp.setFont(text);
 
		//buttons
			addBtn = new JButton("+");
			subBtn = new JButton("-");
			mulBtn = new JButton("*");
			divBtn = new JButton("/");
			clrBtn = new JButton("CE");
			eqBtn = new JButton("=");
			decBtn = new JButton(".");
			bckspace = new JButton("<-");
			negBtn = new JButton("+/-");
			percentBtn = new JButton("%");
			
			
			
			funcbtn[0]= addBtn;
			funcbtn[0].setBackground(Color.YELLOW);
			
			funcbtn[1]= subBtn;
			funcbtn[1].setBackground(Color.YELLOW);
			
			funcbtn[2]= mulBtn;
			funcbtn[2].setBackground(Color.YELLOW);
			
			funcbtn[3]= divBtn;
			funcbtn[3].setBackground(Color.YELLOW);
			
			funcbtn[4]= eqBtn;
			funcbtn[4].setBackground(Color.YELLOW);
			
			funcbtn[5]= bckspace;
			funcbtn[5].setBackground(Color.ORANGE);
			
			funcbtn[6]= clrBtn;
			funcbtn[6].setBackground(Color.ORANGE);
			
			funcbtn[7]=  percentBtn;
			funcbtn[7].setBackground(Color.YELLOW);
			
			funcbtn[8]= decBtn;
			funcbtn[8].setBackground(Color.PINK);
			
			funcbtn[9]= negBtn;
			funcbtn[9].setBackground(Color.PINK);
			
			for (int r=0; r<funcbtn.length;r++) {
				funcbtn[r].addActionListener(this);
				funcbtn[r].setFont(text);
				funcbtn[r].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				
			}
	

			for (int k=0; k<numbtn.length;k++) {
				numbtn[k] = new JButton(String.valueOf(k));
				numbtn[k].addActionListener(this);
				numbtn[k].setFont(text);	
				numbtn[k].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				numbtn[k].setBackground(Color.PINK);;
				
						}
		
			
		//adding buttons
		
		btnPanel.add(bckspace);	
		btnPanel.add(clrBtn);
		btnPanel.add(percentBtn);
		btnPanel.add(divBtn);
		btnPanel.add(numbtn[7]);	
		btnPanel.add(numbtn[8]);	
		btnPanel.add(numbtn[9]);	
		btnPanel.add(mulBtn);
		btnPanel.add(numbtn[4]);	
		btnPanel.add(numbtn[5]);	
		btnPanel.add(numbtn[6]);
		btnPanel.add(subBtn);
		btnPanel.add(numbtn[1]);
		btnPanel.add(numbtn[2]);	
		btnPanel.add(numbtn[3]);
		btnPanel.add(addBtn);
		btnPanel.add(negBtn);
		btnPanel.add(numbtn[0]);
		btnPanel.add(decBtn);	
		btnPanel.add(eqBtn);
		
		
	
		

		
		
		
			
			mPanel.add(disp);
			mainframe.add(btnPanel);
			mainframe.add(mPanel,BorderLayout.NORTH);
			
			
			
	}
	
	public void show() {
	
		mainframe.setVisible(true);
	}

	public static void main(String[] args) {
	
		Calcu cal = new Calcu();
		cal.show();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent btn) {
		
			for (int p=0; p<arr;p++) {
				if (btn.getSource() == numbtn[p]) {
					disp.setText(disp.getText().concat(String.valueOf(p)));
				}
			}
			if(btn.getSource() == clrBtn) {
				String temp = null ;
				temp = temp + (btn.getActionCommand() == "CE");
	    		disp.setText("");
			}
			if(btn.getSource()== bckspace) {
				
				String fNum="";
				String temp=disp.getText();
				int size = temp.length();
					for(int r=0; r<size-1;r++) {
					fNum=fNum + temp.charAt(r);
						}
							disp.setText(fNum);	
			
			}
				if(btn.getSource() == funcbtn[7]) {
					op="%";
					res = Double.parseDouble(String.valueOf(disp.getText()));
					disp.setText(String.valueOf(res));
			}
				
				if(btn.getSource() == funcbtn[8]) {
				String temp = disp.getText();
				temp= temp + btn.getActionCommand();
					disp.setText(temp);
				
			}
				
				if (btn.getSource() == funcbtn[9]) {
				String temp ="";
	            disp.setText(temp + (-1 * Double.parseDouble(disp.getText())));
	            
	        }
				
				if(btn.getSource() == decBtn) {
					disp.setText(disp.getText());
				}
				
				if(btn.getSource() == addBtn) {
					num1=Double.parseDouble(disp.getText());
					op = "+";
					disp.setText("");
					
			}
				if(btn.getSource() == subBtn) {
					num1=Double.parseDouble(disp.getText());
					op = "-";
					disp.setText("");
			}
				if(btn.getSource() == mulBtn) {
					num1=Double.parseDouble(disp.getText());
					op = "*";
					disp.setText("");
			}
				if(btn.getSource() == divBtn) {
					num1=Double.parseDouble(disp.getText());
					op = "/";
					disp.setText("");
				}
				
				if(btn.getSource() == eqBtn) {
						num2= Double.parseDouble(disp.getText());
						switch(op) {
							case "%":
									res  = num1*(num2/100);
									break;
							case "+" :
						           res=num1+num2;
						           break;
							case "-":
									res = num1 - num2;
									break;
							case "*":
									res = num1 * num2;
									break;
							case"/":	
				
							if(op =="/") {
								if(num2 == 0) {
							try {
									res = num1/num2;
							}catch(ArithmeticException ae) {
									disp.setText("Cannot divide by 0");
								}	 
							}
						}
					}
				}
			}
}