package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDAO<T extends Serializable> {
    private Class<T> clazz;

    @Autowired
    SessionFactory sessionFactory;

    public AbstractHibernateDAO() {
    }

    public void setClazz(Class< T > clazzToSet){
        this.clazz = clazzToSet;
    }

    public T findOne(Integer id){
        return (T) getCurrentSession().get(clazz, id);
    }

    public List findAll(){
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    public T create(T entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public T update(T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(Integer entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}