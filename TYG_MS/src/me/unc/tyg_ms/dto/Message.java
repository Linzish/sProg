package me.unc.tyg_ms.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Message implements Serializable{
	/**
	 * 信息公布
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;    //信息id
	private User user;     //一对一，用户id
	private String title;  //标题
	private String msg;    //信息内容
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cDate;    //创建时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pDate;    //发布时间
	private Integer state; //状态
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", user=" + user + ", title=" + title + ", msg=" + msg + ", cDate=" + cDate
				+ ", pDate=" + pDate + ", state=" + state + "]";
	}
	public Message(Integer id, User user, String title, String msg, Date cDate, Date pDate, Integer state) {
		super();
		this.id = id;
		this.user = user;
		this.title = title;
		this.msg = msg;
		this.cDate = cDate;
		this.pDate = pDate;
		this.state = state;
	}
	
}
