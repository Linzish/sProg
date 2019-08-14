package me.unc.tyg_ms.dao.provider;

import static me.unc.tyg_ms.util.common.Constants.POWERTABLE;

import org.apache.ibatis.jdbc.SQL;

import me.unc.tyg_ms.dto.Power;

public class PowerDynaSqlProvider {
	
	//动态添加
	public String updatePower(Power power) {
		return new SQL() {
			{
				UPDATE(POWERTABLE);
				if(power.getName() != null) {
					SET(" name = #{neme}" );
				}
				if(power.getDescription() != null) {
					SET(" description = #{description}" );
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}
