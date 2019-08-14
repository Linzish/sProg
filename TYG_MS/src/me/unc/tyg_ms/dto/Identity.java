package me.unc.tyg_ms.dto;

import java.io.Serializable;
import java.util.List;

public class Identity implements Serializable{
	/**
	 * 身份信息
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;           //身份id，主键
	private String name;          //身份名称
	private String description;   //身份描述
	private List<Power> powers;    //多对多，权限
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Power> getPowers() {
		return powers;
	}
	public void setPowers(List<Power> powers) {
		this.powers = powers;
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
	public Identity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Identity [id=" + id + ", name=" + name + ", description=" + description + ", powers=" + powers + "]";
	}
	public Identity(Integer id, String name, String description, List<Power> powers) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.powers = powers;
	}
	
}
