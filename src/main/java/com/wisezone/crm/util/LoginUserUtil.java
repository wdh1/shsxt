package com.wisezone.crm.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class LoginUserUtil
{
	/**
	 *	从cookie中获取userId
	 * @param request
	 * @return
	 * 2016年11月26日 上午12:15:57
	 * Integer
	 */
	public static Integer loadUserIdFromCookie(HttpServletRequest request)
	{
		String userIdString = CookieUtil.getCookieValue(request, "userIdString");
		if (StringUtils.isBlank(userIdString))
		{
			return null;
		}
		Integer userId = UserIDBase64.decoderUserID(userIdString);
		return userId;
	}
}
