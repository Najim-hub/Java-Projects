package testpack;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class User extends SimpleTagSupport{
	private int uid;
	private String loginName, Name, loginPass1, loginPass2;
	public User() {
		super();
	}
	
	public User(int uid, String loginName, String name, String loginPass1, String loginPass2) {
		super();
		this.uid = uid;
		this.loginName = loginName;
		this.Name = name;
		this.loginPass1 = loginPass1;
		this.loginPass2 = loginPass2;
	}
	
	public User(int uid, String loginName, String name, String loginPass1) {
		super();
		this.uid = uid;
		this.loginName = loginName;
		Name = name;
		this.loginPass1 = loginPass1;
	}
	
	
	public User(int uid) {
		super();
		this.uid=uid;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLoginPass1() {
		return loginPass1;
	}
	public void setLoginPass1(String loginPass1) {
		this.loginPass1 = loginPass1;
	}
	public String getLoginPass2() {
		return loginPass2;
	}
	public void setLoginPass2(String loginPass2) {
		this.loginPass2 = loginPass2;
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		
		JspWriter out = getJspContext().getOut();
		out.println("<p> Hello, Welcome"); 
		
		getJspBody().invoke(null);
		out.println("</p>");
	}
	
	
	
}
