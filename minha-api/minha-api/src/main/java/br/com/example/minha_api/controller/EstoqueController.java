package br.com.example.minha_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstoqueController {

    @GetMapping("/")
    public void testeApi() {
        System.out.println("A API está funcionando.");
    }
}
