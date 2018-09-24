package ru.solomatnikov.DAO;

import ru.solomatnikov.exception.DBSelectByIdExitsException;
import ru.solomatnikov.exception.DBSelectExitsException;
import ru.solomatnikov.model.Staff.Department;
import ru.solomatnikov.model.Staff.Organization;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizationDAO extends AbstractDAO<Organization, Long, PreparedStatement > {

    private static OrganizationDAO instance;

    OrganizationDAO(){}

    public static OrganizationDAO getInstance() {
        if (instance == null){
            instance = new OrganizationDAO();
        }
        return instance;
    }

    private static final String SELECT_ALL_ORGANIZATIONS = "SELECT * FROM Organizations";
    private static final String UPDATE_ORGANIZATION = "UPDATE Organizations SET ID = ? FULLNAME = ?, SHORTNAME = ?, " +
            "MANAGER = ?, CALLPHONE = ?";
    private static final String DELETE_ORGANIZATION = "DELETE FROM Organizations WHERE ID =";
    private static final String CREATE_ORGANIZATION = "INSERT INTO Organizations (ID, FULLNAME, SHORTNAME, MANAGER, CALLPHONE)" +
            " VALUES (?, ?, ?, ?, ?)";

    /**
     * Метод, получающий SQL код для обновления записи
     * @return SQL обновления записи
     */
    @Override
    protected String getUpdateSQL() {
        return UPDATE_ORGANIZATION;
    }

    /**
     * Метод, получающий SQL код для удаления записи
     * @return SQL удаления записи
     */
    @Override
    protected String getDeleteSQL() {
        return DELETE_ORGANIZATION;
    }

    /**
     * Метод, получающий SQL код для создания записи
     * @return SQL создания записи
     */
    @Override
    protected String getCreateSQL() {
        return CREATE_ORGANIZATION;
    }

    /**
     * Метод, получающий SQL код для чтения записей
     * @return SQL чтения записей
     */
    @Override
    protected String getSelectSQL() {
        return SELECT_ALL_ORGANIZATIONS;
    }

    /**
     * Метод распределяющий параметры запроса
     * @param prepareStatement Подключение запроса
     * @param entity Объект
     * @throws SQLException Исключение на случай ошибки с подключением
     */
    @Override
    protected void getSetData(PreparedStatement prepareStatement, Organization entity) throws SQLException {
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
    protected Organization getParsData(List<Organization> objectList, ResultSet resultSet) throws SQLException {
        Organization organization = new Organization();
        organization.setId(resultSet.getLong(1));
        organization.setFullName(resultSet.getString(2));
        organization.setShortName(resultSet.getString(3));
        organization.setManager(resultSet.getString(4));
        organization.setCallPhone(resultSet.getString(5));
        return organization;
    }
}
