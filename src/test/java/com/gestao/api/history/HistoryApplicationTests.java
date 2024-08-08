package com.gestao.api.history;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@OpenAPIDefinition(info = @Info(title = "History Service", version = "1.0.0", description = "Microservice for save and get products history"))
@SpringBootTest
class HistoryApplicationTests {

	@Test
	void contextLoads() {
	}

}
