package contactApp.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static contactApp.utils.Constants.BLANK_FIELD_MESSAGE;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {
    @NotBlank(message = BLANK_FIELD_MESSAGE)
    private String firstName;
    private String lastName;
    private String email;
    @NotBlank(message = BLANK_FIELD_MESSAGE)
    private String phoneNumber;
}
