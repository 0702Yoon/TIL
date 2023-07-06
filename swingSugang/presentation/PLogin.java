package presentation;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JPanel;

import control.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin extends JPanel {
	
	public PLogin() {
		this.setBackground(Color.green);
	}

	public VUserInfo login(Scanner keyboard){
		
		System.out.println("����� ���̵� �Է��ϼ���.");
		 // �̰� ��ȯ�����ִ� ��. Ű����� �����ؾߵ� �� �ƴϾ� Ű���尡 System.in�̾�. �̷��� �ؾ� ���� Ű���常 ���������� �� �� �ִ�.
		String userId = keyboard.next();
		System.out.println(userId);
		System.out.println("��й�ȣ�� �Է��ϼ���.");
		String password = keyboard.next();
		System.out.println(password);
		
		
		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId);
		vLogin.setPassword(password);
		// �׸��� ��Ҵ�.
		CLogin cLgoin = new CLogin();
		
		VUserInfo vUserInfo = cLgoin.login(vLogin); // account���� ���� info�� �޾ƿ;��Ѵ�.
		
		if(vUserInfo ==null) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		else {
			System.out.println(vUserInfo.getName()+"�� �ȳ��ϼ���.");
		}
		
		
		return vUserInfo;
	}
}
