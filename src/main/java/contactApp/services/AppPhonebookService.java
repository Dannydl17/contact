package contactApp.services;

import contactApp.data.repositories.PhonebookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class AppPhonebookService implements PhonebookService{
    private final PhonebookRepository phonebookRepository;


    @Override
    public void deleteAll() {
       phonebookRepository.deleteAll();
    }
}
