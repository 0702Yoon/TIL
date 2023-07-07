package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.JFrame;

import presentation.PLogin;
import presentation.PSugangsincheng;
import valueObject.VUserInfo;


public class PMainFrame extends JFrame{
	// constructor
	private Scanner keyboard;
	private PLogin pLogin;
	private PSugangsincheng pSugangsincheong;
	public PMainFrame() {
		
		this.setSize(400,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		pSugangsincheong = new PSugangsincheng();
		
		pLogin = new PLogin();
		pLogin.getButtone().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event) {
				if(event.getClickCount()==1) {
					VUserInfo vUserInfo = pLogin.login();
					if(Objects.isNull(vUserInfo)) { // null인지 아닌 지 확인 해주는 좋은 메소드다.
						
					}
					else {
						add(pSugangsincheong);
					}
				
				}
			}
		});
		
		add(pLogin);
//		add(pSugangsincheong); 원래 이렇게 해놓고 안보이게 했었는 데 왜 안됐을 까?
	
	}
	
		
	public static void main(String[] args) throws FileNotFoundException {
		// object name declaration
		// memory allocation
		// invoke constructor
		// object name and memory address binding
		PMainFrame pMainFrame = new PMainFrame();
		pMainFrame.setVisible(true);
	
	}
}
