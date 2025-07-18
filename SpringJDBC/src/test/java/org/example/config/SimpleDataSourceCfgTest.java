package org.example.config;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class SimpleDataSourceCfgTest {
    private static final Logger logger = LoggerFactory.getLogger(SimpleDataSourceCfgTest.class);

    @Test
    public void testSimpleDataSource() throws SQLException {
        logger.info("testSimpleDataSource");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleDataSourceCfg.class);
        DataSource dataSource = ctx.getBean(DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
    }

    private void testDataSource(DataSource dataSource) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select 1");
             ResultSet resultSet = statement.executeQuery()){
                 while (resultSet.next()) {
                     int mockVal = resultSet.getInt(1);
                     assertEquals(1, mockVal);
                 }
        } catch (SQLException e) {
            logger.error("Something went wrong", e);
        }
    }
}