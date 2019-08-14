package me.unc.tyg_ms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.unc.tyg_ms.dto.Admin;
import me.unc.tyg_ms.dto.Identity;
import me.unc.tyg_ms.dto.User;
import me.unc.tyg_ms.dto.User_Detail;
import me.unc.tyg_ms.service.TygmsYhglService;
import me.unc.tyg_ms.validator.LoginValidator;

import static me.unc.tyg_ms.util.common.Constants.USER_SESSION;
import static me.unc.tyg_ms.util.common.Constants.USER_IDENTITY;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

	//注入service
	@Autowired
	@Qualifier("tygmsYhglService")
	private TygmsYhglService tygmsYhglService;
	
	@Autowired
	@Qualifier("loginValidator")
	private LoginValidator loginValidator;
	
	/**
	 * 全局绑定时间格式
	 * @param request
	 * @param binder
	 */
	@InitBinder 
	protected void init(HttpServletRequest request, ServletRequestDataBinder binder) { 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		dateFormat.setLenient(false); 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); 
	}
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @param session 
	 * @param mv
	 * @return 视图
	 * @throws Exception
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(@ModelAttribute User user,  
			HttpSession session, ModelAndView mv, Errors errors) throws Exception {
		//调用业务逻辑组件判断是否可以登录
		/*mv.addObject("user", user);
		loginValidator.validate(user, errors);
		if(errors.hasErrors()) {
			mv.setViewName("loginForm");
		} else {*/
			User curUser = tygmsYhglService.login(user.getUsername(), user.getPassword());
			if(curUser != null) {
				//保存到session
				Identity user_identity = curUser.getIdentity();
				session.setAttribute(USER_SESSION, curUser);
				session.setAttribute(USER_IDENTITY, user_identity);
				mv.setViewName("redirect:/main");
				System.out.println("UserController -----> 用户登录" + user.toString());
			} else {
				//设置登录失败提醒信息
				mv.addObject("message", "登录名或密码错误！请重新输入");
				mv.setViewName("loginForm");
			}
		//}
		return mv;
	}
	
	/**
	 * 用户登出
	 * @param session
	 * @param mv
	 * @param attr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loginout")
	public ModelAndView login(HttpSession session, 
			ModelAndView mv, RedirectAttributes attr) throws Exception {
		session.setAttribute(USER_SESSION, null);
		session.setAttribute(USER_IDENTITY, null);
		attr.addFlashAttribute("remessage", "退出成功");
		mv.setViewName("redirect:/loginForm");
		System.out.println("UserController -----> 用户登出");
		return mv;
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		return "main";
	}
	
	@RequestMapping(value = "/loginForm")
	public String loginForm(@ModelAttribute User user, @ModelAttribute Admin admin, Model model) {
		System.out.println("UserController -----> loginForm方法被调用");
		return "loginForm";
	}
	
	@RequestMapping(value = "/registerform")
	public String registerForm(@ModelAttribute User user, Model model) {
		System.out.println("UserController -----> registerForm方法被调用");
		return "registerForm";
	}
	
	@RequestMapping(value = "/repasswordform")
	public String repassform(@ModelAttribute User user, Model model) {
		System.out.println("UserController -----> repassform方法被调用");
		return "rePasswordForm";
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @param user_detail
	 * @param mv
	 * @return 视图
	 */
	@RequestMapping(value = "/register")
	public ModelAndView register(@ModelAttribute User user, ModelAndView mv, RedirectAttributes attr) {
		try {
			//查找用户是否存在
			User euser = tygmsYhglService.findUserByName(user.getUsername());
			if(euser != null) {
				mv.addObject("message", "用户名已存在！");
				mv.setViewName("registerForm");
			} else {
				//保存并保存关系
				tygmsYhglService.addUser(user);
				User_Detail user_detail = new User_Detail();				
				user_detail.setUser(user);
				user_detail.setReg_date(new Date());
				tygmsYhglService.addUserDetail(user_detail);
				attr.addFlashAttribute("remessage", "注册成功");
				mv.setViewName("redirect:/loginForm");
				System.out.println("UserController -----> 用户注册");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			attr.addFlashAttribute("remessage", "注册失败");
			mv.setViewName("redirect:/registerForm");
		}
		return mv;
	}
	
	/**
	 * 用户添加详细信息
	 * @param user_detail
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/useradddetail")
	public ModelAndView addDetail(@ModelAttribute User_Detail user_detail, 
			HttpSession session, ModelAndView mv, RedirectAttributes attr) {
		try {
			User curUser = (User) session.getAttribute(USER_SESSION);
			tygmsYhglService.addUserDetail(user_detail);
			tygmsYhglService.userAddDetail(user_detail.getId(), curUser.getId());
			System.out.println("UserController -----> 用户添加详细信息");
			attr.addFlashAttribute("message", "添加详细信息成功");
			mv.setViewName("redirect:/main");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "添加详细信息失败");
			mv.setViewName("main");
		}
		return mv;
	}
	
	/**
	 * 用户修改密码
	 * @param username
	 * @param password
	 * @param newPassword
	 * @param session
	 * @param mv
	 * @return 视图
	 * @throws Exception
	 */
	@RequestMapping(value = "/usermpass")
	public ModelAndView modifyPassword(@RequestParam("newPassword") String newPassword , 
			HttpSession session, ModelAndView mv, RedirectAttributes attr) throws Exception{
		//获取用户
		User curUser = (User) session.getAttribute(USER_SESSION);
		if(curUser != null) {
			curUser.setPassword(newPassword);
			tygmsYhglService.modifyUser(curUser);
			attr.addFlashAttribute("message", "修改密码成功");
			session.setAttribute(USER_SESSION, curUser);
			mv.setViewName("redirect:/main");
			System.out.println("UserController -----> 用户修改密码" + curUser.getUsername());
		} else {
			mv.addObject("message", "错误!");
			mv.setViewName("main");
		}
		return mv;
	}
	
	/**
	 * 用户重置密码
	 * @param username
	 * @param email
	 * @param newPassword
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/repass")
	public ModelAndView rePass(@RequestParam("username") String username, 
			@RequestParam("email") String email, @RequestParam("newPassword") String newPassword ,
			ModelAndView mv, RedirectAttributes attr) throws Exception {
		//获取用户/详细
		User curUser = tygmsYhglService.findUserByName(username);
//		User_Detail user_detail = tygmsYhglService.findUserDetailByUserId(curUser.getId());
//		System.out.println(email);
//		System.out.println(user_detail.getEmail())
		User_Detail user_detail = curUser.getUser_detail();
		String userEmail = user_detail.getEmail();
		if(userEmail.equals(email)) {
			curUser.setPassword(newPassword);
			tygmsYhglService.modifyUser(curUser);
			attr.addFlashAttribute("remessage", "重置密码成功");
			mv.setViewName("redirect:/loginForm");
			System.out.println("UserController -----> 用户重置密码" + username);
		} else {
			mv.addObject("message", "用户信息不匹配！");
			mv.setViewName("rePasswordForm");
		}
		return mv;
	}
	
	/**
	 * 用户请求身份认证
	 * @param identity_id
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/identityrequset")
	public ModelAndView identityRequest(@RequestParam("identity_id") Integer identity_id, 
			HttpSession session, ModelAndView mv, RedirectAttributes attr) {
		try {
			//获取当前session的用户信息
			User user = (User) session.getAttribute(USER_SESSION);
			tygmsYhglService.userRequestIdentity(user.getId(), identity_id);
			attr.addFlashAttribute("message", "请求提交成功！");
			mv.setViewName("redirect:/main");
			System.out.println("UserController -----> 用户身份认证请求");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("identityrequset_message", "请求提交失败！");
			mv.setViewName("main");
		}
		return mv;
	}
	
	/**
	 * 加载用户详细信息
	 * @param session
	 * @param model
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "/userdetail")
	public Object loadUserDeatil(HttpSession session, Model model) throws Exception {
		//获取当前session的用户信息
		User user = (User) session.getAttribute(USER_SESSION);
		//获取用户详细
		User_Detail user_detail = tygmsYhglService.finduserdetailByUserId(user.getId());
		model.addAttribute("user_detail", user_detail);
		List<User_Detail> list = new ArrayList<User_Detail>();
		list.add(user_detail);
		System.out.println("UserController -----> 加载用户详细信息" + user_detail.toString());
		return list;
	}
	
	/**
	 * 用户修改详细信息
	 * @param user_detail 用户详细信息对象
	 * @param session 当前用户session
	 * @param mv
	 * @return mv
	 */
	@RequestMapping(value = "/modifydetail")
	public ModelAndView modifyUserDetail(@ModelAttribute User_Detail user_detail, 
			HttpSession session, ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.modifyUserDetail(user_detail);
			attr.addFlashAttribute("message", "修改成功！");
			mv.setViewName("redirect:/main");
			System.out.println("UserController -----> 用户修改详细信息" + user_detail.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "修改失败！");
			mv.setViewName("main");
		}
		return mv;
	}
	
	/**
	 * 加载一次权限信息，用于权限控制
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/useridentity")
	@ResponseBody
	public Object userIdentity(HttpSession session, Model model) {
		//获取当前session的身份信息
		Identity identity =  (Identity) session.getAttribute(USER_IDENTITY);
		model.addAttribute("identity", identity);
//		List<Identity> list = new ArrayList<Identity>();
//		list.add(identity);
		System.out.println("UserController -----> 加载当前用户身份信息" + identity.toString());
		return identity;
	}
	
}
