package ru.sbrf.emoAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.sbrf.emoAuth.entity.User;
import ru.sbrf.emoAuth.repo.UserRepository;

@SpringBootApplication
public class EmoAuthApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(EmoAuthApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		System.out.println("Hello");

		Iterable<User> users = userRepository.findAll();
		for( User user : users)
			System.out.println(user);


	}

}
