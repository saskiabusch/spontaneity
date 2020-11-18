package de.neuefische.hh2020j1.spontaneity.service;

import de.neuefische.hh2020j1.spontaneity.dao.UserDao;
import de.neuefische.hh2020j1.spontaneity.model.SpontaneityUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class SignUpServiceTest {

    final UserDao userDao = mock(UserDao.class);
    final SignUpService signUpService= new SignUpService(userDao);

    @Test
    @DisplayName("The \"signUp\" method with a new user should return HttpStatus.OK")
    void signUpTest() {
        //Given
        when(userDao.findById("Fiene")).thenReturn(Optional.empty());
        SpontaneityUser fiene= new SpontaneityUser("Fiene","1234");
        ResponseEntity expectedResponse=new ResponseEntity(HttpStatus.OK);

        // When
        ResponseEntity response= signUpService.signUp(fiene);

        // Then
        assertThat(response, is(expectedResponse));
    }

    @Test
    @DisplayName("The \"signUp\" method with an already excisting user should return HttpStatus.FORBIDDEN")
    void signUpWithExistingUserDetailsTest() {
        //Given
        SpontaneityUser fiene= new SpontaneityUser("Fiene","1234");
        when(userDao.findById("Fiene")).thenReturn(Optional.of(fiene));
        ResponseEntity expectedResponse=new ResponseEntity(HttpStatus.FORBIDDEN);

        // When
        ResponseEntity response= signUpService.signUp(fiene);

        // Then
        assertThat(response, is(expectedResponse));
    }

}
