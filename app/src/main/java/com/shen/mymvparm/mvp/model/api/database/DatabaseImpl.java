package com.shen.mymvparm.mvp.model.api.database;


import com.shen.mymvparm.mvp.model.entity.Doc;
import com.shen.mymvparm.mvp.model.entity.DocDao;

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
        return mDocDao.insert(doc);
    }

    @Override
    public void delDoc(long id) {
         mDocDao.deleteByKey(id);
    }

    @Override
    public void updateDoc(Doc doc) {
        mDocDao.update(doc);
    }

    @Override
    public ArrayList<Doc> queryDocs(int u_id) {
        return (ArrayList<Doc>) mDocDao.queryBuilder().where(DocDao.Properties.Uid.eq
                (u_id)).orderDesc(DocDao.Properties.Create).build().list();
    }

    @Override
    public Doc queryDoc(int id) {
        return mDocDao.queryBuilder().where(DocDao.Properties.Id.eq
                (id)).build().unique();
    }
}
