package ru.solomatnikov.DAO;

import ru.solomatnikov.exception.DBSelectByIdExitsException;
import ru.solomatnikov.exception.DBSelectExitsException;
import ru.solomatnikov.model.Staff.Department;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends AbstractDAO<Department, Long, PreparedStatement> {

    private static DepartmentDAO instance;

    DepartmentDAO(){}

    public static DepartmentDAO getInstance() {
        if (instance == null){
            instance = new DepartmentDAO();
        }
        return instance;
    }

    private static final String SELECT_ALL_DEPARTMENST = "SELECT * FROM Departments";
    private static final String UPDATE_DEPARTMENT = "UPDATE Departments SET ID = ?, FULLNAME = ?, SHORTNAME = ?, " +
            "MANAGER = ?, CALLPHONE = ?";
    private static final String DELETE_DEPARTMENT = "DELETE FROM Departments WHERE ID =";
    private static final String CREATE_DEPARTMENT = "INSERT INTO Departments (ID, FULLNAME, SHORTNAME, MANAGER, CALLPHONE)" +
            " VALUES (?, ?, ?, ?, ?)";

    /**
     * Метод, получающий SQL код для обновления записи
     * @return SQL обновления записи
     */
    @Override
    protected String getUpdateSQL() {
        return UPDATE_DEPARTMENT;
    }

    /**
     * Метод, получающий SQL код для удаления записи
     * @return SQL удаления записи
     */
    @Override
    protected String getDeleteSQL() {
        return DELETE_DEPARTMENT;
    }

    /**
     * Метод, получающий SQL код для создания записи
     * @return SQL создания записи
     */
    @Override
    protected String getCreateSQL() {
        return CREATE_DEPARTMENT;
    }

    /**
     * Метод, получающий SQL код для чтения записей
     * @return SQL чтения записей
     */
    @Override
    protected String getSelectSQL() {
        return SELECT_ALL_DEPARTMENST;
    }

    /**
     * Метод распределяющий параметры запроса
     * @param prepareStatement Подключение запроса
     * @param entity Объект
     * @throws SQLException Исключение на случай ошибки с подключением
     */
    @Override
    protected void getSetData(PreparedStatement prepareStatement, Department entity) throws SQLException {
        prepareStatement.setLong(1,entity.getId());
        prepareStatement.setString(2, entity.getFullName());
        prepareStatement.setString(3, entity.getShortName());
        prepareStatement.setString(4, entity.getManager());
        prepareStatement.setString(5, entity.getCallPhone());
    }

    /**
     * Метод для создания объекта по результату запроса
     * @param objectList Лист объектов
     * @param resultSet Результат выполнения запроса
     * @return Объект
     * @throws SQLException Исключение на случай ошибки в выполнении запроса
     */
    @Override
    protected Department getParsData(List<Department> objectList, ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getLong(1));
        department.setFullName(resultSet.getString(2));
        department.setShortName(resultSet.getString(3));
        department.setManager(resultSet.getString(4));
        department.setCallPhone(resultSet.getString(5));
        return department;
    }
}
