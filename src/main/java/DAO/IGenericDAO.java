package DAO;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable> {
    T findOne(final Integer id);

    List<T> findAll();

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final Integer entityId);

}
