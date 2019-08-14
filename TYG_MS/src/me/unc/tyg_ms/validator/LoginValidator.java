package me.unc.tyg_ms.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import me.unc.tyg_ms.dto.User;

@Repository("loginValidator")
public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		//验证user中的属性是否为空
		ValidationUtils.rejectIfEmpty(arg1, "username", null, "用户名不能为空！");
		ValidationUtils.rejectIfEmpty(arg1, "password", null, "密码不能为空！");
	}

}
