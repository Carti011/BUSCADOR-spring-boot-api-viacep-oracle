package br.com.weslley.Buscador.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Anotação que diz ao Spring: "Esta classe é um Controller de API"
public class HomeController {

    @GetMapping("/") // Anotação que diz: "Quando alguém acessar a URL raiz ('/'), execute este metodo"
    public String home() {
        return "Minha primeira API está no ar!";
    }
}