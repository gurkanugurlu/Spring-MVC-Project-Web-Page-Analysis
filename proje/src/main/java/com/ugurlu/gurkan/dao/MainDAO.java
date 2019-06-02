package com.ugurlu.gurkan.dao;

import com.ugurlu.gurkan.analysis.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class    MainDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public Object loadObject(Class c, Serializable id) {
        return getCurrentSession().get(c, id);
    }
    public boolean saveOrUpdateObject(Object object) {
        getCurrentSession().save(object);
        return true;
    }
    public boolean removeObject(Object object) {
        getCurrentSession().remove(object);
        return true;
    }
    public List<Admin> loadAdmin() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Admin> criteriaQuery = criteriaBuilder.createQuery(Admin.class);
        Root<Admin> root = criteriaQuery.from(Admin.class);
        Query<Admin> query = getCurrentSession().createQuery(criteriaQuery);
        return query.getResultList();
    }
    public List<WebUser> loadUsers() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<WebUser> criteriaQuery = criteriaBuilder.createQuery(WebUser.class);
        Root<WebUser> root = criteriaQuery.from(WebUser.class);
        criteriaQuery.select(root);
        Query<WebUser> query = getCurrentSession().createQuery(criteriaQuery);
        return query.getResultList();
    }
    public List<BrowserDetails> loadBrowsers() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<BrowserDetails> criteriaQuery = criteriaBuilder.createQuery(BrowserDetails.class);
        Root<BrowserDetails> root = criteriaQuery.from(BrowserDetails.class);
        criteriaQuery.select(root);
        Query<BrowserDetails> query = getCurrentSession().createQuery(criteriaQuery);
        return query.getResultList();
    }
    public Map<String,Integer> loadOsName(){
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<OSDetails> criteriaQuery = criteriaBuilder.createQuery(OSDetails.class);
        Root<OSDetails> root = criteriaQuery.from(OSDetails.class);
        criteriaQuery.select(root);
        Query<OSDetails> query = getCurrentSession().createQuery(criteriaQuery);
        List<OSDetails> osDetails=query.getResultList();
        Map<String,Integer> keyValues=new HashMap<>();
        for(OSDetails os:osDetails){
            if(keyValues.containsKey(os.getName())){
                Integer oldValue=keyValues.get(os.getName());
                Integer newValue=oldValue+1;
                keyValues.replace(os.getName(),oldValue,newValue);
            }
            else{
                keyValues.put(os.getName(),1);
            }
        }
        return keyValues;
    }
    public List<WebPage> loadWebPages() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<WebPage> criteriaQuery = criteriaBuilder.createQuery(WebPage.class);
        Root<WebPage> root = criteriaQuery.from(WebPage.class);
        criteriaQuery.select(root);
        Query<WebPage> query = getCurrentSession().createQuery(criteriaQuery);
        return query.getResultList();
    }

    }

