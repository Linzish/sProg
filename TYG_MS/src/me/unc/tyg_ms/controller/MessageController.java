package me.unc.tyg_ms.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.unc.tyg_ms.dto.Message;
import me.unc.tyg_ms.dto.User;
import me.unc.tyg_ms.service.TygmsYhglService;
import static me.unc.tyg_ms.util.common.Constants.USER_SESSION;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {

	//注入service
	@Autowired
	@Qualifier("tygmsYhglService")
	private TygmsYhglService tygmsYhglService;
	
	/**
	 * 创建公告消息
	 * @param message
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/createmessage")
	public ModelAndView createMessage(@ModelAttribute Message message, 
			HttpSession session, ModelAndView mv, RedirectAttributes attr) {
		//权限判断??
		try {
			//获取用户标识
			User curUser = (User) session.getAttribute(USER_SESSION);
			message.setUser(curUser);
			message.setcDate(new Date());
			tygmsYhglService.addMessage(message);
			attr.addFlashAttribute("message", "公告信息创建成功！");
			mv.setViewName("redirect:/main");
			System.out.println("MessageController -----> 创建公告消息");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "公告信息创建失败！");
			mv.setViewName("main");
		}
		return mv;
	}
	
	/**
	 * 查找所有公告信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/allmessage")
	@ResponseBody
	public Object findAllMessage() throws Exception {
		List<Message> allList = new ArrayList<Message>();
		allList = tygmsYhglService.findAllMessage();
		System.out.println("MessageController -----> 查找所有公告信息");
		return allList;
	}
	
	/**
	 * 根据id查找信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loadmessagebyid")
	@ResponseBody
	public void findMsgById(@RequestBody Message message, HttpServletResponse response) throws Exception {
		message = tygmsYhglService.findMessageById(message.getId());
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("MessageController -----> 根据id查找信息" + message.toString());
		response.getWriter().println(mapper.writeValueAsString(message));
	}
	
	/**
	 * 根据用户id查找公告信息
	 * @param seesion
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/usersmessage")
	@ResponseBody
	public Object findMessageByUser(HttpSession seesion) throws Exception {
		//获取当前用户标识
		User curUser = (User) seesion.getAttribute(USER_SESSION);
		List<Message> userMsgList = new ArrayList<Message>();
		userMsgList = tygmsYhglService.findMessageByUserId(curUser.getId());
		System.out.println("MessageController -----> 根据用户id查找公告信息");
		return userMsgList;
	}
	
	/**
	 * 查找可公布公告信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loadmessage")
	@ResponseBody
	public Object loadMessage() throws Exception {
		List<Message> msgList = new ArrayList<Message>();
		msgList = tygmsYhglService.findMessageWithstate1();
		System.out.println("MessageController -----> 查找可公布公告信息");
		return msgList;
	}
	
	/**
	 * 修改公告信息
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "modifymessage")
	public ModelAndView modifyMessage(@ModelAttribute Message message, 
			ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.modifyMessage(message);
			attr.addFlashAttribute("message", "修改公告信息成功！");
			mv.setViewName("redirect:/main");
			System.out.println("MessageController -----> 修改公告信息");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.addObject("message", "修改公告信息失败！");
			mv.setViewName("main");
		}
		return mv;
	}
	
	/**
	 * 删除公告信息
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deletemessage")
	public ModelAndView deleteMessage(@ModelAttribute Message message, 
			ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.removeMessageById(message.getId());
			attr.addFlashAttribute("message", "删除公告信息成功！");
			mv.setViewName("redirect:/main");
			System.out.println("MessageController -----> 删除公告信息");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.addObject("message", "删除公告信息失败！");
			mv.setViewName("main");
		}
		return mv;
	}
	
}
