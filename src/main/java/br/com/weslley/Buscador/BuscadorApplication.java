package br.com.weslley.Buscador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Avisa a aplicação para procurar por interfaces FeignClient
public class BuscadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuscadorApplication.class, args);
	}

}
