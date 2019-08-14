package me.unc.tyg_ms.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User_Detail implements Serializable{
	/**
	 * 用户详细信息
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;               //id主键
	private String name;              //用户姓名
	private String gender;            //性别
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;            //出生日期
	private String certificate_type;  //证件类型
	private String certificate_num;   //证件号码
	private String nativeplace;       //籍贯
	private String address;           //联系地址
	private String phone_num;         //联系电话
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reg_date;            //注册时间
	private String id_number;         //学号/工号
	private Integer state;            //状态
	private String email;             //邮箱
	private User user;                //一对一用户
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCertificate_type() {
		return certificate_type;
	}
	public void setCertificate_type(String certificate_type) {
		this.certificate_type = certificate_type;
	}
	public String getCertificate_num() {
		return certificate_num;
	}
	public void setCertificate_num(String certificate_num) {
		this.certificate_num = certificate_num;
	}
	public String getNativeplace() {
		return nativeplace;
	}
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public User_Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User_Detail [id=" + id + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday
				+ ", certificate_type=" + certificate_type + ", certificate_num=" + certificate_num + ", nativeplace="
				+ nativeplace + ", address=" + address + ", phone_num=" + phone_num + ", reg_date=" + reg_date
				+ ", id_number=" + id_number + ", state=" + state + ", email=" + email + ", user=" + user + "]";
	}
	public User_Detail(Integer id, String name, String gender, Date birthday, String certificate_type,
			String certificate_num, String nativeplace, String address, String phone_num, Date reg_date,
			String id_number, Integer state, String email, User user) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.certificate_type = certificate_type;
		this.certificate_num = certificate_num;
		this.nativeplace = nativeplace;
		this.address = address;
		this.phone_num = phone_num;
		this.reg_date = reg_date;
		this.id_number = id_number;
		this.state = state;
		this.email = email;
		this.user = user;
	}
	
}
