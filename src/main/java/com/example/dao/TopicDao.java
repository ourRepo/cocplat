package com.example.dao;



import com.example.entity.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TopicDao {
    //添加新的话题
    void addNewTopic(Topic topic) throws Exception;
    //查询置顶话题
    List<Topic> findSpecialTopic() throws Exception;
    //查询普通话题
    List<Topic> findNormalTopic() throws Exception;
    //查询全部话题
    List<Topic> findAllTopic() throws Exception;
}
