package ru.solomatnikov.DAO;

import ru.solomatnikov.exception.DBCreateExitsException;
import ru.solomatnikov.exception.DBDeleteExitsException;
import ru.solomatnikov.exception.DBUpdateExitsException;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.utils.DateUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends DataBaseController<Person, Long> {
    private static final String SELECT_ALL_USERS = "SELECT * FROM Staff";
    private static final String UPDATE_USER = "UPDATE Staff SET SURNAME = ?, FIRSTNAME = ?, " +
            "PATRONYMIC = ?, BIRTHDAY = ?, POST = ?, PHOTO = ?";
    private static final String DELETE_USER = "DELETE FROM Staff WHERE id =";
    private static final String CREATE_USER = "INSERT INTO Staff( SURNAME, FIRSTNAME, " +
            "PATRONYMIC, BIRTHDAY, POST, PHOTO) VALUES (?, ?, ?, ?, ?, ?)";

    /**
     * Метод получения весех записей таблицы Staff
     * @return Данные из таблицы
     */
    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        try (PreparedStatement prepareStatement = getPrepareStatement(SELECT_ALL_USERS)) {
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getLong(1));
                person.setLastName(resultSet.getString(2));
                personList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personList;
    }

    /**
     * Метод обновления запии в таблице
     * @param entity Обновляемый обьект
     * @throws DBUpdateExitsException Иключение на случай ошибки с обновлением
     */
    @Override
    protected void update(Person entity) throws DBUpdateExitsException {
        try (PreparedStatement prepareStatement = getPrepareStatement(UPDATE_USER)) {
            setData(prepareStatement, entity);
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
    @Override
    protected void create(Person entity) throws DBCreateExitsException {
        try (PreparedStatement prepareStatement = getPrepareStatement(CREATE_USER)) {
            setData(prepareStatement, entity);
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
    @Override
    protected void delete(Long id) throws DBDeleteExitsException {
        try (PreparedStatement prepareStatement = getPrepareStatement(DELETE_USER + id)) {
            prepareStatement.executeQuery();
        } catch (SQLException e) {
            throw new DBDeleteExitsException("Ошибка при удалении записи");
        }
    }

    /**
     * Метод распределяющий параметры запроса
     * @param prepareStatement Подключение запроса
     * @param entity Объект
     * @throws SQLException Исключение на случай ошибки с подключением
     */
    void setData(PreparedStatement prepareStatement, Person entity) throws SQLException {
        prepareStatement.setString(1, entity.getSurname());
        prepareStatement.setString(2, entity.getFirstName());
        prepareStatement.setString(3, entity.getLastName());
        prepareStatement.setString(4, entity.getBirthday());
        prepareStatement.setString(5, entity.getPost());
        prepareStatement.setString(6, entity.getPhoto());
    }
}

