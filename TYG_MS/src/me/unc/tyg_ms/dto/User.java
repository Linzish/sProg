package me.unc.tyg_ms.dto;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable{
	/**
	 * 用户基础信息
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;            //用户id，主键
	private String username;       //用户登录名
	private String password;       //用户登陆密码
	private Identity identity;     //用户身份
	private Integer state;         //用户状态
	private List<Order> orders;    //一对多，订单id
	private List<Message> messages;//一对多，信息id
	private User_Detail user_detail; //一对一，用户信息id
	private Integer wallet;             //钱包
	
	public Integer getWallet() {
		return wallet;
	}
	public void setWallet(Integer wallet) {
		this.wallet = wallet;
	}
	public User_Detail getUser_detail() {
		return user_detail;
	}
	public void setUser_detail(User_Detail user_detail) {
		this.user_detail = user_detail;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", identity=" + identity
				+ ", state=" + state + ", orders=" + orders + ", messages=" + messages + ", user_detail=" + user_detail
				+ ", wallet=" + wallet + "]";
	}
	public User(Integer id, String username, String password, Identity identity, Integer state, List<Order> orders,
			List<Message> messages, User_Detail user_detail, Integer wallet) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.identity = identity;
		this.state = state;
		this.orders = orders;
		this.messages = messages;
		this.user_detail = user_detail;
		this.wallet = wallet;
	}
	
}
