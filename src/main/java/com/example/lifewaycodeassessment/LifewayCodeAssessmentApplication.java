package com.example.lifewaycodeassessment;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LifewayCodeAssessmentApplication {
	//private static final Logger log = LoggerFactory.getLogger(LifewayCodeAssessmentApplication.class);

	public LifewayCodeAssessmentApplication() throws JsonProcessingException {
	}

	public static void main(String[] args) {
		SpringApplication.run(LifewayCodeAssessmentApplication.class, args);
	}
}
