package me.unc.tyg_ms.dto;

import java.io.Serializable;

public class OrderDetail implements Serializable{
	/**
	 * 订单详细
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", desc=" + desc + "]";
	}
	
}
