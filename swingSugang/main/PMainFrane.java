package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;

import presentation.PLogin;
import presentation.PSugangsincheng;
import valueObject.VUserInfo;


public class PMainFrane extends JFrame{
	// constructor
	private Scanner keyboard;
	private PLogin pLogin;
	private PSugangsincheng pSugangsincheong;
	public PMainFrane() {
		
		this.setSize(400,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		pSugangsincheong = new PSugangsincheng();
		this.add(pSugangsincheong);
		
	}
	
		
	public static void main(String[] args) throws FileNotFoundException {
		// object name declaration
		// memory allocation
		// invoke constructor
		// object name and memory address binding
		PMainFrane pMainFrame = new PMainFrane();
		pMainFrame.setVisible(true);
	
	}
}
