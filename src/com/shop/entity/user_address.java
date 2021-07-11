package com.shop.entity;

public class user_address {
	private int ADDRESS_ID;
	private String ADDRESS_NAME;
	private String ADDRESS_MOBILE;
	private String ADDRESS_TEXT;
	private String ADDRESS_TEXTS;
	private String ADDRESS_U_ID;
	public user_address(int aDDRESS_ID, String aDDRESS_NAME, String aDDRESS_MOBILE, String aDDRESS_TEXT,
			String aDDRESS_TEXTS, String aDDRESS_U_ID) {
		super();
		ADDRESS_ID = aDDRESS_ID;
		ADDRESS_NAME = aDDRESS_NAME;
		ADDRESS_MOBILE = aDDRESS_MOBILE;
		ADDRESS_TEXT = aDDRESS_TEXT;
		ADDRESS_TEXTS = aDDRESS_TEXTS;
		ADDRESS_U_ID = aDDRESS_U_ID;
	}
	public int getADDRESS_ID() {
		return ADDRESS_ID;
	}
	public void setADDRESS_ID(int aDDRESS_ID) {
		ADDRESS_ID = aDDRESS_ID;
	}
	public String getADDRESS_NAME() {
		return ADDRESS_NAME;
	}
	public void setADDRESS_NAME(String aDDRESS_NAME) {
		ADDRESS_NAME = aDDRESS_NAME;
	}
	public String getADDRESS_MOBILE() {
		return ADDRESS_MOBILE;
	}
	public void setADDRESS_MOBILE(String aDDRESS_MOBILE) {
		ADDRESS_MOBILE = aDDRESS_MOBILE;
	}
	public String getADDRESS_TEXT() {
		return ADDRESS_TEXT;
	}
	public void setADDRESS_TEXT(String aDDRESS_TEXT) {
		ADDRESS_TEXT = aDDRESS_TEXT;
	}
	public String getADDRESS_TEXTS() {
		return ADDRESS_TEXTS;
	}
	public void setADDRESS_TEXTS(String aDDRESS_TEXTS) {
		ADDRESS_TEXTS = aDDRESS_TEXTS;
	}
	public String getADDRESS_U_ID() {
		return ADDRESS_U_ID;
	}
	public void setADDRESS_U_ID(String aDDRESS_U_ID) {
		ADDRESS_U_ID = aDDRESS_U_ID;
	}
	
	
}
