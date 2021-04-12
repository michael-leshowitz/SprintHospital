package DAO;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
@EnableTransactionManagement
@Transactional
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernatedDAO<T extends Serializable>
        extends AbstractHibernateDAO<T> implements IGenericDAO<T>{

}
