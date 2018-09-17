package ru.solomatnikov.DAO;
import ru.solomatnikov.exception.DBCreateExitsException;
import ru.solomatnikov.exception.DBTableЕxistsException;
import ru.solomatnikov.factory.Config;
import ru.solomatnikov.model.Staff.Department;
import ru.solomatnikov.model.Staff.Organization;
import ru.solomatnikov.model.Staff.Person;
import ru.solomatnikov.service.ServerProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        if (isTableExist(AbstractDAO.getConnection(), "Departments")) {
            PreparedStatement preparedStatement = AbstractDAO.getConnection().prepareStatement(getSql("SQL/CreateTableDepartment.sql"));
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
        if (!isTableExist(AbstractDAO.getConnection(), "Staff")) {
            PreparedStatement preparedStatement = AbstractDAO.getConnection().prepareStatement(getSql("SQL/CreateTableStaff.sql"));
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
        if (isTableExist(AbstractDAO.getConnection(), "Organizations")) {
            PreparedStatement preparedStatement = AbstractDAO.getConnection().prepareStatement(getSql("SQL/CreateTableOrganization.sql"));
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
    public static void InsertDataInStaffTable() throws DBCreateExitsException, IOException {

        Config<Person> config = new ServerProcessing().getDataInDBFromXML("Persons.xml");
        for (Person person : config.getAny()) {
            try{
                PersonDAO personDAO = new PersonDAO();
                personDAO.create(person);
            } catch (DBCreateExitsException e) {
                throw new DBCreateExitsException("Ошибка при заполнении таблицы Staff");
            }
        }
    }

    /**
     * Метод для заполнения данными таблицы депортаментов
     * @throws DBCreateExitsException Исключение на сучай ошибки создания таблицы
     * @throws IOException Исключение на сучай ошибки подключения
     */
    private static void InsertDataInDepartmentsTable() throws DBCreateExitsException, IOException {

        Config<Department> config = new ServerProcessing().getDataInDBFromXML("Department.xml");
        for (Department department : config.getAny()) {
            try{
                DepartmentDAO departmentDAO = new DepartmentDAO();
                departmentDAO.create(department);
            } catch (DBCreateExitsException e) {
                throw new DBCreateExitsException("Ошибка при заполнении таблицы Department");
            }
        }
    }

    /**
     * Метод для заполнения данными таблицы организаций
     * @throws DBCreateExitsException Исключение на случай ошибки в создаии документа
     * @throws IOException Исключение на случай ошибки в работе с файлом
     */
    private static void InsertDataInOrganizationsTable() throws DBCreateExitsException, IOException {

        Config<Organization> config = new ServerProcessing().getDataInDBFromXML("Organization.xml");
        for (Organization organization : config.getAny()) {
            try{
                OrganizationDAO organizationDAO = new OrganizationDAO();
                organizationDAO.create(organization);
            } catch (DBCreateExitsException e) {
                throw new DBCreateExitsException("Ошибка при заполнении таблицы Organization");
            }
        }
    }

    private static String getSql(String fileName) throws IOException {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = DBTablesCreator.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader( new InputStreamReader(inputStream));
        while ((str = reader.readLine()) != null) {
            stringBuffer.append(str).append("\n");
        }
        return String.valueOf(stringBuffer);
    }
}





