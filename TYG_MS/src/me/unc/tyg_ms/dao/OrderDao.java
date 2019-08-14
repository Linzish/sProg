package me.unc.tyg_ms.dao;

import static me.unc.tyg_ms.util.common.Constants.ORDERTABLE;

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

import me.unc.tyg_ms.dao.provider.OrderDynaSqlProvider;
import me.unc.tyg_ms.dto.Order;

public interface OrderDao {
	
	//根据id查询
	@Select("select * from " + ORDERTABLE + " where id = #{id}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "data", property = "date"),
		@Result(column = "state", property = "state"),
		@Result(column = "number", property = "number"),
		@Result(column = "user_id", property = "user", 
			one = @One(select = "me.unc.tyg_ms.dao.UserDao.findById", fetchType = FetchType.LAZY)),
		@Result(column = "detail_id", property = "orderDetail", 
			one = @One(select = "me.unc.tyg_ms.dao.OrderDetailDao.findById", fetchType = FetchType.EAGER)),
		//订单详细待写.....
	})
	Order findById(Integer id);
	
	//全查
	@Select("select * from " + ORDERTABLE)
	List<Order> findAll();
	
	//根据用户id查找
	@Select("select * from " + ORDERTABLE + " where user_id = #{user_id}")
	@Results({
		@Result(id = true, column = "id", property = "id"),
		@Result(column = "data", property = "date"),
		@Result(column = "state", property = "state"),
		@Result(column = "number", property = "number"),
		@Result(column = "detail_id", property = "orderDetail", 
			one = @One(select = "me.unc.tyg_ms.dao.OrderDetailDao.findById", fetchType = FetchType.EAGER)),
		//订单详细待写.....
	})
	List<Order> findByUserId(Integer user_id);
	
	//根据id删除
	@Delete("delete from " + ORDERTABLE + " where id = #{id}")
	void delete(Integer id);
	
	//添加订单
	@InsertProvider(type = OrderDynaSqlProvider.class, method = "insertOrder")
	@SelectKey(statement = "select LAST_INSERT_ID() as id", before = false, keyProperty = "id", resultType = Integer.class, statementType = StatementType.STATEMENT)
	void saveOrder(Order order);

	//更新订单
	@UpdateProvider(type = OrderDynaSqlProvider.class, method = "updateOrder")
	void update(Order order);
	
	//更新状态1
	@Update("update " + ORDERTABLE + " set state = 1 where id = #{id}")
	void updateStateTo1(Integer id);
	
	//更新状态0
	@Update("update " + ORDERTABLE + " set state = 0 where id = #{id}")
	void updateStateTo0(Integer id);
}
