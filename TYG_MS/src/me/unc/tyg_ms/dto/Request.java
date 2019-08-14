package me.unc.tyg_ms.dto;

import java.io.Serializable;

public class Request implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;          //id
	private User user;           //用户
	private Identity identity;   //身份
	private Integer state;       //状态
	
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
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Request [id=" + id + ", user=" + user + ", identity=" + identity + ", state=" + state + "]";
	}
	public Request(Integer id, User user, Identity identity, Integer state) {
		super();
		this.id = id;
		this.user = user;
		this.identity = identity;
		this.state = state;
	}
	
}
