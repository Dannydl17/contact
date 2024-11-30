package contactApp.services;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhonebookServiceTest {
     @Autowired
     private AppPhonebookService phonebookService;

     @BeforeEach
     public void startEachTestWith(){
         phonebookService.deleteAll();
     }
}
