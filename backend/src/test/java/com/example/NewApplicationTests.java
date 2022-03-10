package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.nodes.CollectionNode;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class NewApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
void contextLoads() throws SQLException {
        System.out.println((dataSource.getClass()));



        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
