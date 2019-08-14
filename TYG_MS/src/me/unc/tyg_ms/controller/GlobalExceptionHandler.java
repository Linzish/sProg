package me.unc.tyg_ms.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView globalErrorHandler(Exception e) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", e);
		mv.setViewName("error");
		return mv;
	}
	
}
