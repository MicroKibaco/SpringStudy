package com.ai.dao;

import com.ai.bean.Message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 和message表相关的数据库操作
 */
public class MessageDao {

    public List<Message> queryMessageList(String command, String description) {
        List<Message> msgList = new ArrayList<Message>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8",
                    "root", "MicroKibaco0813");
            StringBuilder sql = new StringBuilder("SELECT ID,COMMAND,DESCRIPTION,CONTENT FROM MESSAGE where 1=1");
            List<String> paramList = new ArrayList<String>();
            if (command != null && !"".equals(command.trim())) {

                sql.append(" and COMMAND=?");
                paramList.add(command);

            }
            if (description != null && !"".equals(description.trim())) {

                sql.append(" and DESCRIPTION like '%' ? '%'");
                paramList.add(description);

            }

            PreparedStatement statement = conn.prepareStatement(sql.toString());
            for (int i = 0; i < paramList.size(); i++) {
                statement.setString(i + 1, paramList.get(i));
            }
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Message msg = new Message();
                msgList.add(msg);
                msg.setId(rs.getString("ID"));
                msg.setCommand(rs.getString("COMMAND"));
                msg.setDescription(rs.getString("DESCRIPTION"));
                msg.setContent(rs.getString("CONTENT"));
            }

            return msgList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}
