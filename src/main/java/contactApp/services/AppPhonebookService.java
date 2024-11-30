package contactApp.services;

import contactApp.data.models.Phonebook;
import contactApp.data.models.User;
import contactApp.data.repositories.PhonebookRepository;
import contactApp.dtos.requests.UserRegistrationRequest;
import contactApp.dtos.responses.UserRegistrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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
}
