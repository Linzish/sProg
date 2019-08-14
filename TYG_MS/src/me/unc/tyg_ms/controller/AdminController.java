package me.unc.tyg_ms.controller;

import static me.unc.tyg_ms.util.common.Constants.USER_SESSION;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.unc.tyg_ms.dto.Admin;
import me.unc.tyg_ms.dto.Identity;
import me.unc.tyg_ms.dto.Power;
import me.unc.tyg_ms.dto.Request;
import me.unc.tyg_ms.service.TygmsYhglService;

@Controller
public class AdminController {

	//注入service
	@Autowired
	@Qualifier("tygmsYhglService")
	private TygmsYhglService tygmsYhglService;
	
	/**
	 * 超级用户登录
	 * @param username
	 * @param password
	 * @param session
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/adminlogin")
	public ModelAndView login(@RequestParam("username") String username, 
			@RequestParam("password") String password, 
			HttpSession session, ModelAndView mv) throws Exception {
		Admin admin = tygmsYhglService.adminLogin(username, password);
		if(admin != null) {
			//保存到session
			session.setAttribute(USER_SESSION, admin);
			mv.setViewName("redirect:/adminmain");
			System.out.println("AdminController -----> 超级用户登录" + username);
		} else {
			//设置登录失败提醒信息
			mv.addObject("message", "登录名或密码错误！请重新输入");
			mv.setViewName("loginForm");
		}
		return mv;
	}
	
	@RequestMapping(value = "/adminmain")
	public String adminmain(Model model,
			@ModelAttribute Request request) {
		return "adminmain";
	}
	
	/**
	 * 加载全部用户请求
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loadrequest")
	@ResponseBody
	public Object loadRequest() throws Exception {
		List<Request> requestList = new ArrayList<Request>();
		requestList = tygmsYhglService.findAllRequest();
		System.out.println("AdminController -----> 加载全部用户请求");
		return requestList;
	}
	
	/**
	 * 加载状态为0用户请求
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loadrequest0")
	@ResponseBody
	public Object loadRequestState0() throws Exception {
		List<Request> request0 = new ArrayList<Request>();
		request0 = tygmsYhglService.findRequestState0(0);
		System.out.println("AdminController -----> 加载状态为0用户请求" + request0);
		return request0;
	}
	
	/**
	 * 加载状态为1用户请求
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loadrequest1")
	@ResponseBody
	public Object loadRequestState1() throws Exception {
		List<Request> request1 = new ArrayList<Request>();
		request1 = tygmsYhglService.findRequestState1(1);
		System.out.println("AdminController -----> 加载状态为1用户请求");
		return request1;
	}
	
	/**
	 * 处理用户身份认证请求
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/identityuser")
	public ModelAndView identityUser(@ModelAttribute Request request,
			ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.modifyUserIdentity(request.getIdentity().getId(), request.getUser().getId());
			tygmsYhglService.modifyRequestStateTo1(request.getId());
			attr.addFlashAttribute("message", "身份认证成功！");
			mv.setViewName("redirect:/adminmain");
			System.out.println("AdminController -----> 处理用户身份认证请求");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "身份认证失败！");
			mv.setViewName("adminmain");
		}
		return mv;
	}
	
	/**
	 * 删除请求
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleterequest")
	public ModelAndView deleteRequest(@ModelAttribute Request request, 
			ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.removeRequest(request.getId());
			attr.addFlashAttribute("message", "删除成功！");
			mv.setViewName("redirect:/adminmain");
			System.out.println("AdminController -----> 请求删除");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "请求删除失败！");
			mv.setViewName("adminmain");
		}
		return mv;
	}
	
	/**
	 * 请求状态更改
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/modifyrequeststate")
	public ModelAndView modifyRequestState(@ModelAttribute Request request, 
			ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.modifyRequestStateTo1(request.getId());
			attr.addFlashAttribute("message", "更改成功！");
			mv.setViewName("redirect:/adminmain");
			System.out.println("AdminController -----> 请求状态更改");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "请求状态更改失败！");
			mv.setViewName("adminmain");
		}
		return mv;
	}
	
	/**
	 * 添加身份权限关系
	 * @param identity
	 * @param power
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "addiprel")
	public ModelAndView addIdentityPowerRelation(@ModelAttribute Identity identity, 
			@ModelAttribute Power power, ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.addIdentityPowerRelation(identity, power);
			attr.addFlashAttribute("message", "添加身份权限关系成功！");
			mv.setViewName("redirect:/adminmain");
			System.out.println("AdminController -----> 添加身份权限关系");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "添加身份权限关系失败！");
			mv.setViewName("adminmain");
		}
		return mv;
	}
	
}
