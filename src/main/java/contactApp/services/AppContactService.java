package contactApp.services;

import contactApp.data.models.Contact;
import contactApp.data.repositories.ContactRepository;
import contactApp.dtos.requests.ContactCreateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppContactService implements ContactService{
    private final ContactRepository contactRepository;

    @Override
    public Contact createContact(ContactCreateRequest request) {
        Contact contact = new Contact();
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhoneNumber(request.getPhoneNumber());
        return contactRepository.save(contact);
    }

    @Override
    public void deleteAll() {
        contactRepository.deleteAll();
    }
}
