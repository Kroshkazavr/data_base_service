package dataBase;

import searchService.Result;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class dBDAO implements AutoCloseable {

    private static final String GET_RESULT_BY_ID_TEMPLATE = "select * from dbwithsearchresult where id = ?";
    private static final String INSERT_INTO_DB_TEMPLATE = "insert into dbwithsearchresult(id, code, number, filenames, error) values (seq_dbresult.nextval, ?, ?, ?)";
    private Connection connection;

    public dBDAO() throws IOException, SQLException {
//        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        properties.load(new FileReader("jdbc.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String pass = properties.getProperty("pass");
        this.connection = DriverManager.getConnection(url, user, pass);
    }


    public Result getResultByNumber (int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(GET_RESULT_BY_ID_TEMPLATE)) {
            statement.setInt(1, id);
            try (ResultSet r = statement.executeQuery()) {
                if (r.next()) {
                    Result result = new Result();
                    result.setCode(r.getString("code"));
                    result.setError(r.getString("error"));
                    result.setFileNames(r.getString("filenames"));
                    return result;
                }
            }
        }
        return null;
    }

    public int saveResult(Result result, int number) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement(INSERT_INTO_DB_TEMPLATE)) {
            statement.setString(1, result.getCode());
            statement.setInt(2, number);
            statement.setString(3, result.getFileNames().toString());
            statement.setString(4, result.getError());
            return statement.executeUpdate();
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
