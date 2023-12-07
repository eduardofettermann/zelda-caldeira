package com.github.zeldacaldeira.components;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ZeldaWebClientTest {
    @Autowired
    private ZeldaWebClient zeldaWebClient;

    @Test
    void contextLoads() {
        assertNotNull(zeldaWebClient.getWebClient());
    }


}
