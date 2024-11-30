package contactApp.services;

import contactApp.data.models.Contact;
import contactApp.dtos.requests.ContactCreateRequest;

public interface ContactService {
    Contact createContact(ContactCreateRequest request);
    void deleteAll();

}
