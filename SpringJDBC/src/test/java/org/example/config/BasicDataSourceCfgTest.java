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

import static org.junit.jupiter.api.Assertions.*;

class BasicDataSourceCfgTest {
    private final static Logger logger = LoggerFactory.getLogger(BasicDataSourceCfgTest.class);


    @Test
    public void testBasicDataSource() throws SQLException {
        logger.info("testBasicDataSource");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BasicDataSourceCfg.class);
        DataSource dataSource = ctx.getBean("getBasicDataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
    }

    private void testDataSource(DataSource dataSource) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select 1");
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int mockVal = resultSet.getInt(1);
                assertEquals(1, mockVal);
            }

        } catch (SQLException e) {
            logger.error("Something went wrong", e);
        }
    }

}