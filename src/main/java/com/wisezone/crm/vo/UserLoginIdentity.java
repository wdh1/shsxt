package com.wisezone.crm.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserLoginIdentity implements Serializable
{
	private String userIdString;
	private String userName;
	public String getUserIdString()
	{
		return userIdString;
	}
	public void setUserIdString(String userIdString)
	{
		this.userIdString = userIdString;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	
}
