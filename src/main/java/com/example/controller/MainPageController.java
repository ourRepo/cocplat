package com.example.controller;

import com.example.dao.TopicDao;
import com.example.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class MainPageController {
    @Autowired
    private TopicDao topicDao;
    @RequestMapping
    public void selectTopics(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        //1.查询置顶的话题
        List<Topic> specialTopicList = topicDao.findSpecialTopic();
        //2.查询普通的话题
        List<Topic> normalTopicList = topicDao.findNormalTopic();

        session.setAttribute("specialTopicList",specialTopicList);
        session.setAttribute("normalTopicList",normalTopicList);

        response.sendRedirect("/mainPage");
    }
}
