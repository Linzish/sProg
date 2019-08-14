package me.unc.tyg_ms.dao;

import static me.unc.tyg_ms.util.common.Constants.IDENTITYTABLE;
import static me.unc.tyg_ms.util.common.Constants.IDENTITY_POWER;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import me.unc.tyg_ms.dao.provider.IdentityDynaSqlProvider;
import me.unc.tyg_ms.dto.Identity;

public interface IdentityDao {

	//根据id查找
	@Select("select * from " + IDENTITYTABLE + " where id = #{id} ")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "name", property = "name"),
		@Result(column = "description", property = "description"),
//		@Result(column = "id", property = "powers", 
//			many = @Many(select = "me.unc.tyg_ms.dao.PowerDao.findByIdentityId", fetchType = FetchType.LAZY)),
	})
	Identity findById(Integer id);
	
	//根据名字查找
	@Select("select * from " + IDENTITYTABLE + " where name = #{name} ")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "name", property = "name"),
		@Result(column = "description", property = "description"),
		@Result(column = "id", property = "powers", 
			many = @Many(select = "me.unc.tyg_ms.dao.PowerDao.findByIdentityId", fetchType = FetchType.LAZY)),
	})
	Identity findByName(String name);
	
	//查询全部
	@Select("select * from " + IDENTITYTABLE)
	List<Identity> findAll();
	
	//多对多关系，根据权限id查找身份
	@Select("select * from " + IDENTITYTABLE + " where id in (select identity_id from " + IDENTITY_POWER + " where power_id = #{power_id})")
	List<Identity> fndByPowerId(Integer power_id);
	
	//添加身份
	@Insert("insert into " + IDENTITYTABLE + "(desctiption,name) values(#{description},#{name})")
	void addIdentity(Identity identity);
	
	//删除身份信息
	@Delete("delete from " + IDENTITYTABLE + " where id = #{id}")
	void deleteById(Integer id);
	
	//更新，动态
	@UpdateProvider(type = IdentityDynaSqlProvider.class, method = "updateIdentity")
	void update(Identity identity);
	
	//根据id查找
	@Select("select * from " + IDENTITYTABLE + " where id = #{id} ")
		@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "name", property = "name"),
		@Result(column = "description", property = "description"),
	})
	Identity requestFindById(Integer id);
}
