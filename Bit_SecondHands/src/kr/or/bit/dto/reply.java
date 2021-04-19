package kr.or.bit.dto;

import java.util.Date;

public class reply {
	private int rp_num;
	private int p_num;
	private String storename;
	private String rp_content;
	private Date rp_date;
	
	public reply() {}

	public reply(int rp_num, int p_num, String storename, String rp_content, Date rp_date) {
		super();
		this.rp_num = rp_num;
		this.p_num = p_num;
		this.storename = storename;
		this.rp_content = rp_content;
		this.rp_date = rp_date;
	}

	public int getRp_num() {
		return rp_num;
	}

	public void setRp_num(int rp_num) {
		this.rp_num = rp_num;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getRp_content() {
		return rp_content;
	}

	public void setRp_content(String rp_content) {
		this.rp_content = rp_content;
	}

	public Date getRp_date() {
		return rp_date;
	}

	public void setRp_date(Date rp_date) {
		this.rp_date = rp_date;
	}

	@Override
	public String toString() {
		return "reply [rp_num=" + rp_num + ", p_num=" + p_num + ", storename=" + storename + ", rp_content="
				+ rp_content + ", rp_date=" + rp_date + "]";
	};
	
}
