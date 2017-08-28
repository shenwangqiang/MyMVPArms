package com.shen.mymvparm.mvp.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * Created by shenwangqiang on 2017/8/26.
 */
@Entity
public class Doc implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id(autoincrement = true)
    public Long tableId;
    @Property
    private long id;
    @Property
    private String title;
    @Property
    private String content;
    @Property
    private String create;
    @Property
    private String lastModify;
    @Property
    private int uid;
    @Generated(hash = 1802735130)
    public Doc(Long tableId, long id, String title, String content, String create,
            String lastModify, int uid) {
        this.tableId = tableId;
        this.id = id;
        this.title = title;
        this.content = content;
        this.create = create;
        this.lastModify = lastModify;
        this.uid = uid;
    }
    @Generated(hash = 960349246)
    public Doc() {
    }
    public Long getTableId() {
        return this.tableId;
    }
    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getCreate() {
        return this.create;
    }
    public void setCreate(String create) {
        this.create = create;
    }
    public String getLastModify() {
        return this.lastModify;
    }
    public void setLastModify(String lastModify) {
        this.lastModify = lastModify;
    }
    public int getUid() {
        return this.uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }

}
