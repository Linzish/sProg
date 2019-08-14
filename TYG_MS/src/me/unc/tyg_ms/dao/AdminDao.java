package me.unc.tyg_ms.dao;

import static me.unc.tyg_ms.util.common.Constants.ADMIN;
import static me.unc.tyg_ms.util.common.Constants.IDENTITY_POWER;
import static me.unc.tyg_ms.util.common.Constants.USERTABLE;

import java.util.List;

import static me.unc.tyg_ms.util.common.Constants.REQUESTTABLE;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import me.unc.tyg_ms.dto.*;

public interface AdminDao {
	
	@Select("select * from " + ADMIN + " where username = #{username} and password = #{password}")
	Admin findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	//添加身份权限关系
	@Insert("insert into " + IDENTITY_POWER + "(identity_id,power_id) values(#{identity.id},#{power.id})")
	void addIdentity_Power(Identity identity, Power power);
	
	//用户身份认证
	@Update("update " + USERTABLE + " set identity_id = #{id} where id = #{user_id}")
	void identityUser(@Param("id") Integer id, @Param("user_id") Integer user_id);
	
	//删除认证请求
	@Delete("delete from " + REQUESTTABLE + " where user_id = #{id}")
	void deleteRequest(Integer id);
	
	//查询所有请求
	@Select("select * from " + REQUESTTABLE)
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "identity_id", property = "identity", 
			one = @One(select = "me.unc.tyg_ms.dao.IdentityDao.requestFindById", fetchType = FetchType.EAGER)),
		@Result(column = "user_id", property = "user", 
			one = @One(select = "me.unc.tyg_ms.dao.UserDao.requestFindById", fetchType = FetchType.EAGER)),
	})
	List<Request> findAllRequest();
	
	//查询状态为1的请求
	@Select("select * from " + REQUESTTABLE + " where state = #{state}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "identity_id", property = "identity", 
			one = @One(select = "me.unc.tyg_ms.dao.IdentityDao.requestFindById", fetchType = FetchType.EAGER)),
		@Result(column = "user_id", property = "user", 
			one = @One(select = "me.unc.tyg_ms.dao.UserDao.requestFindById", fetchType = FetchType.EAGER)),
	})
	List<Request> findRequestState0(Integer state);
	
	//查询状态为0的请求
	@Select("select * from " + REQUESTTABLE + " where state = #{state}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "identity_id", property = "identity", 
			one = @One(select = "me.unc.tyg_ms.dao.IdentityDao.requestFindById", fetchType = FetchType.EAGER)),
		@Result(column = "user_id", property = "user", 
			one = @One(select = "me.unc.tyg_ms.dao.UserDao.requestFindById", fetchType = FetchType.EAGER)),
	})
	List<Request> findRequestState1(Integer state);
	
	//更改请求状态为1
	@Update("update " + REQUESTTABLE + " set state = 1 where id = #{id}")
	void modifyRequestStateTo1(Integer id);
	
}
