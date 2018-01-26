package com.ai.servlet;

import com.ai.service.CustomerService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerServlet extends HttpServlet {

    // http://localhost:8080/customer

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // 接受页面的值
        String command = req.getParameter("command");
        String description = req.getParameter("description");


        // 向页面传值
        req.setAttribute("command", command);
        req.setAttribute("description", description);
        CustomerService service = new CustomerService();

        // 查询消息列表并传给页面
        req.setAttribute("messageList", service.queryMessageList(command, description));
        // 消息页面跳转
        req.getRequestDispatcher("/WEB-INF/view/back/customer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
