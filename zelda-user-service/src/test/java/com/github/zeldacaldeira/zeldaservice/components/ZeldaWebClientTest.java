package com.github.zeldacaldeira.zeldaservice.components;

import com.github.zeldacaldeira.components.ZeldaWebClient;
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
