package me.unc.tyg_ms.dao.provider;

import static me.unc.tyg_ms.util.common.Constants.IDENTITYTABLE;

import org.apache.ibatis.jdbc.SQL;

import me.unc.tyg_ms.dto.Identity;

public class IdentityDynaSqlProvider {

	//动态更新
	public String updateIdentity(Identity identity) {
		return new SQL() {
			{
				UPDATE(IDENTITYTABLE);
				if(identity.getName() != null) {
					SET(" name = #{name} ");
				}
				if(identity.getDescription() != null) {
					SET(" description = #{description} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
}
