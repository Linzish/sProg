package me.unc.tyg_ms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.unc.tyg_ms.dto.Identity;
import me.unc.tyg_ms.service.TygmsYhglService;

@Controller
public class IdentityController {

	//注入service
	@Autowired
	@Qualifier("tygmsYhglService")
	private TygmsYhglService tygmsYhglService;
	
	/**
	 * 加载全部身份信息
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/loadidentity")
	@ResponseBody
	public Object loadIdentiy() throws Exception {
		//尝试以json格式返回数据
		List<Identity> list = new ArrayList<Identity>();
		list = tygmsYhglService.findAllIdentity();
		System.out.println("IdentityController -----> 加载所有身份信息");
		return list;
	}
	
	/**
	 * 添加身份信息
	 * @param identity
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addidentity")
	public ModelAndView addIdentity(@ModelAttribute Identity identity, 
			ModelAndView mv, RedirectAttributes attr) throws Exception {
		tygmsYhglService.addIdentity(identity);
		attr.addFlashAttribute("message", "身份信息添加成功");
		mv.setViewName("redirect:/adminmain");
		System.out.println("IdentityController -----> 添加身份信息");
		return mv;
	}
	
	/**
	 * 修改身份信息
	 * @param identity
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifyidentity")
	public ModelAndView modifyIdentity(@ModelAttribute Identity identity, 
			ModelAndView mv, RedirectAttributes attr) throws Exception {
		tygmsYhglService.modifyIdentity(identity);
		attr.addFlashAttribute("message", "修改身份信息成功");
		mv.setViewName("redirect:/adminmain");
		System.out.println("IdentityController -----> 修改身份信息");
		return mv;
	}
	
	/**
	 * 删除身份信息
	 * @param id
	 * @param mv
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteidentity")
	public ModelAndView deleteIdentity(@ModelAttribute Identity identity, 
			ModelAndView mv, RedirectAttributes attr) throws Exception {
		tygmsYhglService.removeIdentityById(identity.getId());
		attr.addFlashAttribute("message", "删除身份信息成功");
		mv.setViewName("redirect:/adminmain");
		System.out.println("IdentityController -----> 删除身份信息");
		return mv;
	}
	
}
