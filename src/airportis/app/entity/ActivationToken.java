package airportis.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activation_tokens")
public class ActivationToken {
	
	@Id
	@Column(name="user_id")
	int userId;
	
	@Column(name="token")
	String token;

	public ActivationToken() {}
	
	public ActivationToken(int userId, String token) {
		this.userId = userId;
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "ActivationToken [userId=" + userId + ", token=" + token + "]";
	}
	
}
