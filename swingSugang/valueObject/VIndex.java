package valueObject;

import java.util.Scanner;

public class VIndex {
 
		private int code;
		private String name;
		private String fileName;
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		
		
	}
		public void load(Scanner file) {
			this.setCode(file.nextInt());
			this.setName(file.next()) ;
			this.setFileName(file.next());
			
		}
		public void show() {
			System.out.println(this.getCode()+" "+this.getName());
			//내부가 어떻게 생겼는 지 상관없어 관여는 나밖에 없어. 아주 일반적인 명령만 내려면 그게 고대로 나오게 되어있다. 공통함수로 뽑아 낼 수 있다.
		}
}
