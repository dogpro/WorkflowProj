package ru.solomatnikov.service;

import ru.solomatnikov.factory.Config;
import ru.solomatnikov.model.Staff.Person;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseProcessing {
    private static String url = "jdbc:derby:ecmDB;create=true";

    public void main(String[] args) throws IOException {
        try {
            personsTableInsert("Persons");
        } catch (SQLException ex) {
            for (Throwable t : ex)
                t.printStackTrace();
        }
    }


    /**
     * Метод, осуществляющий подключение к базе данных
     * @return Подключение
     * @throws SQLException Исключение на случай ошибки подключения
     */
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    /**
     * Метод, проверяющий наличие таблицы в базе данных
     * @param connection Подключение
     * @return Есть / Нет
     * @throws SQLException Исключение на случай ошибки подключения
     */
    private static boolean isTableExist(Connection connection, String tableName) throws SQLException {
        try (ResultSet tableResultSet = connection.getMetaData().getTables(null,null,
                null, new String[] {tableName})){
            while (tableResultSet.next()) {
                if (tableResultSet.getString("TABLE_NAME").equals(tableName))
                    return true;
            }
            return false;
        }
    }

    /**
     * Метод, проверяющий уникальность пользователей
     * @param personId Добавляемый ID
     * @param connection Подключение
     * @param tableName Имя таблицы
     * @return Есть / Нет
     * @throws SQLException
     */
    private static boolean checkPersonId(Long personId, Connection connection, String tableName) throws SQLException {
        List<Long> listId = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next())
                listId.add(result.getLong("id"));
        }

        for (Long id : listId)
            if (id.equals(personId))
                return true;

        return false;
    }
    /**
     * Метод, который добавляет записи в таблицу
     * @param tableName Имя таблицы
     * @throws SQLException Исключение на случай ошибки подключения
     */
    public void personsTableInsert(String tableName) throws SQLException, IOException {
        try (Connection connection = getConnection()) {

            Config config = new ServerProcessing().getDateBaseFromXML(Person.class);

            List<Long> personIdList = new ArrayList<>();
            PreparedStatement preparedStatement = null;

            for (Person person : config.getPersonList()) {
                preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + "(id, surname, firstName, " +
                        "lastName, post) VALUES (?, ?, ?, ?, ?)");

                if(!checkPersonId(person.getId(), connection, tableName)){
                    preparedStatement.setString(1, person.getId().toString());
                    preparedStatement.setString(2, person.getSurname());
                    preparedStatement.setString(3, person.getFirstName());
                    preparedStatement.setString(4, person.getLastName());
                    preparedStatement.setString(5, person.getPost());
                    preparedStatement.executeUpdate();
                }
            }
            preparedStatement.close();
            personsTableSelect(connection, "Persons");

        }
    }

    /*Statement stat = connection.createStatement();
            stat.executeUpdate("DROP TABLE " + tableName);
            if (!isTableExist(connection, tableName))
            stat.execute("CREATE TABLE " + tableName + "(id BIGINT, surname VARCHAR(50), firstName VARCHAR(50), " +
            "lastName VARCHAR(50), post VARCHAR(50))");

            stat.close();*/

    /**
     * Метод, выполняющий операцию SELECT
     * @param connection Подключение
     * @param tableName Имя таблицы
     * @throws SQLException Исключение на случай ошибки подключения
     */
    public static void personsTableSelect(Connection connection, String tableName ) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next())
                System.out.println( result.getString("id") + "\t" +
                        result.getString("surname") + "\t" +
                        result.getString("firstName") + "\t" +
                        result.getString("lastName") + "\t" +
                        result.getString("post"));
        }
    }
}
