package com.ai.dao;

import com.ai.bean.Message;
import com.ai.db.DBAccess;

import org.apache.ibatis.session.SqlSession;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 和message表相关的数据库操作
 */
public class MessageDao{
    private static final Logger LOGGER = Logger.getLogger(MessageDao.class);


    public List<Message> queryMessageList(String command, String description) {
        DBAccess db = new DBAccess();
        SqlSession sqlSession = null;
        List<Message> msgList = new ArrayList<Message>();
        try {
            sqlSession = db.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);

            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            msgList = iMessage.queryMessageList(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return msgList;
    }

    /**
     *
     * @param id
     */
    public void deleteOne(int id) {

        DBAccess db = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = db.getSqlSession();

            // 通过sqlSession执行sql语句
            sqlSession.selectList("Message.deleteOne", id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    public void deleteBatch(List<Integer> ids) {

        DBAccess db = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = db.getSqlSession();

            // 通过sqlSession执行sql语句
            sqlSession.selectList("Message.deleteBatch", ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void main(String[] args) {
        MessageDao dao = new MessageDao();
        dao.queryMessageList("", "");

    }


}
