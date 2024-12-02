package contactApp.services;

import contactApp.data.models.Contact;
import contactApp.data.models.Phonebook;
import contactApp.data.models.User;
import contactApp.data.repositories.PhonebookRepository;
import contactApp.dtos.requests.ContactCreateRequest;
import contactApp.dtos.requests.UserRegistrationRequest;
import contactApp.dtos.responses.UserRegistrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppPhonebookService implements PhonebookService{
    private final PhonebookRepository phonebookRepository;


    @Override
    public Phonebook createPhoneBook(String name, User user) {
        Phonebook phonebook = new Phonebook();
        phonebook.setName(name);
        phonebook.setUser(user);
        phonebookRepository.save(phonebook);
        return phonebook;
    }

    @Override
    public void deleteAll() {
       phonebookRepository.deleteAll();
    }

    @Override
    public Phonebook saveContact(String firstName, String lastName, String email,
                                 String phoneNumber, String name, User user) {
        Phonebook phonebook = phonebookRepository.findByName(name);
        List<Contact> contacts = phonebook.getContacts();
        ContactCreateRequest request = new ContactCreateRequest();
        request.setFirstName(firstName);
        return null;
    }

    @Override
    public Phonebook findByUserName(String name) {
        return null;
    }
}
