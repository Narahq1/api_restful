package br.com.example.minha_api.controller;

import br.com.example.minha_api.model.ProdutoModelo;
import br.com.example.minha_api.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.Iterable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@RestController
public class EstoqueController {
    @Autowired
    ProdutoService ps;

    @GetMapping("/")
    public void testeApi() {
        System.out.println("A API está funcionando.");
    }

    @GetMapping("/listar")
    public Iterable listar() {
        return ps.listar();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ProdutoModelo> buscarPorId(@PathVariable Long id) {
        Optional<ProdutoModelo> produtoOptional = ps.findById(id);
        if (produtoOptional.isPresent()) {
            return ResponseEntity.ok(produtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
