package com.daviddone.bean;

public class SeeBugInfo {
	private String bugNumTitle;
	private String bugNum;
	private String pocNumTitle;
	private String pocNum;
	private String cashNumTitle;
	private String cashNum;
	public SeeBugInfo(String bugNumTitle, String bugNum, String pocNumTitle,
			String pocNum, String cashNumTitle, String cashNum,
			String offerMoneyTitle, String offerMoney) {
		super();
		this.bugNumTitle = bugNumTitle;
		this.bugNum = bugNum;
		this.pocNumTitle = pocNumTitle;
		this.pocNum = pocNum;
		this.cashNumTitle = cashNumTitle;
		this.cashNum = cashNum;
		this.offerMoneyTitle = offerMoneyTitle;
		this.offerMoney = offerMoney;
	}
	public String getBugNumTitle() {
		return bugNumTitle;
	}
	public void setBugNumTitle(String bugNumTitle) {
		this.bugNumTitle = bugNumTitle;
	}
	public String getBugNum() {
		return bugNum;
	}
	public void setBugNum(String bugNum) {
		this.bugNum = bugNum;
	}
	public String getPocNumTitle() {
		return pocNumTitle;
	}
	public void setPocNumTitle(String pocNumTitle) {
		this.pocNumTitle = pocNumTitle;
	}
	public String getPocNum() {
		return pocNum;
	}
	public void setPocNum(String pocNum) {
		this.pocNum = pocNum;
	}
	public String getCashNumTitle() {
		return cashNumTitle;
	}
	public void setcashNumTitle(String cashNumTitle) {
		this.cashNumTitle = cashNumTitle;
	}
	public String getcashNum() {
		return cashNum;
	}
	@Override
	public String toString() {
		return "SeeBugInfo [bugNumTitle=" + bugNumTitle + ", bugNum=" + bugNum
				+ ", pocNumTitle=" + pocNumTitle + ", pocNum=" + pocNum
				+ ", cashNumTitle=" + cashNumTitle + ", cashNum=" + cashNum
				+ ", offerMoneyTitle=" + offerMoneyTitle + ", offerMoney="
				+ offerMoney + "]";
	}
	public void setCashNum(String cashNum) {
		this.cashNum = cashNum;
	}
	public String getOfferMoneyTitle() {
		return offerMoneyTitle;
	}
	public void setOfferMoneyTitle(String offerMoneyTitle) {
		this.offerMoneyTitle = offerMoneyTitle;
	}
	public String getOfferMoney() {
		return offerMoney;
	}
	public void setOfferMoney(String offerMoney) {
		this.offerMoney = offerMoney;
	}
	private String offerMoneyTitle;
	private String offerMoney;
}
