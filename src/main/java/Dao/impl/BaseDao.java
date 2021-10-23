package Dao.impl;

import Dao.IBaseDao;
import Util.JPAUtilpwb;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class BaseDao<T> implements IBaseDao<T> {

    private Class<T> clz;
    public BaseDao() {
        ParameterizedType parametclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parametclass.getActualTypeArguments();
        clz = (Class<T>) actualTypeArguments[0];
    }



    @Override
    public void save(Object s) {
        EntityManager manager = JPAUtilpwb.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void update(Object s) {
        EntityManager manager = JPAUtilpwb.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(s);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public void delete(Serializable Id) {
        EntityManager manager = JPAUtilpwb.getEntityManager();
        manager.getTransaction().begin();
        T s = manager.find(clz, Id);
        manager.remove(s);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public T getOne(Serializable Id) {
        EntityManager manager = JPAUtilpwb.getEntityManager();
        T s = manager.find(clz, Id);
        return s;
    }

    @Override
    public List getAll() {
        EntityManager manager = JPAUtilpwb.getEntityManager();
        String sql = "select p from "+ clz.getName() +" as p";
        Query query = manager.createQuery(sql);
        return query.getResultList();
    }

}
