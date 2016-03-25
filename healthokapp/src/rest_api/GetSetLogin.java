package rest_api;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class GetSetLogin {

	public String email=null;
	public String password=null;
	public String firstName=null;
	public String lastName=null;
	public String phone=null;
	public String loginid = null; // this could be the emailId or mobile
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		 this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@JsonProperty("loginid")
	public String getLoginId() {
		return loginid;
	}
	@JsonProperty("loginid")
	public void setLoginId(String loginId) {
		this.loginid = loginId;
	}
}
