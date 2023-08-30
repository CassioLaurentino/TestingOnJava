package unit.java.com.testingOnJava.controller;

import com.testingOnJava.controller.TestingController;
import com.testingOnJava.dto.request.AddressDto;
import com.testingOnJava.dto.request.UserDto;
import com.testingOnJava.dto.response.ResponseDto;
import com.testingOnJava.service.TestingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestingControllerTests {

    @InjectMocks
    private TestingController testingController;

    @Mock
    private TestingService testingService;

    private UserDto userDto;
    private AddressDto addressDto;

    @BeforeEach
    public void init() {
        addressDto = new AddressDto(1L, "123 Main St", "SampleCity", "SampleState", "SampleState", "SampleCountry");
        userDto = new UserDto(1L, "John", "Doe", "john2023", "john.doe@example.com", addressDto, "1234567890", "1990-01-01", "http://example.com/profile.jpg");
    }

    @Test
    public void shouldCreateUser() {
        // Exemplo de Stub -> retorno de sucesso
        when(testingService.createUser(any(UserDto.class)))
                .thenReturn(new ResponseDto(200, LocalDateTime.now()));
        ResponseEntity<ResponseDto> response = testingController.createUser(userDto);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test // TESTE DE BRANCH
    public void shouldThrowOnCreateUser() {
        // Exemplo de Stub -> retorno de "erro"
        when(testingService.createUser(any(UserDto.class)))
                .thenReturn(new ResponseDto(400, LocalDateTime.now()));
        assertThrows(RuntimeException.class, () -> testingController.createUser(userDto));
    }
}
