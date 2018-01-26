package com.ai.service;

import com.ai.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护相关业务功能
 */
public class MaintainService {

    /**
     * 单条删除
     */
    public void delete(String id) {
        if (id != null && !"".equals(id.trim())) {
            MessageDao dao = new MessageDao();
            dao.deleteOne(Integer.parseInt(id));
        }
    }

    /**
     * 多条删除
     */
    public void deleteBatch(String[] ids) {
        MessageDao dao = new MessageDao();
        List<Integer> idList = new ArrayList<Integer>();
        for (String id : ids) {
            idList.add(Integer.valueOf(id));
        }
        dao.deleteBatch(idList);
    }

}
