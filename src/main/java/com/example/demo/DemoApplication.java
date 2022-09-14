package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// add 2022/09/14
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
@RestController
public class DemoApplication {

	//public static void main(String[] args) {
	//	SpringApplication.run(DemoApplication.class, args);
	//}
	public static void main(String[] args) {
		try {
			HttpRequest request = HttpRequest
					.newBuilder(URI.create("https://datadoghq.com"))
					.build();
 
			BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8);
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request, bodyHandler);
			System.out.println(response.body());
			SpringApplication.run(DemoApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/")
	String sayHello() {
		return "Hello Azure!!";
	}
}
