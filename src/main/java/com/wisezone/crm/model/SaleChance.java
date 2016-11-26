package com.wisezone.crm.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 销售机会实体 Created by Tony on 2016/8/23.
 */
@SuppressWarnings("serial")
public class SaleChance implements Serializable
{
	private Integer id; // 编号
	private String chanceSource; // 机会来源
	private Integer customerId; // 客户Id
	private String customerName; // 客户名称
	private int cgjl; // 成功几率
	private String overview; // 概要
	private String linkMan; // 联系人
	private String linkPhone; // 联系电话
	private String description; // 机会描述
	private String createMan; // 创建人
	private String assignMan; // 指派人
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date assignTime; // 指派时间
	private Integer state; // 分配状态 0 未分配 1 已分配
	private Integer devResult; // 客户开发状态 0 未开发 1 开发中 2 开发成功 3 开发失败
	private Integer isValid;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateDate;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getChanceSource()
	{
		return chanceSource;
	}

	public void setChanceSource(String chanceSource)
	{
		this.chanceSource = chanceSource;
	}

	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public int getCgjl()
	{
		return cgjl;
	}

	public void setCgjl(int cgjl)
	{
		this.cgjl = cgjl;
	}

	public String getOverview()
	{
		return overview;
	}

	public void setOverview(String overview)
	{
		this.overview = overview;
	}

	public String getLinkMan()
	{
		return linkMan;
	}

	public void setLinkMan(String linkMan)
	{
		this.linkMan = linkMan;
	}

	public String getLinkPhone()
	{
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone)
	{
		this.linkPhone = linkPhone;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCreateMan()
	{
		return createMan;
	}

	public void setCreateMan(String createMan)
	{
		this.createMan = createMan;
	}

	public String getAssignMan()
	{
		return assignMan;
	}

	public void setAssignMan(String assignMan)
	{
		this.assignMan = assignMan;
	}

	public Date getAssignTime()
	{
		return assignTime;
	}

	public void setAssignTime(Date assignTime)
	{
		this.assignTime = assignTime;
	}

	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}

	public Integer getDevResult()
	{
		return devResult;
	}

	public void setDevResult(Integer devResult)
	{
		this.devResult = devResult;
	}

	public Integer getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(Integer customerId)
	{
		this.customerId = customerId;
	}

	public Integer getIsValid()
	{
		return isValid;
	}

	public void setIsValid(Integer isValid)
	{
		this.isValid = isValid;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}
}