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
		
		System.out.println("사용자 아이디 입력하세요.");
		 // 이건 변환시켜주는 애. 키보드랑 연결해야될 꺼 아니야 키보드가 System.in이야. 이렇게 해야 나의 키보드만 독립적으로 쓸 수 있다.
		String userId = keyboard.next();
		System.out.println(userId);
		System.out.println("비밀번호를 입력하세요.");
		String password = keyboard.next();
		System.out.println(password);
		
		
		VLogin vLogin = new VLogin();
		vLogin.setUserId(userId);
		vLogin.setPassword(password);
		// 그릇에 담았다.
		CLogin cLgoin = new CLogin();
		
		VUserInfo vUserInfo = cLgoin.login(vLogin); // account한테 유저 info을 받아와야한다.
		
		if(vUserInfo ==null) {
			System.out.println("잘못 입력하셨습니다.");
		}
		else {
			System.out.println(vUserInfo.getName()+"님 안녕하세요.");
		}
		
		
		return vUserInfo;
	}
}
