package valueObject;

public class VLogin {
 private String userId;
 private String password;

 
	public void setUserId(String userId) {
		this.userId = userId; // 오른쪽은 외부에서 전달되는 것. userId는 내부의 userId값이 된다.
		
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
