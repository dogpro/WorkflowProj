package ru.solomatnikov.DAO;

import ru.solomatnikov.exception.DBCreateExitsException;
import ru.solomatnikov.exception.DBDeleteExitsException;
import ru.solomatnikov.exception.DBUpdateExitsException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

abstract class DataBaseController<E, K> {
    private static String url = "jdbc:derby:ecmDB;create=true";

    protected abstract List<E> getAll();
    protected abstract void update(E entity) throws DBUpdateExitsException;
    protected abstract void create(E entity) throws DBCreateExitsException;
    protected abstract void delete(K id) throws DBDeleteExitsException;

    /**
     * Метод, осуществляющий подключение к базе данных
     * @return Подключение
     * @throws SQLException Исключение на случай ошибки подключения
     */
    protected static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    /**
     * Метод, с помощью которого происходит выполнение SQL операции
     * @param sql SQL код операции
     * @return объект подключения
     */
    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

}
