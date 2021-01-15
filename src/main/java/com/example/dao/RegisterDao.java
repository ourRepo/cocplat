package com.example.dao;


import com.example.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegisterDao {
    void registerNewMember(Users user) throws Exception;

}
