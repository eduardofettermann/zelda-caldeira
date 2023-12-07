//package com.github.zeldacaldeira.service;
//import com.github.zeldaservice.model.Jogo;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//class ZeldaServiceTest {
//    @Autowired
//    private ZeldaService service;
//
//    @Test
//    void deveRetornarJogoPorId() {
//        // Arrange
//        Jogo jogo = new Jogo("The Legend of Zelda", "The Legend of Zelda is the first installment of the Zelda " +
//                "series. It centers its plot around a boy named Link, who becomes the central protagonist throughout the series. It came " +
//                "out as early as 1986 for the Famicom in Japan, and was later released in the western world, including Europe and the US in " +
//                "1987. It has since then been re-released several times, for the Nintendo GameCube as well as the Game Boy Advance. " +
//                "The Japanese version of the game on the Famicom is known as The Hyrule Fantasy: The Legend of Zelda. ", "Nintendo R&D 4", "Nintendo", " February 21, 1986", "5f6ce9d805615a85623ec2b7");
//
//        // Act
//        Jogo response = service.getJogoById(jogo.getId()).get();
//
//
//        // Assert
//        assertEquals(response.getNome(), jogo.getNome());
//        assertEquals(response.getDescricao(), jogo.getDescricao());
//        assertEquals(response.getDesenvolvedor(), jogo.getDesenvolvedor());
//        assertEquals(response.getEditor(), jogo.getEditor());
//        assertEquals(response.getDataDeLancamento(), jogo.getDataDeLancamento());
//        assertEquals(response.getId(), jogo.getId());
//    }
//
//    @Test
//    void deveRetornarTodosJogos() {
//        // Assert
//        assertTrue(service.getTodosJogosResponse().isSucesso());
//    }
//}
