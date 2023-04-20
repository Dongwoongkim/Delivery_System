package kdo6301.DeliverySystem;

import kdo6301.DeliverySystem.config.WebConfig;
import kdo6301.DeliverySystem.repository.item.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Import(WebConfig.class)
public class DeliverySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliverySystemApplication.class, args);
	}

//	@Bean
//	@Profile("local")
//	public TestDataInit testDataInit(ItemRepository itemRepository) {
//		return new TestDataInit(itemRepository);
//	}
}
