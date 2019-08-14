package me.unc.tyg_ms.dto;

import java.io.Serializable;
import java.util.List;

public class Power implements Serializable{
	/**
	 *权限/功能信息 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;              //权限id，主键
	private String name;             //权限名字
	private String description;      //权限描述
	private List<Identity> identitys; //多对多，身份
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Identity> getIdentitys() {
		return identitys;
	}
	public void setIdentitys(List<Identity> identitys) {
		this.identitys = identitys;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Power() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Power [id=" + id + ", name=" + name + ", description=" + description + ", identitys=" + identitys + "]";
	}
	public Power(Integer id, String name, String description, List<Identity> identitys) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.identitys = identitys;
	}

}
