package com.wisezone.crm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wisezone.base.ResultInfo;
import com.wisezone.base.exception.ParamException;

@RestControllerAdvice
public class ParmExceptionHandlder
{
	private static Logger logger = LoggerFactory.getLogger(ParmExceptionHandlder.class);
	
	@ExceptionHandler(value=ParamException.class)
	public ResultInfo exceptionHandler(ParamException exception)
	{
		ResultInfo resultInfo = new ResultInfo();
		Integer integer =  exception.getErrorCode();// 获取异常的code
		String message = exception.getMessage(); // 获取异常的消息
		resultInfo.setResultCode(integer);
		resultInfo.setResult(message);
		logger.error("参数异常:{}",exception); // 打印异常
		return resultInfo;
	}
}
