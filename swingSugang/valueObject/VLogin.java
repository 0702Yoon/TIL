package valueObject;

public class VLogin {
 private String userId;
 private String password;

 
	public void setUserId(String userId) {
		this.userId = userId; // �������� �ܺο��� ���޵Ǵ� ��. userId�� ������ userId���� �ȴ�.
		
	}

	public void setPassword(String password) {
		this.password = password;
			
	}

	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	
}
