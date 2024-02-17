package com.example.HW_Sem2;

import com.example.HW_Sem2.model.User;
import com.example.HW_Sem2.repositories.UserRepo;
import com.example.HW_Sem2.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HwSem2MODTests {

	@Mock
	private UserRepo userRepo;
	@InjectMocks
	private UserService userService;

	@Test
	void contextUpdate() {
		User testUser = new User();
		testUser.setId(1L);
		testUser.setFirstName("Evgeny");
		testUser.setLastName("Mart");

		when(userRepo.findById(any(Long.class))).thenReturn(Optional.of(testUser));
		when(userRepo.save(testUser)).thenReturn(testUser);

		User userForUpdate = new User();
		userForUpdate.setId(1L);
		userForUpdate.setFirstName("Evgeny2");
		userForUpdate.setLastName("Mart2");

		User resultUser = userService.update(userForUpdate);

		assertNotNull(resultUser);
		assertSame(resultUser.getId(),testUser.getId());
		assertEquals(resultUser.getFirstName(),testUser.getFirstName());
		assertEquals(resultUser.getLastName(),testUser.getLastName());
	}

}

