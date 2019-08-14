package me.unc.tyg_ms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.unc.tyg_ms.dto.Order;
import me.unc.tyg_ms.dto.User;
import me.unc.tyg_ms.service.TygmsYhglService;
import static me.unc.tyg_ms.util.common.Constants.USER_SESSION;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

	//注入service
	@Autowired
	@Qualifier("tygmsYhglService")
	private TygmsYhglService tygmsYhglService;
	
	/**
	 * 创建订单
	 * @param order
	 * @param session
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/creatorder")
	public ModelAndView createOrder(@ModelAttribute Order order, 
			HttpSession session, ModelAndView mv, RedirectAttributes attr) {
		try {
			//获取当前session的用户标识
			User curUser = (User) session.getAttribute(USER_SESSION);
			order.setUser(curUser);
			order.setcDate(new Date());
			tygmsYhglService.addOrder(order);
			order.setNumber();
			tygmsYhglService.modifyOrder(order);
			attr.addFlashAttribute("message", "创建订单成功！");
			mv.setViewName("main");
			System.out.println("OrderController -----> 创建订单");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.addObject("message", "创建订单失败！");
			mv.setViewName("main");
		}
		return mv;
	}
	
	/**
	 * 查询所有订单
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loadallorder")
	@ResponseBody
	public Object loadAllOrder() throws Exception {
		List<Order> allList = new ArrayList<Order>();
		allList = tygmsYhglService.findAllOrder();
		System.out.println("OrderController -----> 加载系统所有订单");
		return allList;
	}
	
	/**
	 * 加载当前用户的订单信息
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loadorder")
	@ResponseBody
	public Object loadOrderByUserId(HttpSession session) throws Exception {
		//获取当前用户标识
		User curUser = (User) session.getAttribute(USER_SESSION);
		List<Order> orderList = new ArrayList<Order>();
		orderList = tygmsYhglService.findOrderByUserId(curUser.getId());
		System.out.println("OrderController -----> 加载当前用户订单" + orderList);
		return orderList;
	}
	
	/**
	 * 修改订单
	 * @param order
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/modifyorder")
	public ModelAndView modifyOrder(@ModelAttribute Order order, 
			ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.modifyOrder(order);
			attr.addFlashAttribute("message", "订单修改成功！");
			mv.setViewName("redirect:/main");
			System.out.println("OrderController -----> 用户修改订单");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "订单修改失败！");
			mv.setViewName("main");
		}
		return mv;
	}
	
	/**
	 * 删除订单
	 * @param order
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteorder")
	public ModelAndView deleteOrder(@ModelAttribute Order order, 
			ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.removeOrderById(order.getId());
			attr.addFlashAttribute("message", "订单删除成功！");
			mv.setViewName("redirect:/main");
			System.out.println("OrderController -----> 用户删除订单");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "订单删除失败！");
			mv.setViewName("main");
		}
		return mv;
	}
	
}
