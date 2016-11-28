package com.wisezone.crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisezone.base.ResultInfo;

@RestController
public class TestController
{
	@RequestMapping("test")
	public ResultInfo test()
	{
		return new ResultInfo(0,"hello");
	}
	
	
	@RequestMapping("test1")
	public ResultInfo test1()
	{
		return new ResultInfo(0,"world");
	}
}
