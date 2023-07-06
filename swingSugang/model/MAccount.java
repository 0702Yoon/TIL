package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class MAccount {

	public VUserInfo login(VLogin vLogin) {		
		VUserInfo vUserInfo = null; 
		try {
		Scanner keyboard = new Scanner(new File("account/account"));
		while(keyboard.hasNext()) {
			String line = keyboard.nextLine();
			String[] tokens = line.split(" "); // 사용법 제대로 알기.		
			if(tokens[0].equals(vLogin.getUserId())) {
				if(tokens[1].equals(vLogin.getPassword())) {
					vUserInfo =new VUserInfo();
					vUserInfo.setName(tokens[2]);
					break;
				}
			}
		}
	
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vUserInfo;
	}

}
