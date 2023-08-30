package unit.java.com.testingOnJava.service;

import com.testingOnJava.controller.TestingController;
import com.testingOnJava.dto.request.AddressDto;
import com.testingOnJava.dto.request.UserDto;
import com.testingOnJava.dto.response.ResponseDto;
import com.testingOnJava.model.User;
import com.testingOnJava.repository.UserRepository;
import com.testingOnJava.service.TestingService;
import com.testingOnJava.service.impl.TestingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestingServiceImplTests {

    @InjectMocks
    private TestingServiceImpl testingService;

    @Mock
    private UserRepository userRepository;

//    @Captor
//    private ArgumentCaptor<User> captor;

    private UserDto userDto;
    private AddressDto addressDto;

    @BeforeEach
    public void init() {
        addressDto = new AddressDto(1L, "123 Main St", "SampleCity", "SampleState", "12345", "SampleCountry");
        userDto = new UserDto(1L, "John", "Doe", "john2023", "john.doe@example.com", addressDto, "1234567890", "1990-01-01", "http://example.com/profile.jpg");
    }

    @Test // TESTE COMPLETO
    public void shouldCreateUser() {
        ResponseDto response = testingService.createUser(userDto);
        assertEquals(200, response.status());

        // Captura os dados do usuário passados no metodo .save()
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(captor.capture());
        User user = captor.getValue();

        // Validação dos dados do endereço do User
        assertEquals(user.getAddress().getCity(), userDto.address().city());
        assertEquals(user.getAddress().getCountry(), userDto.address().country());
        assertEquals(user.getAddress().getStreet(), userDto.address().street());
        assertEquals(user.getAddress().getState(), userDto.address().state());
        assertEquals(user.getAddress().getPostalCode(), userDto.address().postalCode());

        // Validação dos dados do User
        assertEquals(user.getFirstName(), userDto.firstName());
        assertEquals(user.getLastName(), userDto.lastName());
        assertEquals(user.getUsername(), userDto.username());
        assertEquals(user.getEmail(), userDto.email());
        assertEquals(user.getPhoneNumber(), userDto.phoneNumber());
        assertEquals(user.getDateOfBirth(), userDto.dateOfBirth());
        assertEquals(user.getProfilePictureUrl(), userDto.profilePictureUrl());
    }

    @Test // TESTE DE EXCEPTION
    public void shouldThrowOnCreateUser() {
        // Exemplo de Stub -> jogando um exception
        when(userRepository.save(any(User.class))).thenThrow(new RuntimeException());
        ResponseDto response = testingService.createUser(userDto);

        verify(userRepository).save(any(User.class));
        assertEquals(400, response.status());
    }

//    @Test // TESTE INCOMPLETO
//    public void shouldCreateUser() {
//        ResponseDto response = testingService.createUser(userDto);
//
//        verify(userRepository).save(any(User.class));
//        assertEquals(200, response.status());
//
////        assertEquals(addressDto.city(), response. ?); // Parametros que precisam ser validados não são retornados.
//    }
}
