package com.asiainfo.portal.modules.project.model;

import java.util.Date;

public class Project {
	private Integer id;
	private String name;
	private String departId;
	private String departName;
	private Integer level;
	private Double amount;
	private Date inputDate;
	private Date releaseTime;
	private String orgId;
	private String orgName;
	private String townId;
	private String townName;
	private String hamletId;
	private String hamletName;
	private String comm;

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

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getTownId() {
		return townId;
	}

	public void setTownId(String townId) {
		this.townId = townId;
	}

	public String getHamletId() {
		return hamletId;
	}

	public void setHamletId(String hamletId) {
		this.hamletId = hamletId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public String getHamletName() {
		return hamletName;
	}

	public void setHamletName(String hamletName) {
		this.hamletName = hamletName;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

}
