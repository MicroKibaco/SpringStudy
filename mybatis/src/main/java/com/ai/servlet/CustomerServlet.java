package com.ai.servlet;

import com.ai.bean.Message;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerServlet extends HttpServlet {

    // http://localhost:8080/customer

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            String command = req.getParameter("command");
            String description = req.getParameter("description");
            String content = req.getParameter("content");
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
            List<Message> msgList = new ArrayList<Message>();

            while (rs.next()) {
                Message msg = new Message();
                msgList.add(msg);
                msg.setId(rs.getString("ID"));
                msg.setCommand(rs.getString("COMMAND"));
                msg.setDescription(rs.getString("DESCRIPTION"));
                msg.setContent(rs.getString("CONTENT"));
            }
            req.setAttribute("messageList", msgList);
            req.setAttribute("command", command);
            req.setAttribute("description", description);

        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
