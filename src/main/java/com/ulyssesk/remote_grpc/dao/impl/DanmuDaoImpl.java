package com.ulyssesk.remote_grpc.dao.impl;

import com.ulyssesk.remote_grpc.dao.DanmuDao;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.ulyssesk.remote_grpc.pojo.DanmuEntity;

import java.io.Serializable;
import java.util.List;

public class DanmuDaoImpl implements DanmuDao {
    protected MongoTemplate mongoTemplate;


    public void save(DanmuEntity entity) {
        mongoTemplate.save(entity);
    }

    public void update(DanmuEntity entity) {

    }

    public void delete(Serializable... ids) {

    }

    public DanmuEntity find(Serializable id) {
        return null;
    }

    public List<DanmuEntity> findAll() {
        return null;
    }

    public List<DanmuEntity> findAll(String order) {
        return null;
    }

    public List<DanmuEntity> findByProp(String propName, Object value) {
        return null;
    }

    public List<DanmuEntity> findByProp(String propName, Object value, String order) {
        return null;
    }

    public List<DanmuEntity> findByProps(String[] propName, Object[] values) {
        return null;
    }

    public List<DanmuEntity> findByProps(String[] propName, Object[] values, String order) {
        return null;
    }

    public DanmuEntity uniqueByProp(String propName, Object value) {
        return null;
    }

    public DanmuEntity uniqueByProps(String[] propName, Object[] values) {
        return null;
    }

    public int countByCondition(String[] params, Object[] values) {
        return 0;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
