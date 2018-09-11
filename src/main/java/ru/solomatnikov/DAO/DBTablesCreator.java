package ru.solomatnikov.DAO;

import ru.solomatnikov.exception.DBTableЕxistsException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTablesCreator {

    /**
     * Метод, проверяющий наличие таблицы в базе данных
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
     * @throws SQLException Исключение на сучай ошибки подключения
     * @throws DBTableЕxistsException Исключение на сучай ошибки создания таблицы
     */
    public static void createTableDepartments() throws SQLException, DBTableЕxistsException {
        if (isTableExist(DataBaseController.getConnection(), "Departments")) {
            PreparedStatement preparedStatement = DataBaseController.getConnection().prepareStatement("CREATE TABLE Departments" +
                    "(FULLNAME VARCHAR(40)," +
                    "SHORTNAME VARCHAR(40)," +
                    "MANAGER VARCHAR(40)," +
                    "CALLPHONE VARCHAR(40))");

            preparedStatement.execute();
        }
    }

    /**
     * Метод создания таблицы Staff
     * @throws SQLException Исключение на сучай ошибки подключения
     * @throws DBTableЕxistsException Исключение на сучай ошибки создания таблицы
     */
    public static void createTableStaff() throws SQLException, DBTableЕxistsException {
        if (isTableExist(DataBaseController.getConnection(), "Staff")) {
            PreparedStatement preparedStatement = DataBaseController.getConnection().prepareStatement("CREATE TABLE Staff" +
                    "(SURNAME VARCHAR(40)," +
                    "FIRSTNAME VARCHAR(40)," +
                    "PATRONYMIC VARCHAR(40)," +
                    "BIRTHDAY DATE," +
                    "POST VARCHAR(40)," +
                    "PHOTO VARCHAR(40))");

            preparedStatement.execute();
        }
    }

    /**
     * Метод создания таблицы Organizations
     * @throws SQLException Исключение на сучай ошибки подключения
     * @throws DBTableЕxistsException Исключение на сучай ошибки создания таблицы
     */
    public static void createTableOrganizations() throws SQLException, DBTableЕxistsException {
        if (isTableExist(DataBaseController.getConnection(), "Organizations")) {
            PreparedStatement preparedStatement = DataBaseController.getConnection().prepareStatement("CREATE TABLE Organizations" +
                    "(FULLNAME VARCHAR(40)," +
                    "SHORTNAME VARCHAR(40)," +
                    "MANAGER VARCHAR(40)," +
                    "CALLPHONE VARCHAR(40))");

            preparedStatement.execute();
        }
    }
}




