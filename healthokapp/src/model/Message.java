package model;

public class Message {

	int status;
    String msg=null;
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
   
	public String getMessage(){
		  return this.msg;
	}
	
	public void setMessage(String msg) {
		this.msg = msg;
	}
	
}
