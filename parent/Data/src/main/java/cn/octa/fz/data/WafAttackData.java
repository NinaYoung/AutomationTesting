package cn.octa.fz.data;

import basicClasses.AbstractData;

public class WafAttackData extends AbstractData {

	private String hostname;
	private String dvwa;
	private String status;
	private String attackChangeMsg = "请求成功";
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getDvwa() {
		return dvwa;
	}
	public void setDvwa(String dvwa) {
		this.dvwa = dvwa;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAttackChangeMsg() {
		return attackChangeMsg;
	}
	public void setAttackChangeMsg(String attackChangeMsg) {
		this.attackChangeMsg = attackChangeMsg;
	}
	
}
