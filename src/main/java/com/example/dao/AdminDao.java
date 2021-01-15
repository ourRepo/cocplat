package com.example.dao;



import com.example.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminDao {
	@Select("select * from user where account = #{account} and password = #{password}")
	List<Users> login(Users users) throws Exception;
	@Select("select * from user where account = ?")
	List<Users> checkAccount(String account) throws Exception;
	List<Users> findSomeUser()throws Exception;
	@Select("select * from user")
	List<Users> findAll();
}
