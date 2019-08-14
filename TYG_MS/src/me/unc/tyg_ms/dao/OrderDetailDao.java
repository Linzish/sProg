package me.unc.tyg_ms.dao;

import static me.unc.tyg_ms.util.common.Constants.ORDER_DETAIL;

import org.apache.ibatis.annotations.Select;

import me.unc.tyg_ms.dto.OrderDetail;

public interface OrderDetailDao {

	//根据id查询
	@Select("select * from " + ORDER_DETAIL + " where id = #{id}")
	OrderDetail findById(Integer id);
	
}
