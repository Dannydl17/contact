package contactApp.services;

import contactApp.data.models.User;
import contactApp.data.repositories.UserRepository;
import contactApp.dtos.requests.UserRegistrationRequest;
import contactApp.dtos.responses.UserRegistrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static contactApp.utils.Constants.USER_REGISTRATION_SUCCESSFUL_MESSAGE;

@Service
@AllArgsConstructor
public class AppUserService implements UserService{
    private final UserRepository userRepository;
    private final PhonebookService phonebookService;

    @Override
    public UserRegistrationResponse register(UserRegistrationRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());

        User savedUser = userRepository.save(user);
        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setId(savedUser.getId());
        response.setMessage(USER_REGISTRATION_SUCCESSFUL_MESSAGE);
        return response;
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
