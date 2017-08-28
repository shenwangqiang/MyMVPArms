package com.shen.mymvparm.mvp.model.api.database;

import com.shen.mymvparm.mvp.model.entity.Doc;

import java.util.ArrayList;

/**
 * 提供数据库相关操作的接口
 *
 * @author swq
 */
public interface IDatabase {

    /**
     * 添加笔记
     *
     * @param doc
     * @return
     */
    long insertDoc(Doc doc);

    /**
     * 删除笔记
     *
     * @param id
     * @return
     */
    void delDoc(long id);

    /**
     * 更新笔记
     *
     * @param doc
     * @return
     */
    void updateDoc(Doc doc);

    /**
     * 查询笔记
     *
     * @param u_id
     * @return
     */
    ArrayList<Doc> queryDocs(int u_id);

    /**
     * 查询笔记
     *
     * @param id
     * @return
     */
    Doc queryDoc(int id);
}
