package com.hrnchshn.finance;


import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.auser.AUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinanceApplication.class, args);


	}
	@Bean
	CommandLineRunner init(final AUserRepository userRepository) {

		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				AUser user = AUser.builder().nickname("ivan")
						.password("ivan")
						.build();
				userRepository.save(user);

			}

		};

	}
}

