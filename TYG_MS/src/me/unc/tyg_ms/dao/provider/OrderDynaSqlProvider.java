package me.unc.tyg_ms.dao.provider;

import static me.unc.tyg_ms.util.common.Constants.ORDERTABLE;

import org.apache.ibatis.jdbc.SQL;

import me.unc.tyg_ms.dto.Order;

public class OrderDynaSqlProvider {
	
	//动态添加
	public String insertOrder(Order order) {
		return new SQL() {
			{
				INSERT_INTO(ORDERTABLE);
				if(order.getrDate() != null) {
					VALUES("rDate", "#{rDate}");
				}
				if(order.getcDate() != null) {
					VALUES("cDate", "#{cDate}");
				}
				if(order.getNumber() != null && !order.getNumber().equals("")) {
					VALUES("number", "#{number}");
				}
				if(order.getUser() != null) {
					VALUES("user_id", "#{user.id}");
				}
				if(order.getOrderDetail() != null) {
					VALUES("detail_id", "#{orderDetail.id}");
				}
			}
		}.toString();
	}
	
	//动态更新
	public String updateOrder(Order order) {
		return new SQL() {
			{
				UPDATE(ORDERTABLE);
				if(order.getNumber() != null) {
					SET(" number = #{number} ");
				}
				if(order.getrDate() != null) {
					SET(" rDate = #{rDate} ");
				}
				if(order.getUser() != null) {
					SET(" user_id = #{user.id} ");
				}
				if(order.getState() != null) {
					SET(" state = #{state} ");
				}
				if(order.getOrderDetail() != null) {
					SET(" detail_id = #{orderDetail.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}
