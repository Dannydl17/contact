package contactApp.services;

import contactApp.data.models.Phonebook;
import contactApp.data.models.User;
import contactApp.dtos.requests.UserRegistrationRequest;

import java.util.jar.Manifest;

public interface PhonebookService {
    Phonebook createPhoneBook(String name, User user);
    void deleteAll();

    Phonebook saveContact(String firstName, String lastName, String email,
                          String phoneNumber, String name, User user);

    Phonebook findByUserName(String name);
}
