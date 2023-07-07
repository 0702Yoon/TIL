package presentation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin extends JPanel {
	private JButton loginBtn;
	private JTextField idF;
	private JPasswordField passwordF;
	public PLogin() {
		
		this.setBackground(Color.white);
		this.setLayout(null); // 이렇게 null를 붙여줘야 setBounds가 들어기네
		JLabel title = new JLabel("명지대 수강신청");
		int frameSize = 400; // 컨테이너 크기 가져오기
		title.setSize(200,50);
		
		int titleSize = title.getWidth();
		int x = (frameSize - titleSize)/2;
		
		title.setLocation(x, title.getHeight());
		
		Font font = title.getFont();
		title.setFont(font.deriveFont(24.0f)); // deriverFont는 float값을 기대하기 때문에 f를 붙여야 한다.
		this.add(title);
		
		loginBtn = new JButton("로그인");
		loginBtn.setSize(100, 100);
		loginBtn.setLocation((frameSize-loginBtn.getWidth())/2,300);
		this.add(loginBtn);
		
		JLabel id = new JLabel("학번");
		id.setFont(font.deriveFont(20f));
		id.setBounds(100, 100, 100, 150);
		add(id);
		
		idF = new JTextField(10);
		idF.setSize(100, 50);
		idF.setLocation(200,150);
		add(idF);

		JLabel password = new JLabel("비밀번호");
		password.setFont(font.deriveFont(20f));
		password.setBounds(80, 180, 100, 150);
		add(password);
		passwordF = new JPasswordField(10);
		passwordF.setSize(100, 50);
		passwordF.setLocation(200,230);
		add(passwordF);
		
	}

//	public VUserInfo login(Scanner keyboard){
//		
//		System.out.println("사용자 아이디 입력하세요.");
//		 // 이건 변환시켜주는 애. 키보드랑 연결해야될 꺼 아니야 키보드가 System.in이야. 이렇게 해야 나의 키보드만 독립적으로 쓸 수 있다.
//		String userId = keyboard.next();
//		System.out.println(userId);
//		System.out.println("비밀번호를 입력하세요.");
//		String password = keyboard.next();
//		System.out.println(password);
//		
//		
//		VLogin vLogin = new VLogin();
//		vLogin.setUserId(userId);
//		vLogin.setPassword(password);
//		// 그릇에 담았다.
//		CLogin cLgoin = new CLogin();
//		
//		VUserInfo vUserInfo = cLgoin.login(vLogin); // account한테 유저 info을 받아와야한다.
//		
//		if(vUserInfo ==null) {
//			System.out.println("잘못 입력하셨습니다.");
//		}
//		else {
//			System.out.println(vUserInfo.getName()+"님 안녕하세요.");
//		}
//		
//		
//		return vUserInfo;
//	}

	public JButton getButtone() {
		return loginBtn;
		
	}

	public VUserInfo login() {
		VLogin vLogin = new VLogin();
		vLogin.setUserId(idF.getText());
		char[] password = passwordF.getPassword();
		String pw = new String(password);
		vLogin.setPassword(pw);
		CLogin cLgoin = new CLogin();		
		VUserInfo vUserInfo = cLgoin.login(vLogin); 
		if(vUserInfo ==null) {
			JOptionPane.showMessageDialog(null, "올바른 정보가 아닙니다.");
		}
		else {
			JOptionPane.showMessageDialog(null, vUserInfo.getName()+"님 안녕하세요.");
			this.setVisible(false);
		}
		return vUserInfo;
		
	}
}
