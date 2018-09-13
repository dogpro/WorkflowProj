package ru.solomatnikov.DAO;

import ru.solomatnikov.model.Staff.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDAO extends AbstractDAO<Person, Long, PreparedStatement> {
    private static final String SELECT_ALL_USERS = "SELECT * FROM Staff";
    private static final String UPDATE_USER = "UPDATE Staff SET SURNAME = ?, FIRSTNAME = ?, " +
            "PATRONYMIC = ?, BIRTHDAY = ?, POST = ?, PHOTO = ?";
    private static final String DELETE_USER = "DELETE FROM Staff WHERE id =";
    private static final String CREATE_USER = "INSERT INTO Staff( SURNAME, FIRSTNAME, " +
            "PATRONYMIC, BIRTHDAY, POST, PHOTO) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT * FROM Staff WHERE id =";

    /**
     * Метод, получающий SQL код для обновления записи
     * @return SQL обновления записи
     */
    @Override
    protected String getUpdateSQL() {
        return UPDATE_USER;
    }

    /**
     * Метод, получающий SQL код для удаления записи
     * @return SQL удаления записи
     */
    @Override
    protected String getDeleteSQL() {
        return DELETE_USER;
    }

    /**
     * Метод, получающий SQL код для создания записи
     * @return SQL создания записи
     */
    @Override
    protected String getCreateSQL() {
        return CREATE_USER;
    }

    /**
     * Метод, получающий SQL код для чтения записей
     * @return SQL чтения записей
     */
    @Override
    protected String getSelectSQL() {
        return SELECT_ALL_USERS;
    }

    /**
     * Метод, получающий SQL код для чтения записей по ID
     * @return SQL чтения записей по ID
     */
    @Override
    protected String getSelectByIDSQL() {
        return SELECT_BY_ID;
    }

    /**
     * Метод распределяющий параметры запроса
     * @param prepareStatement Подключение запроса
     * @param entity Объект
     * @throws SQLException Исключение на случай ошибки с подключением
     */
    @Override
    protected void getSetData(PreparedStatement prepareStatement, Person entity) throws SQLException {
        prepareStatement.setString(1, entity.getSurname());
        prepareStatement.setString(2, entity.getFirstName());
        prepareStatement.setString(3, entity.getLastName());
        prepareStatement.setString(4, entity.getBirthday());
        prepareStatement.setString(5, entity.getPost());
        prepareStatement.setString(6, entity.getPhoto());
    }

    /**
     * Метод для создания объекта по результату запроса
     * @param objectList Лист объектов
     * @param resultSet Результат выполнения запроса
     * @return Объект
     * @throws SQLException Исключение на случай ошибки в выполнении запроса
     */
    @Override
    protected Person getParsData(List<Person> objectList, ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getLong(1));
        person.setSurname(resultSet.getString(2));
        person.setFirstName(resultSet.getString(3));
        person.setLastName(resultSet.getString(4));
        person.setBirthday(resultSet.getString(5));
        person.setPost(resultSet.getString(6));
        person.setPhoto(resultSet.getString(7));
        return person;
    }


}

