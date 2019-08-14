package me.unc.tyg_ms.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.mapping.StatementType;

import me.unc.tyg_ms.dao.provider.UserDynaSqlProvider;
import me.unc.tyg_ms.dto.Identity;
import me.unc.tyg_ms.dto.User;
import static me.unc.tyg_ms.util.common.Constants.USERTABLE;
import static me.unc.tyg_ms.util.common.Constants.REQUESTTABLE;

import java.util.List;
import java.util.Map;

public interface UserDao {
	
	//根据登录名和密码查询用户
	@Select("select * from " + USERTABLE + " where username = #{username} and password = #{password}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "username", property = "username"),
		@Result(column = "password", property = "password"),
		@Result(column = "state", property = "state"),
		@Result(column = "wallet", property = "wallet"),
		@Result(column = "identity_id", property = "identity",
			one = @One(select = "me.unc.tyg_ms.dao.IdentityDao.findById", fetchType = FetchType.LAZY)),
	})
	User findByLoginnameAndPassword(@Param("username") String username, @Param("password") String password);
	
	//根据id查询用户
	@Select("select * from " + USERTABLE + " where id = #{id}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "username", property = "username"),
		@Result(column = "password", property = "password"),
		@Result(column = "state", property = "state"),
		@Result(column = "identity_id", property = "identity",
			one = @One(select = "me.unc.tyg_ms.dao.IdentityDao.findById", fetchType = FetchType.LAZY)),
		@Result(column = "id", property = "orders", 
			many = @Many(select = "me.unc.tyg_ms.dao.OrderDao.findByUserId", fetchType = FetchType.LAZY)),
		@Result(column = "id", property = "messages", 
			many = @Many(select = "me.unc.tyg_ms.dao.MessageDao.findByUserId", fetchType = FetchType.LAZY))
	})
	User findById(@Param("id") Integer id);
	
	//根据名称查询用户
	@Select("select * from " + USERTABLE + " where username = #{username}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "username", property = "username"),
		@Result(column = "password", property = "password"),
		@Result(column = "state", property = "state"),
	})
	User findByName(String name);
	
	//根据身份查询用户
	@Select("select * from " + USERTABLE + " where identity_id = #{id}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "username", property = "username"),
		@Result(column = "password", property = "password"),
		@Result(column = "state", property = "state"),
		@Result(column = "identity_id", property = "identity",
			one = @One(select = "me.unc.tyg_ms.dao.IdentityDao.findById", fetchType = FetchType.LAZY)),
		@Result(column = "id", property = "orders", 
			many = @Many(select = "me.unc.tyg_ms.dao.OrderDao.findByUserId", fetchType = FetchType.LAZY)),
		@Result(column = "id", property = "messages", 
			many = @Many(select = "me.unc.tyg_ms.dao.MessageDao.findByUserId", fetchType = FetchType.LAZY))
	})
	List<User> findUserByIdentity(Integer id);
	
	//查询所有用户
	@Select("select * from " + USERTABLE )
	List<User> findAllUser();
	
	//根据id删除用户
	@Delete("delete from " + USERTABLE + " where id = #{id}")
	void deleteById(Integer id);
	
	//登录状态1
	@Update("update " + USERTABLE + " set state = 1 where id = #{id}")
	void loginStateTo1(Integer id);
	
	//添加用户详细资料
	@Update("update " + USERTABLE + " set detail_id = #{id} where id = #{user_id}")
	void addUserDetail(@Param("id") Integer id, @Param("user_id") Integer user_id);
	
	//登录状态2
	@Update("update " + USERTABLE + " set state = 0 where id = #{id}")
	void loginStateTo0(Integer id);
	
	//身份认证
	@Update("update " + USERTABLE + " set identity_id = #{identity.id} where id = #{user.id}")
	void identity(User user, Identity identity);
	
	//动态插入用户
	@InsertProvider(type=UserDynaSqlProvider.class, method = "insertUser")
	@SelectKey(statement = "select LAST_INSERT_ID() as id", before = false, keyProperty = "id", resultType = Integer.class, statementType = StatementType.STATEMENT)
	void saveUser(User user);
	
	//动态更新用户
	@UpdateProvider(type=UserDynaSqlProvider.class, method = "updateUser")
	void update(User user);
	
	//动态查询
	@SelectProvider(type=UserDynaSqlProvider.class, method = "selectWithParam")
	List<User> selectByPage(Map<String, Object> params);
	
	//查询用户总数
	@SelectProvider(type=UserDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);
	
	//请求身份认证
	@Insert("insert into " + REQUESTTABLE + "(user_id,identity_id) values(#{user_id},#{identity_id})")
	void identityRequest(@Param("user_id") Integer user_id, @Param("identity_id") Integer identity_id);
	
	//根据id查询用户
	@Select("select * from " + USERTABLE + " where id = #{id}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "username", property = "username"),
		@Result(column = "password", property = "password"),
		@Result(column = "state", property = "state"),
	})
	User requestFindById(@Param("id") Integer id);
}