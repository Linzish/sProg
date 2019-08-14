package me.unc.tyg_ms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.unc.tyg_ms.dto.Power;
import me.unc.tyg_ms.service.TygmsYhglService;

@Controller
public class PowerController {

	//注入service
	@Autowired
	@Qualifier("tygmsYhglService")
	private TygmsYhglService tygmsYhglService;
	
	/**
	 * 加载所有权限信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loadpower")
	public Object loadPower() throws Exception {
		List<Power> allList = new ArrayList<Power>();
		allList = tygmsYhglService.findAllPower();
		System.out.println("PowerController -----> 加载所有权限信息");
		return allList;
	}
	
	/**
	 * 添加权限信息
	 * @param model
	 * @param power
	 * @return
	 */
	@RequestMapping(value = "/addpower")
	public ModelAndView addPower(@ModelAttribute Power power, 
			ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.addPower(power);
			attr.addFlashAttribute("message", "添加权限信息成功！");
			mv.setViewName("redirect:/adminmain");
			System.out.println("PowerController -----> 添加权限信息");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "添加权限信息失败！");
			mv.setViewName("adminmain");
		}
		return mv;
	}
	
	/**
	 * 删除权限信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deletepower")
	public ModelAndView deletePower(@ModelAttribute Power power, 
			ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.removePowerById(power.getId());
			attr.addFlashAttribute("message", "删除权限信息成功！");
			mv.setViewName("redirect:/adminmain");
			System.out.println("PowerController -----> 删除权限信息信息");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "删除权限信息失败！");
			mv.setViewName("adminmain");
		}
		return mv;
	}
	
	/**
	 * 更改权限信息
	 * @param power
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "modifypower")
	public ModelAndView modifyPower(@ModelAttribute Power power, 
			ModelAndView mv, RedirectAttributes attr) {
		try {
			tygmsYhglService.modifyPower(power);
			attr.addFlashAttribute("message", "更改权限信息成功！");
			mv.setViewName("redirect:/adminmain");
			System.out.println("PowerController -----> 更改权限信息信息");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv.addObject("message", "更改权限信息失败！");
			mv.setViewName("adminmain");
		}
		return mv;
	}
	
}
