package com.osiki.demojpa;

import com.osiki.demojpa.enums.Gender;
import com.osiki.demojpa.model.User;
import com.osiki.demojpa.model.UserProfile;
import com.osiki.demojpa.repository.UserProfileRepository;
import com.osiki.demojpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userProfileRepository.deleteAllInBatch();
		userRepository.deleteAllInBatch();

		User users = new User("John", "Doe", "john@gmail.com", "123456");

		Calendar dob = Calendar.getInstance();
		dob.set(1990, 10, 10);


		UserProfile userProfile = new UserProfile("0801234567", Gender.MALE, dob.getTime(),
				"123", "1st obe", "Benin", "Edo", "Nigeria");

		users.setUserProfile(userProfile);


		userProfile.setUser(users);

		userRepository.save(users);

	}
}
