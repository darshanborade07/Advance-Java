package com.blogs.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.blogs.entities.User;

@DataJpaTest //annotation to tell spring boot test framework to enable 
//Data JPA layer (i.e. service | controller | 
//modelmapper ... beans will not be activated)
@AutoConfigureTestDatabase(replace = Replace.NONE)
//tells spring boot test framework - not to be replace original data source (i.e. mySql)
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Test //JUnit anno to indicate a test method
	void testFindByEmailAndPassword() {
		Optional<User> optional = userRepository.findByEmailAndPassword("a2@gmail.com", "2234");
		//assert methods arguments - expected, actual
		//test case passes when expected matches the actual
		//o.w. fails
		assertEquals(2l,optional.get().getId());
	}

}
