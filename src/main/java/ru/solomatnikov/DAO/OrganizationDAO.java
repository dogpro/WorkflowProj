package ru.solomatnikov.DAO;

import ru.solomatnikov.exception.DBCreateExitsException;
import ru.solomatnikov.exception.DBDeleteExitsException;
import ru.solomatnikov.exception.DBUpdateExitsException;
import ru.solomatnikov.model.Staff.Organization;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizationDAO extends DataBaseController<Organization, Long > {

    private static final String SELECT_ALL_ORGANIZATIONS = "SELECT * FROM Organizations";
    private static final String UPDATE_ORGANIZATION = "UPDATE Organizations SET FULLNAME = ?, SHORTNAME = ?, " +
            "MANAGER = ?, CALLPHONE = ?";
    private static final String DELETE_ORGANIZATION = "DELETE FROM Organizations WHERE id =";
    private static final String CREATE_ORGANIZATION = "INSERT INTO Organizations (FULLNAME, SHORTNAME, MANAGER, CALLPHONE)" +
            " VALUES (?, ?, ?, ?)";

    /**
     * Метод получения весех записей таблицы Organizations
     * @return Данные из таблицы
     */
    @Override
    protected List<Organization> getAll() {
        List<Organization> organizationList = new ArrayList<>();
        try (PreparedStatement prepareStatement = getPrepareStatement(SELECT_ALL_ORGANIZATIONS)) {
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                Organization organization = new Organization();
                organization.setId(resultSet.getLong(1));
                organization.setFullName(resultSet.getString(2));
                organizationList.add(organization);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return organizationList;
    }

    /**
     * Метод обновления запии в таблице
     * @param entity Обновляемый обьект
     * @throws DBUpdateExitsException Иключение на случай ошибки с обновлением
     */
    @Override
    protected void update(Organization entity) throws DBUpdateExitsException {
        try (PreparedStatement prepareStatement = getPrepareStatement(UPDATE_ORGANIZATION)) {
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
    protected void create(Organization entity) throws DBCreateExitsException {
        try (PreparedStatement prepareStatement = getPrepareStatement(CREATE_ORGANIZATION)) {
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
        try (PreparedStatement prepareStatement = getPrepareStatement(DELETE_ORGANIZATION + id)) {
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
    void setData(PreparedStatement prepareStatement, Organization entity) throws SQLException {
        prepareStatement.setString(1, entity.getFullName());
        prepareStatement.setString(2, entity.getShortName());
        prepareStatement.setString(3, entity.getManager());
        prepareStatement.setString(4, entity.getCallPhone());
    }
}
