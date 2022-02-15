package com.capgemini.ccsw.estimador;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.ccsw.estimador.utils.UtilsService;

@SpringBootTest
public class PruebaTest {

   @Autowired
   UtilsService utilsService;

   @Test
   public void Prueba() {

      System.out.println(utilsService);
      assertThat("?").isEqualTo(utilsService.getVersion());
   }
}
