package com.ai.servlet;

import com.ai.service.MaintainService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 批量删除控制层
 */
public class DeleteBatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // 接受页面的值
        String[] ids = req.getParameterValues("id");

        MaintainService service = new MaintainService();
        service.deleteBatch(ids);
        // 消息页面跳转
        req.getRequestDispatcher("/customer").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
