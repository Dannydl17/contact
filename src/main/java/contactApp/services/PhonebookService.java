package contactApp.services;

import contactApp.data.models.Phonebook;
import contactApp.data.models.User;
import contactApp.dtos.requests.UserRegistrationRequest;

public interface PhonebookService {
    Phonebook createPhoneBook(String name, User user);
    void deleteAll();

}
