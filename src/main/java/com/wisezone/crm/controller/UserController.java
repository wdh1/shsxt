package com.wisezone.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisezone.base.ResultInfo;
import com.wisezone.crm.constant.Constant;
import com.wisezone.crm.model.User;
import com.wisezone.crm.service.UserService;
import com.wisezone.crm.util.LoginUserUtil;
import com.wisezone.crm.vo.UserLoginIdentity;

@Controller
@RequestMapping("user")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@RequestMapping("list")
	public String listAll(Model model)
	{
		List<User> users = userService.listAll();
		model.addAttribute("users", users);
		return "user_list";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public ResultInfo login(String userName,String password,String roleName)
	{
		try
		{
			UserLoginIdentity result = userService.login(userName, password, roleName);
			return new ResultInfo(result);
		} catch (Exception e)
		{
			return new ResultInfo(Constant.RESULT_ERROR,e.getMessage());
		}
	}
	
	/**
	 * 系统管理修改密码
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmPassword
	 * @param request
	 * @return
	 * 2016年11月26日 上午9:11:31
	 * ResultInfo
	 */
	@RequestMapping(value="update_password")
	@ResponseBody
	public ResultInfo updatePassword(String oldPassword,String newPassword,
			String confirmPassword,HttpServletRequest request){
		try
		{
			Integer userId = LoginUserUtil.loadUserIdFromCookie(request);
			userService.updatePassword(oldPassword,newPassword,confirmPassword,userId);
			return new ResultInfo(Constant.OPT_SUCCESS);
		} catch (Exception e)
		{
			return new ResultInfo(Constant.RESULT_ERROR,e.getMessage());
		}
	}
	
	/**
	 * 客户经理
	 * @return
	 * 2016年11月26日 下午12:51:57
	 * List<User>
	 */
	@RequestMapping("find_customer_manager")
	@ResponseBody
	public List<User> findCustomerManager() 
	{
		List<User> customerManagers = userService.findCustomerManagers();
		return customerManagers;
		
	}
}
