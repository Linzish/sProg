package me.unc.tyg_ms.dao.provider;

import static me.unc.tyg_ms.util.common.Constants.MESSAGETABLE;

import org.apache.ibatis.jdbc.SQL;

import me.unc.tyg_ms.dto.Message;

public class MessageDynaSqlProvider {

	//动态插入
	public String insertMessage(Message message) {
		return new SQL() {
			{
				INSERT_INTO(MESSAGETABLE);
				if(message.getMsg() != null && !message.getMsg().equals("")) {
					VALUES("msg", "#{msg}");
				}
				if(message.getcDate() != null) {
					VALUES("cDate", "#{cDate}");
				}
				if(message.getTitle() != null && !message.getTitle().equals("")) {
					VALUES("title", "#{title}");
				}
				if(message.getpDate() != null) {
					VALUES("pDate", "#{pDate}");
				}
				if(message.getUser() != null) {
					VALUES("user_id", "#{user.id}");
				}
				if(message.getState() != null) {
					VALUES("state", "#{state}");
				}
			}
		}.toString();
	}
	
	//动态更新
	public String upateMessage(Message message) {
		return new SQL() {
			{
				UPDATE(MESSAGETABLE);
				if(message.getMsg() != null) {
					SET(" msg = #{msg} ");
				}
				if(message.getTitle() != null) {
					SET(" title = #{title} ");
				}
				if(message.getcDate() != null) {
					SET(" cDate = #{cDate} ");
				}
				if(message.getpDate() != null) {
					SET(" pDate = #{pDate} ");
				}
				if(message.getState() != null) {
					SET(" state = #{state} ");
				}
				if(message.getUser() != null) {
					SET(" user_id = #{user.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
}
