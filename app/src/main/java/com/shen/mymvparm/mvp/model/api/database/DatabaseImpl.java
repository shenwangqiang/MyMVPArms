package com.shen.mymvparm.mvp.model.api.database;


import com.shen.mymvparm.mvp.model.entity.Doc;
import com.shen.mymvparm.mvp.model.entity.DocDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;

/**
 * IDatabase的实现
 *
 * @author swq
 */
public class DatabaseImpl implements IDatabase {
    private DocDao mDocDao = GreenDaoHelper.getDaoSession().getDocDao();

    @Override
    public long insertDoc(Doc doc) {
        return 0;
    }

    @Override
    public void delDoc(long id) {

    }

    @Override
    public void updateDoc(Doc doc) {

    }

    @Override
    public ArrayList<Doc> queryDocs(int u_id) {
        return (ArrayList<Doc>) mDocDao.queryBuilder().where(DocDao.Properties.Uid.eq
                (u_id)).orderDesc(DocDao.Properties.Create).build().list();
    }

    @Override
    public Doc queryDoc(int id) {
        return null;
    }
}
