package com.wisezone.crm.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisezone.base.exception.LoginBizException;
import com.wisezone.base.exception.ParamException;
import com.wisezone.crm.constant.Constant;
import com.wisezone.crm.dao.UserDao;
import com.wisezone.crm.model.User;
import com.wisezone.crm.util.AssertUtil;
import com.wisezone.crm.util.MD5Util;
import com.wisezone.crm.util.UserIDBase64;
import com.wisezone.crm.vo.LoginUserInfo;
import com.wisezone.crm.vo.UserLoginIdentity;

@Service
public class UserService
{
	@Autowired
	private UserDao userDao;
	
	public List<User> listAll()
	{
		List<User> users = userDao.listAll();
		return users;
	}
	
	/**
	 * 用户登录
	 * @param userName 用户名
	 * @param password	密码
	 * @param roleNam	角色密码
	 * @return
	 * 2016年11月25日 下午5:53:54
	 * UserLoginIdentity
	 */
	public UserLoginIdentity login(String userName,String password,String roleName)
	{
		//基本参数的校验
//		if (StringUtils.isBlank(userName))
//		{
//			throw new ParamException("请输入用户名");
//		}
//		if (StringUtils.isBlank(password))
//		{
//			throw new ParamException("请输入密码");
//		}
//		if (StringUtils.isBlank(roleName))
//		{
//			throw new ParamException("请选择用户类型");
//		}
		AssertUtil.notEmpty(userName, "请输入用户名");
		AssertUtil.notEmpty(password, "请输入密码");
		AssertUtil.notEmpty(roleName, "请选择用户类型");
		
		//判断用户是否存在
		password = MD5Util.md5Method(password);
		User user = userDao.findUserByUserNamePwdRole(userName.trim(),
				password, roleName.trim());
		
//		if (user == null)
//		{
//			throw new ParamException("用户名或密码错误");
//		}
		AssertUtil.notNull(user, "用户名或密码错误");
		//封装返回对象
		UserLoginIdentity userLoginIdentity = new UserLoginIdentity();
		userLoginIdentity.setUserIdString(UserIDBase64.encoderUserID(user.getId()));
		userLoginIdentity.setUserName(userName);
		return userLoginIdentity;
	}

	/**
	 * 获取登录用户的信息
	 * @param userId
	 * @return
	 * 2016年11月26日 上午12:27:19
	 * LoginUserInfo
	 */
	public LoginUserInfo findLoginUser(Integer userId)
	{
//		if (userId == null || userId < 1)
//		{
//			throw new LoginBizException(Constant.LOGIN_FIRST);
//		}
//		User user = userDao.loadById(userId);
//		if (user == null)
//		{
//			throw new LoginBizException(Constant.LOGIN_FIRST);
//		}
		User user = findUserById(userId);
		LoginUserInfo loginUserInfo = new LoginUserInfo();
		loginUserInfo.setRealName(user.getTrueName());
		loginUserInfo.setRoleName(user.getRoleName());
		loginUserInfo.setUserName(user.getUserName());
		return loginUserInfo;
	}

	/**
	 * 系统管理修改密码
	 * @param oldPassword	旧密码
	 * @param newPassword	新密码
	 * @param confirmPassword	确认密码
	 * @param userId
	 * 2016年11月26日 上午9:12:30
	 * void
	 */
	public void updatePassword(String oldPassword, String newPassword, String confirmPassword, Integer userId)
	{
		//1.基本参数校验
		checkUpdatePwdParams(oldPassword, newPassword, confirmPassword);
		//2.通过用户id获取用户信息
		User user = findUserById(userId);
		//3.校验旧密码是否正确
		if (!MD5Util.md5Method(oldPassword).equals(user.getPassword()))
		{
			throw new ParamException("旧密码输入错误，请重新输入");
		}
		//4.更新新密码
		int updateCount = userDao.updatePassword(userId,MD5Util.md5Method(newPassword));
		if (updateCount == 0)
		{
			throw new ParamException(Constant.OPT_FAILURE);
		}
	}
	
	/**
	 * 获取客户经理
	 * @return
	 * 2016年11月26日 下午12:54:10
	 * List<User>
	 */
	public List<User> findCustomerManagers()
	{
		List<User> customerManagers = userDao.findByRoleName("客户经理");
        return customerManagers;
	}
	
	
	/**
	 * 通过userId获取用户信息
	 * @param userId
	 * @return
	 * 2016年11月26日 上午9:24:57
	 * User
	 */
	private User findUserById(Integer userId)
	{
		if (userId == null || userId < 1)
		{
			throw new LoginBizException(Constant.LOGIN_FIRST);
		}
		User user = userDao.loadById(userId);
		if (user == null)
		{
			throw new LoginBizException(Constant.LOGIN_FIRST);
		}
		return user;
	}
	
	/**
	 * 更新密码的参数校验
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmPassword
	 * 2016年11月26日 上午9:22:46
	 * void
	 */
	public static void checkUpdatePwdParams(String oldPassword, String newPassword, String confirmPassword)
	{
//		if (StringUtils.isBlank(oldPassword))
//		{
//			throw new ParamException("请输入旧密码");
//		}
//		if (StringUtils.isBlank(newPassword))
//		{
//			throw new ParamException("请输入新密码");
//		}
//		if (StringUtils.isBlank(confirmPassword))
//		{
//			throw new ParamException("请输入确实密码");
//		}
//		if (!confirmPassword.equals(newPassword))
//		{
//			throw new ParamException("确定密码两次输入不一致");
//		}
		
		AssertUtil.notEmpty(oldPassword, "请输入旧密码");
		AssertUtil.notEmpty(newPassword, "请输入新密码");
		AssertUtil.notEmpty(confirmPassword, "请输入确认密码");
		AssertUtil.isTrue(!confirmPassword.equals(newPassword), "确认密码不一致");
	}

	
}
