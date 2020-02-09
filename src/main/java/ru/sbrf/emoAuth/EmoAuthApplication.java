package ru.sbrf.emoAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.sbrf.emoAuth.entity.User;
import ru.sbrf.emoAuth.entity.View;
import ru.sbrf.emoAuth.repo.ComponentRepository;
import ru.sbrf.emoAuth.repo.UserRepository;
import ru.sbrf.emoAuth.repo.ViewRepository;

@SpringBootApplication
public class EmoAuthApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(EmoAuthApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
//		ViewRepository viewRepository = context.getBean(ViewRepository.class);
//		ComponentRepository componentRepository = context.getBean(ComponentRepository.class);

		System.out.println("Hello");

		Iterable<User> users = userRepository.findAll();
		for( User user : users)
			System.out.println(user);

//		Iterable<View> views = viewRepository.findAll();
//		for( View view : views)
//			System.out.println(view);

	}

}
