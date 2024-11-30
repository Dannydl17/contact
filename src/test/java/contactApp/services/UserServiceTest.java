package contactApp.services;

import contactApp.data.repositories.UserRepository;
import contactApp.dtos.requests.UserRegistrationRequest;
import contactApp.dtos.responses.UserRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static contactApp.utils.Constants.USER_REGISTRATION_SUCCESSFUL_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private AppUserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void startEachTestWith(){
        userService.deleteAll();
    }

    @Test
    public void testThatUsersCanRegisterTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setFirstName("Daniel");
        request.setLastName("Adeniyi");
        request.setEmail("test@email.com");
        request.setPhoneNumber("090234567891");

        UserRegistrationResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());
        assertThat(response.getMessage()).isEqualTo(USER_REGISTRATION_SUCCESSFUL_MESSAGE);
    }
}
