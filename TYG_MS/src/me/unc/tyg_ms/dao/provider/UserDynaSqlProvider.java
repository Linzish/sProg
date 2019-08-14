package me.unc.tyg_ms.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import me.unc.tyg_ms.dto.User;
import static me.unc.tyg_ms.util.common.Constants.USERTABLE;

import java.util.Map;

public class UserDynaSqlProvider {
	
	//动态更新
	public String updateUser(User user) {
		return new SQL() {
			{
				UPDATE(USERTABLE);
				if(user.getUsername() != null) {
					SET(" username = #{username} ");
				}
				if(user.getPassword() != null) {
					SET(" password = #{password} ");
				}
				if(user.getWallet() != null) {
					SET(" password = #{password} ");
				}
				if(user.getIdentity() != null) {
					SET(" identity_id = #{identity.id} ");
				}				
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	//动态插入
	public String insertUser(User user) {
		return new SQL() {
			{
				INSERT_INTO(USERTABLE);
				if(user.getUsername() != null && !user.getUsername().equals("")) {
					VALUES("username", "#{username}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")) {
					VALUES("password", "#{password}");
				}
				if(user.getIdentity() != null) {
					VALUES("identity_id", "#{identity.id}");
				}				
			}
		}.toString();
	}
	//分页动态查询
	public String selectWithParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user") != null) {
					User user = (User)params.get("user");
					if(user.getUsername() != null && user.getUsername().equals("")) {
						WHERE(" username LIKE CONCAT ('%',#{username},'%') ");
					}		
				}
			}
		}.toString();
		if(params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
		}
		return sql;
	}
	//动态查询总数量
	public String count(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user = (User) params.get("user");
					if(user.getUsername() != null && user.getUsername().equals("")) {
						WHERE(" username LIKE CONCAT ('%',#{username},'%') ");
					}
				}
			}
		}.toString();
	}
}
