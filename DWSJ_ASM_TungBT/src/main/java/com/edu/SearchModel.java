package com.edu;

import java.util.Date;

public class SearchModel {
	private int type;
	private String ma;
	private Date fromDate;
	private Date toDate;

	public SearchModel() {
		super();
	}

	public SearchModel(int type, String ma, Date fromDate, Date toDate) {
		super();
		this.type = type;
		this.ma = ma;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

}
