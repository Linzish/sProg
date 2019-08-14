package me.unc.tyg_ms.dao;

import static me.unc.tyg_ms.util.common.Constants.USER_DETAILTABLE;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.mapping.StatementType;

import me.unc.tyg_ms.dao.provider.User_DetailDynaSqlProvider;
import me.unc.tyg_ms.dto.User_Detail;

public interface User_DetailDao {
	
	//根据id查找
	@Select("select * from " + USER_DETAILTABLE + " where id = #{id}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "name", property = "name"),
		@Result(column = "gender", property = "gender"),
		@Result(column = "birthday", property = "birthday"),
		@Result(column = "certificate_type", property = "certificate_type"),
		@Result(column = "certificate_num", property = "certificate_num"),
		@Result(column = "nativeplace", property = "nativeplace"),
		@Result(column = "address", property = "address"),
		@Result(column = "phone_num", property = "phone_num"),
		@Result(column = "reg_date", property = "reg_date"),
		@Result(column = "id_number", property = "id_number"),
		@Result(column = "email", property = "email"),
		@Result(column = "state", property = "state"),
		@Result(column = "user_id", property = "user", 
			one = @One(select = "me.unc.tyg_ms.dao.UserDao.findById", fetchType = FetchType.LAZY)),
	})
	User_Detail findById(Integer id);
	
	//根据用户id查找
	@Select("select * from " + USER_DETAILTABLE + " where user_id = #{user_id}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "name", property = "name"),
		@Result(column = "gender", property = "gender"),
		@Result(column = "birthday", property = "birthday"),
		@Result(column = "certificate_type", property = "certificate_type"),
		@Result(column = "certificate_num", property = "certificate_num"),
		@Result(column = "nativeplace", property = "nativeplace"),
		@Result(column = "address", property = "address"),
		@Result(column = "phone_num", property = "phone_num"),
		@Result(column = "reg_date", property = "reg_date"),
		@Result(column = "id_number", property = "id_number"),
		@Result(column = "email", property = "email"),
		@Result(column = "state", property = "state"),
	})
	User_Detail findByUserId(Integer user_id);
	
	//根据id删除
	@Delete("delete from " + USER_DETAILTABLE + " where id = #{id}")
	void deleteById(Integer id);
	
	//动态更新
	@UpdateProvider(type = User_DetailDynaSqlProvider.class, method = "updateDetail")
	void update(User_Detail user_detail);
	
	//插入
	@InsertProvider(type = User_DetailDynaSqlProvider.class, method = "insertUserDetail")
	@SelectKey(statement = "select LAST_INSERT_ID() as id", before = false, keyProperty = "id", resultType = Integer.class, statementType = StatementType.STATEMENT)
	void insert(User_Detail user_detail);
	
	//绑定用户
	@Update("update " + USER_DETAILTABLE + " set user_id = #{id}")
	void bindingUser(Integer id);
	
	//更新状态1
	@Update("update " + USER_DETAILTABLE + " set state = 1 where id = #{id}")
	void updateStateTo1(Integer id);
	
	//更新状态0
	@Update("update " + USER_DETAILTABLE + " set state = 0 where id = #{id}")
	void updateStateTo0(Integer id);
}
