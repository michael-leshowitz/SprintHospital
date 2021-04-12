package DAO;

import com.example.demo.MainController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@EnableTransactionManagement
@Transactional

public abstract class AbstractHibernateDAO<T extends Serializable> {
    private Class<T> clazz;

    @Qualifier("sessionFactory")
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

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}


