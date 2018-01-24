package com.ai.service;

import com.ai.bean.Message;
import com.ai.dao.MessageDao;

import java.util.List;

/**
 * 列表相关的业务功能
 */
public class CustomerService {


    public List<Message> queryMessageList(String command, String description) {
        MessageDao dao = new MessageDao();
        return dao.queryMessageList(command,description);
    }
}
