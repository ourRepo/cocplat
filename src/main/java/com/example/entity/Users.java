package com.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*
 * 2021/1/5
 * Mikael
 * 
 *用户实体类
 */
@Data
@Getter
@Setter
public class Users {
	
	//用户Id
	public String userId;
	//用户姓名
	public String userName;
	//用户生日
	public String birthDay;
	//用户性别
	public String gender;
	//用户电话号码
	public String phoneNumber;
	//用户账号
	public String account;
	//用户密码
	public String password;
	//用户等级(1管理员 2vip用户 3普通用户 0超级管理员)
	public String userStatus;

}
