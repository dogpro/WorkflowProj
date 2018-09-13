package ru.solomatnikov.DAO;

import ru.solomatnikov.exception.DBCreateExitsException;
import ru.solomatnikov.exception.DBDeleteExitsException;
import ru.solomatnikov.exception.DBSelectByIdExitsException;
import ru.solomatnikov.exception.DBSelectExitsException;
import ru.solomatnikov.exception.DBUpdateExitsException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

abstract class AbstractDAO<E, K, P> {
    private static String url = "jdbc:derby:ecmDB;create=true";

    protected abstract String getUpdateSQL();
    protected abstract String getDeleteSQL();
    protected abstract String getCreateSQL();
    protected abstract String getSelectSQL();
    protected abstract String getSelectByIDSQL();

    protected abstract void getSetData(P prepareStatement, E entity) throws SQLException;
    protected abstract E getParsData(List<E> objectList, ResultSet resultSet) throws SQLException;

    /**
     * Метод получения весех записей таблицы Staff
     * @return Данные из таблицы
     */
    protected List<E> select() throws DBSelectExitsException{
        return getSelectQuery(getSelectSQL());
    }

    protected List<E> getById(K id) throws DBSelectByIdExitsException, DBSelectExitsException {
        return getSelectQuery(getSelectByIDSQL() + id);
    }

    /**
     * Метод обновления запии в таблице
     * @param entity Обновляемый обьект
     * @throws DBUpdateExitsException Иключение на случай ошибки с обновлением
     */
    protected void update(E entity) throws DBUpdateExitsException{
        try (PreparedStatement prepareStatement = getPrepareStatement(getUpdateSQL())) {
            getSetData((P) prepareStatement, entity);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBUpdateExitsException("Ошибка при обновлении записи");
        }
    }

    /**
     * Метод создания записи в таблице
     * @param entity Создаваемый объект
     * @throws DBCreateExitsException Иключение на случай ошибки с обновлением
     */
    protected void create(E entity) throws DBCreateExitsException{
        try (PreparedStatement prepareStatement = getPrepareStatement(getCreateSQL())) {
            getSetData((P) prepareStatement, entity);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBCreateExitsException("Ошибка при создании записи");
        }
    }

    /**
     * Метод удаления записи из таблицы
     * @param id Уникальный идентификатор
     * @throws DBDeleteExitsException Искулючение на случай ошибки с удалением
     */
    protected void delete(K id) throws DBDeleteExitsException{
        try (PreparedStatement prepareStatement = getPrepareStatement(getDeleteSQL() + id)) {
            prepareStatement.executeQuery();
        } catch (SQLException e) {
            throw new DBDeleteExitsException("Ошибка при удалении записи");
        }
    }

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
    public PreparedStatement getPrepareStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    /**
     * Метод для реализации SELECT запросов
     * @param sql SELECT запрос
     * @return Результат
     * @throws DBSelectExitsException Исключение на случай ошибки в выполнении запроса
     */
    private List<E> getSelectQuery(String sql) throws DBSelectExitsException {
        List<E> objectList = new ArrayList<>();
        try (PreparedStatement prepareStatement = getPrepareStatement(sql)) {
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next())
                objectList.add(getParsData(objectList, resultSet));
        } catch (SQLException e) {
            throw new DBSelectExitsException("Ошибка при проводении операции Select");
        }
        return objectList;
    }
}
