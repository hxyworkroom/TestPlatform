package cn.hy.testplatform.manage.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer uid;
	@Column  
	private String uname;
	private String usex;
	private Integer uage;
	private String ueducate;
	private String umajor;
	private String ulocal;
	private String udepartment;
	private String uphone;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public Integer getUage() {
		return uage;
	}
	public void setUage(Integer uage) {
		this.uage = uage;
	}
	public String getUeducate() {
		return ueducate;
	}
	public void setUeducate(String ueducate) {
		this.ueducate = ueducate;
	}
	public String getUmajor() {
		return umajor;
	}
	public void setUmajor(String umajor) {
		this.umajor = umajor;
	}
	public String getUlocal() {
		return ulocal;
	}
	public void setUlocal(String ulocal) {
		this.ulocal = ulocal;
	}
	public String getUdepartment() {
		return udepartment;
	}
	public void setUdepartment(String udepartment) {
		this.udepartment = udepartment;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", usex=" + usex
				+ ", uage=" + uage + ", ueducate=" + ueducate + ", umajor="
				+ umajor + ", ulocal=" + ulocal + ", udepartment="
				+ udepartment + ", uphone=" + uphone + "]";
	}
}
