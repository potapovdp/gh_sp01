package org.example.container;

import org.example.config.TestcontainersConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {TestcontainersConfig.class, })
public class JdbcContainerTest {
    private static final Logger logger = LoggerFactory.getLogger(JdbcContainerTest.class);

    @Test
    public void testJdbcContainer() {

    }
}
