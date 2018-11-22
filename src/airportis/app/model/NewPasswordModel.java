package airportis.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import airportis.app.validator.FieldMatch;

@FieldMatch.List(@FieldMatch(first="newPassword", second="newPassword2", message="New passwords have to match"))
public class NewPasswordModel {
	
	@NotNull(message="This field is required")
	private String oldPassword;

	@NotNull(message="This field is required")
	@Size(min=8, message="Password have to be at least 8 characters long")
	private String newPassword;
	
	@NotNull(message="This field is required")
	@Size(min=8, message="Password have to be at least 8 characters long")
	private String newPassword2;
	
	private String oldUserPassword;
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOldUserPassword() {
		return oldUserPassword;
	}

	public void setOldUserPassword(String oldUserPassword) {
		this.oldUserPassword = oldUserPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPassword2() {
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}
}
