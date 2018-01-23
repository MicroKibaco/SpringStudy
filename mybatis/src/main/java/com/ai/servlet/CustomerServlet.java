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


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?useUnicode=true&amp;characterEncoding=utf-8",
                    "root", "MicroKibaco0813");
            String sql = "SELECT ID,COMMAND,DESCRIPTION,CONTENT FROM MESSAGE";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<Message> msgList = new ArrayList<Message>();

            while (rs.next()) {
                Message msg = new Message("ID", "COMMAND", "DESCRIPTION", "CONTENT");
                msgList.add(msg);
            }
            req.setAttribute("msgList",msgList );

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
