package com.example.riff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@SpringBootApplication
public class RiffApplication {

		@Bean
		Function<Flux<Input>, Flux<Output>> uppercase() {
				return incoming -> incoming.log().map(value -> new Output(value.uppercase()));
		}

		public static void main(String[] args) {
				SpringApplication.run(RiffApplication.class, args);
				System.out.println("Starting " + RiffApplication.class.getName());
		}
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Input {

		private String value;

		String uppercase() {
				return value.toUpperCase();
		}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Output {
		private String value;
}
