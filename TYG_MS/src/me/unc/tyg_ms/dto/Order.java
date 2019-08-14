package me.unc.tyg_ms.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order implements Serializable{
	/**
	 * 订单信息
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;              //订单ID
	private User user;               //一对一，用户id
	private String number;           //订单号
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rDate;               //订单创建日期
	private Integer state;           //订单状态
	private OrderDetail orderDetail; //一对一，订单详细
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cDate;              //订单创建日期
	
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber() {
		Integer time = Integer.parseInt(getcDate().toString());
		this.number = time.toString() + getId().toString();
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
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", number=" + number + ", rDate=" + rDate + ", state=" + state
				+ ", orderDetail=" + orderDetail + ", cDate=" + cDate + "]";
	}
	public Order(Integer id, User user, String number, Date rDate, Integer state, OrderDetail orderDetail, Date cDate) {
		super();
		this.id = id;
		this.user = user;
		this.number = number;
		this.rDate = rDate;
		this.state = state;
		this.orderDetail = orderDetail;
		this.cDate = cDate;
	}
	
}
