package com.ai.dao;

import com.ai.bean.Message;

import java.util.List;

/**
 * 与Message配置文件相对应的接口
 */
public interface IMessage {
    public List<Message> queryMessageList(Message msg);
}
