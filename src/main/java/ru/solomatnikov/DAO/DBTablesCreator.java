package ru.solomatnikov.DAO;

import ru.solomatnikov.exception.DBCreateExitsException;
import ru.solomatnikov.exception.DBTableЕxistsException;
import ru.solomatnikov.factory.Config;
import ru.solomatnikov.model.Staff.Department;
import ru.solomatnikov.model.Staff.Organization;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.service.ServerProcessing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTablesCreator {

    /**
     * Метод, проверяющий наличие таблицы в базе данных
     *
     * @param connection Подключение
     * @return Есть / Нет
     * @throws SQLException Исключение на случай ошибки подключения
     */
    private static boolean isTableExist(Connection connection, String tableName) throws DBTableЕxistsException {
        try (ResultSet tableResultSet = connection.getMetaData().getTables(null, null,
                null, new String[]{tableName})) {
            while (tableResultSet.next()) {
                if (tableResultSet.getString("TABLE_NAME").equals(tableName))
                    return true;
            }
        } catch (SQLException e) {
            throw new DBTableЕxistsException("Ошибка подключения к таблице");
        }
        return false;
    }

    /**
     * Метод создания таблицы Departments
     *
     * @throws SQLException           Исключение на сучай ошибки подключения
     * @throws DBTableЕxistsException Исключение на сучай ошибки создания таблицы
     */
    public static void createTableDepartments() throws SQLException, DBTableЕxistsException, DBCreateExitsException, IOException {
        if (isTableExist(DataBaseController.getConnection(), "Departments")) {
            PreparedStatement preparedStatement = DataBaseController.getConnection().prepareStatement("CREATE TABLE Departments" +
                    "(FULLNAME VARCHAR(40)," +
                    "SHORTNAME VARCHAR(40)," +
                    "MANAGER VARCHAR(40)," +
                    "CALLPHONE VARCHAR(40))");

            preparedStatement.execute();

            InsertDataInDepartmentsTable();
        }
    }

    /**
     * Метод создания таблицы Staff
     *
     * @throws SQLException           Исключение на сучай ошибки подключения
     * @throws DBTableЕxistsException Исключение на сучай ошибки создания таблицы
     */
    public static void createTableStaff() throws SQLException, DBTableЕxistsException, IOException, DBCreateExitsException {
        if (isTableExist(DataBaseController.getConnection(), "Staff")) {
            PreparedStatement preparedStatement = DataBaseController.getConnection().prepareStatement("CREATE TABLE Staff" +
                    "(SURNAME VARCHAR(40)," +
                    "FIRSTNAME VARCHAR(40)," +
                    "PATRONYMIC VARCHAR(40)," +
                    "BIRTHDAY VARCHAR(40)," +
                    "POST VARCHAR(40)," +
                    "PHOTO VARCHAR(40))");

            preparedStatement.execute();
            InsertDataInStaffTable();
        }
    }

    /**
     * Метод создания таблицы Organizations
     *
     * @throws SQLException           Исключение на сучай ошибки подключения
     * @throws DBTableЕxistsException Исключение на сучай ошибки создания таблицы
     */
    public static void createTableOrganizations() throws SQLException, DBTableЕxistsException, DBCreateExitsException, IOException {
        if (isTableExist(DataBaseController.getConnection(), "Organizations")) {
            PreparedStatement preparedStatement = DataBaseController.getConnection().prepareStatement("CREATE TABLE Organizations" +
                    "(FULLNAME VARCHAR(40)," +
                    "SHORTNAME VARCHAR(40)," +
                    "MANAGER VARCHAR(40)," +
                    "CALLPHONE VARCHAR(40))");

            preparedStatement.execute();
            InsertDataInOrganizationsTable();
        }
    }

    /**
     * Метод, заполяющий таблицу Staff
     *
     * @throws DBCreateExitsException Исключение на сучай ошибки создания таблицы
     * @throws IOException            Исключение на сучай ошибки подключения
     */
    private static void InsertDataInStaffTable() throws DBCreateExitsException, IOException {
        String sql = "INSERT INTO Staff( SURNAME, " +
                "FIRSTNAME,PATRONYMIC, BIRTHDAY, POST, PHOTO) VALUES (?, ?, ?, ?, ?, ?)";

        Config<Person> config = new ServerProcessing().getDataInDBFromXML("Persons.xml");
        for (Person person : config.getAny()) {

            try (PreparedStatement prepareStatement = DataBaseController.getConnection().prepareStatement(sql)) {
                prepareStatement.setString(1, person.getId().toString());
                prepareStatement.setString(2, person.getSurname());
                prepareStatement.setString(3, person.getFirstName());
                prepareStatement.setString(4, person.getLastName());
                prepareStatement.setString(5, person.getPost());
                prepareStatement.executeUpdate();

                prepareStatement.executeUpdate();
            } catch (SQLException e) {
                throw new DBCreateExitsException("Ошибка при заполнении таблицы Staff");
            }
        }
    }

    private static void InsertDataInDepartmentsTable() throws DBCreateExitsException, IOException {
        String sql = "INSERT INTO Departments (FULLNAME, SHORTNAME, MANAGER, CALLPHONE)" +
                " VALUES (?, ?, ?, ?)";

        Config<Department> config = new ServerProcessing().getDataInDBFromXML("Department.xml");
        for (Department department : config.getAny()) {
            try (PreparedStatement prepareStatement = DataBaseController.getConnection().prepareStatement(sql)) {
                prepareStatement.setString(1, department.getFullName());
                prepareStatement.setString(2, department.getShortName());
                prepareStatement.setString(3, department.getManager());
                prepareStatement.setString(4, department.getCallPhone());

                prepareStatement.executeUpdate();
            } catch (SQLException e) {
                throw new DBCreateExitsException("Ошибка при заполнении таблицы Department");
            }
        }
    }

    private static void InsertDataInOrganizationsTable() throws DBCreateExitsException, IOException {
        String sql = "INSERT INTO Organizations (FULLNAME, SHORTNAME, MANAGER, CALLPHONE)" +
                " VALUES (?, ?, ?, ?)";

        Config<Organization> config = new ServerProcessing().getDataInDBFromXML("Organization.xml");
        for (Organization organization : config.getAny()) {
            try (PreparedStatement prepareStatement = DataBaseController.getConnection().prepareStatement(sql)) {
                prepareStatement.setString(1, organization.getFullName());
                prepareStatement.setString(2, organization.getShortName());
                prepareStatement.setString(3, organization.getManager());
                prepareStatement.setString(4, organization.getCallPhone());

                prepareStatement.executeUpdate();
            } catch (SQLException e) {
                throw new DBCreateExitsException("Ошибка при заполнении таблицы Organization");
            }
        }
    }
}





