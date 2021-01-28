package com.example.backend.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.Properties;

public class DefaultDatabasePresenter implements DatabasePresenter{

    Connection connection = null;

    @Override
    public void create_user(String userId, String password) {
        final String sqlCreateUser = "insert into user(userId, password) values(:userId, :password)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("password", password);
    }

    @Override
    public void create_database() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "pmgd", "pmgd");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE users");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
