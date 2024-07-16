package fullstackapp.employeeManagementSystem.services.dtos.requests;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddEmployeeRequest {
    @NotBlank(message = "İsim alanı boş olamaz!")
    @Size(min = 2, max = 50, message = "İsim alanı 2 ile 50 karakter arasında olmalıdır!")
    private String firstName;
    @NotBlank(message = "Soyad alanı boş olamaz!")
    @Size(min = 2, max = 50, message = "Soyad alanı 2 ile 50 karakter arasında olmalıdır!")
    private String lastName;
    @NotNull
    @PositiveOrZero
    private double salary;
}
