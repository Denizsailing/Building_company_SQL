package org.example.sqlconnection;
import java.sql.Connection;



import java.util.List;

public abstract class AbstractDAO<T> implements GenericDAO<T> {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    // CRUD

    @Override
    public T findById(int id) {

        return null;
    }

    @Override
    public List<T> findAll() {

        return null;
    }

    @Override
    public void save(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {

    }
}
