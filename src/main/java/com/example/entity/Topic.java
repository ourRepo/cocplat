package com.example.entity;

import lombok.Data;

@Data
public class Topic {
    //话题ID
    public String topicId;
    //用户ID
    public String userId;
    //时间
    public String date;
    //浏览次数
    public int viewNum;
    //标题
    public String title;
    //内容
    public String content;
    //状态(1：普通 0:置顶)
    public String status;
    //用户姓名
    public String userName;


}
