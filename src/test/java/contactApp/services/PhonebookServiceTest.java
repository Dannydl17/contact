package contactApp.services;

import contactApp.data.models.Phonebook;
import contactApp.data.models.User;
import contactApp.dtos.requests.ContactCreateRequest;
import contactApp.dtos.requests.UserRegistrationRequest;
import contactApp.dtos.responses.UserRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PhonebookServiceTest {
     @Autowired
     private AppPhonebookService phonebookService;
     @Autowired
     private AppUserService userService;


     @BeforeEach
     public void startEachTestWith(){
         phonebookService.deleteAll();
     }

     @Test
     public void testThatPhoneBookCanBeCreatedTest(){
          User user = new User();
          Phonebook phonebook = phonebookService.createPhoneBook("Daniel", user);
          assertNotNull(phonebook);
          User user1 = new User();
          Phonebook phonebook1 = phonebookService.createPhoneBook("Danny", user1);
          assertNotNull(phonebook1);
     }

     @Test
     public void testThatContactCanBeSavedOnPhoneBookTest(){
          User user = new User();
          Phonebook phonebook = phonebookService.createPhoneBook("Daniel", user);
          assertNotNull(phonebook);

          ContactCreateRequest request = new ContactCreateRequest();
          request.setFirstName("Ayomide");
          request.setLastName("Adeolu");
          request.setEmail("test@test.com");
          request.setPhoneNumber("080234523456");
          phonebookService.saveContact(request.getFirstName(), request.getLastName(),
                                       request.getEmail(), request.getPhoneNumber(),
                                       "Daniel", user);
          assertEquals(1, phonebookService.findByUserName("Daniel").getContacts().size());
     }
}
