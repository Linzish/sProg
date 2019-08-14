package me.unc.tyg_ms.dao;

import static me.unc.tyg_ms.util.common.Constants.MESSAGETABLE;

import java.util.List;

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

import me.unc.tyg_ms.dao.provider.MessageDynaSqlProvider;
import me.unc.tyg_ms.dto.Message;

public interface MessageDao {

	//根据id查找
	@Select("select * from " + MESSAGETABLE + " where id = #{id}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "msg", property = "msg"),
		@Result(column = "cDate", property = "cDate"),
		@Result(column = "pDate", property = "pDate"),
		@Result(column = "state", property = "state"),
		@Result(column = "title", property = "title"),
//		@Result(column = "user_id", property = "user", 
//			one = @One(select = "me.unc.tyg_ms.dao.UserDao.findById", fetchType = FetchType.EAGER))
	})
	Message findById(Integer id);
	
	//全查
	@Select("select * from " + MESSAGETABLE)
	List<Message> findAll();
	
	//根据用户id查找
	@Select("select * from " + MESSAGETABLE + " where user_id = #{user_id}")
	List<Message> findByUserId(Integer id);
	
	@Select("select * from " + MESSAGETABLE + " where state = 1")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "msg", property = "msg"),
		@Result(column = "cDate", property = "cDate"),
		@Result(column = "pDate", property = "pDate"),
		@Result(column = "title", property = "title"),
		@Result(column = "state", property = "state"),
	})
	List<Message> findByState1();
	
	//根据id删除
	@Delete("delete from " + MESSAGETABLE + " where id = #{id}")
	void delete(Integer id);
	
	//更新
	@UpdateProvider(type = MessageDynaSqlProvider.class, method = "upateMessage")
	void update(Message message);
	
	//插入
	@InsertProvider(type = MessageDynaSqlProvider.class, method = "insertMessage")
	@SelectKey(statement = "select LAST_INSERT_ID() as id", before = false, keyProperty = "id", resultType = Integer.class, statementType = StatementType.STATEMENT)
	void insert(Message message);
	
	//更新状态1
	@Update("update " + MESSAGETABLE + " set state = 1 where id = #{id}")
	void updateStateTo1(Integer id);
	
	
	//更新状态0
	@Update("update " + MESSAGETABLE + " set state = 0 where id = #{id}")
	void updateStateTo0(Integer id);
}
