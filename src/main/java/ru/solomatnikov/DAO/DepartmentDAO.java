package ru.solomatnikov.DAO;

import ru.solomatnikov.exception.DBCreateExitsException;
import ru.solomatnikov.exception.DBDeleteExitsException;
import ru.solomatnikov.exception.DBUpdateExitsException;
import ru.solomatnikov.model.Staff.Department;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends DataBaseController<Department, Long> {

    private static final String SELECT_ALL_DEPARTMENST = "SELECT * FROM Departments";
    private static final String UPDATE_DEPARTMENT = "UPDATE Departments SET FULLNAME = ?, SHORTNAME = ?, " +
            "MANAGER = ?, CALLPHONE = ?";
    private static final String DELETE_DEPARTMENT = "DELETE FROM Departments WHERE id =";
    private static final String CREATE_DEPARTMENT = "INSERT INTO Departments (FULLNAME, SHORTNAME, MANAGER, CALLPHONE)" +
            " VALUES (?, ?, ?, ?)";

    /**
     * Метод получения всех записей таблицы Departments
     * @return Данные из таблицы
     */
    @Override
    protected List<Department> getAll() {
        List<Department> departmentList = new ArrayList<>();
        try (PreparedStatement prepareStatement = getPrepareStatement(SELECT_ALL_DEPARTMENST)) {
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getLong(1));
                department.setFullName(resultSet.getString(2));
                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentList;
    }

    /**
     * Метод обновления запии в таблице
     * @param entity Обновляемый обьект
     * @throws DBUpdateExitsException Иключение на случай ошибки с обновлением
     */
    @Override
    protected void update(Department entity) throws DBUpdateExitsException {
        try (PreparedStatement prepareStatement = getPrepareStatement(UPDATE_DEPARTMENT)) {
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
    protected void create(Department entity) throws DBCreateExitsException {
        try (PreparedStatement prepareStatement = getPrepareStatement(CREATE_DEPARTMENT)) {
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
        try (PreparedStatement prepareStatement = getPrepareStatement(DELETE_DEPARTMENT + id)) {
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
    void setData(PreparedStatement prepareStatement, Department entity) throws SQLException {
        prepareStatement.setString(1, entity.getFullName());
        prepareStatement.setString(2, entity.getShortName());
        prepareStatement.setString(3, entity.getManager());
        prepareStatement.setString(4, entity.getCallPhone());
    }
}
