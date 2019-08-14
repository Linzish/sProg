package me.unc.tyg_ms.dao.provider;

import static me.unc.tyg_ms.util.common.Constants.USER_DETAILTABLE;

import org.apache.ibatis.jdbc.SQL;

import me.unc.tyg_ms.dto.User_Detail;

public class User_DetailDynaSqlProvider {
	
	//动态更新
	public String updateDetail(User_Detail user_detail) {
		return new SQL() {
			{
				UPDATE(USER_DETAILTABLE);
				if(user_detail.getName() != null) {
					SET(" name = #{name} ");
				}
				if(user_detail.getGender() != null) {
					SET(" gender = #{gender} ");
				}
				if(user_detail.getBirthday() != null) {
					SET(" birthday = #{birthday} ");
				}
				if(user_detail.getCertificate_type() != null) {
					SET(" certificate_type = #{certificate_type} ");
				}
				if(user_detail.getCertificate_num() != null) {
					SET(" certificate_num = #{certificate_num} ");
				}
				if(user_detail.getNativeplace() != null) {
					SET(" nativeplace = #{nativeplace} ");
				}
				if(user_detail.getAddress() != null) {
					SET(" address = #{address} ");
				}
				if(user_detail.getPhone_num() != null) {
					SET(" phone_num = #{phone_num} ");
				}
				if(user_detail.getReg_date() != null) {
					SET(" reg_date = #{reg_date} ");
				}
				if(user_detail.getId_number() != null) {
					SET(" id_number = #{id_number} ");
				}
				if(user_detail.getEmail() != null) {
					SET(" email = #{email} ");
				}
				if(user_detail.getUser() != null) {
					SET(" user_id = #{user.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	//动态插入
	public String insertUserDetail(User_Detail user_detail) {
		return new SQL() {
			{
				INSERT_INTO(USER_DETAILTABLE);
				if(user_detail.getName() != null && !user_detail.getName().equals("")) {
					VALUES("name", "#{name}");
				}
				if(user_detail.getGender() != null && !user_detail.getGender().equals("")) {
					VALUES("gender", "#{gender}");
				}
				if(user_detail.getBirthday() != null) {
					VALUES("birthday", "#{birthday}");
				}
				if(user_detail.getCertificate_type() != null && !user_detail.getCertificate_type().equals("")) {
					VALUES("certificate_type", "#{certificate_type}");
				}
				if(user_detail.getCertificate_num() != null && !user_detail.getCertificate_num().equals("")) {
					VALUES("certificate_num", "#{certificate_num}");
				}
				if(user_detail.getNativeplace() != null && !user_detail.getNativeplace().equals("")) {
					VALUES("nativeplace", "#{nativeplace}");
				}
				if(user_detail.getAddress() != null && !user_detail.getAddress().equals("")) {
					VALUES("address", "#{address}");
				}
				if(user_detail.getPhone_num() != null && !user_detail.getPhone_num().equals("")) {
					VALUES("phone_num", "#{phone_num}");
				}
				if(user_detail.getReg_date() != null) {
					VALUES("reg_date", "#{reg_date}");
				}
				if(user_detail.getId_number() != null && !user_detail.getId_number().equals("")) {
					VALUES("id_number", "#{id_number}");
				}
				if(user_detail.getEmail() != null) {
					VALUES("email", "#{email}");
				}
				if(user_detail.getUser() != null) {
					VALUES("user_id", "#{user.id}");
				}
			}
		}.toString();
	}
}
