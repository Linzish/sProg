package me.unc.tyg_ms.dao;

import static me.unc.tyg_ms.util.common.Constants.POWERTABLE;

import java.util.List;

import static me.unc.tyg_ms.util.common.Constants.IDENTITY_POWER;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import me.unc.tyg_ms.dao.provider.PowerDynaSqlProvider;
import me.unc.tyg_ms.dto.Power;

public interface PowerDao {
	
	//根据id查找
	@Select("select * from " + POWERTABLE + " where id = #{id}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "name", property = "name"),
		@Result(column = "description", property = "description"),
//		@Result(column = "id", property = "identitys", 
//			many = @Many(select = "me.unc.tyg_ms.dao.IdentityDao.fndByPowerId", fetchType = FetchType.LAZY))
	})
	Power findById(Integer id);
	
	//根据名字查找
	@Select("select * from " + POWERTABLE + " where name = #{name}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "name", property = "name"),
		@Result(column = "description", property = "description"),
//		@Result(column = "id", property = "identitys", 
//			many = @Many(select = "me.unc.tyg_ms.dao.IdentityDao.fndByPowerId", fetchType = FetchType.LAZY))
	})
	Power findByName(String name);
	
	//查询全部
	@Select("select * from " + POWERTABLE)
	List<Power> findAll();
	
	//多对多关系，根据身份id查找
	@Select("select * from " + POWERTABLE + " where id in (select identity_id from " + IDENTITY_POWER + " where identity_id = #{identity_id})")
	List<Power> findByIdentityId(Integer identity_id);
	
	//添加权限
	@Insert("insert into " + POWERTABLE + "(desctiption,name) values(#{desctiption},#{name})")
	void addPower(Power power);
	
	//删除
	@Delete("delete from " + POWERTABLE + " where id = #{id}")
	void delete(Integer id);
	
	//动态添加
	@SelectProvider(type = PowerDynaSqlProvider.class, method = "updatePower")
	void update(Power power);
}
