package br.com.example.minha_api.controller;

import br.com.example.minha_api.model.ProdutoModelo;
import br.com.example.minha_api.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class EstoqueController {
    @Autowired
    ProdutoService ps;

    @GetMapping("/")
    public String testeApi() {
        return "A API está funcionando.";
    }

    @GetMapping
    public Iterable<ProdutoModelo> listar() {
        return ps.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModelo> buscarPorId(@PathVariable Long id) {
        Optional<ProdutoModelo> produtoOptional = ps.findById(id);
        if (produtoOptional.isPresent()) {
            return ResponseEntity.ok(produtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProdutoModelo> criar(@Valid @RequestBody ProdutoModelo produto) {
        ProdutoModelo novoProduto = ps.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModelo> atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoModelo produto) {
        Optional<ProdutoModelo> produtoExistente = ps.findById(id);
        if (produtoExistente.isPresent()) {
            produto.setId(id);
            ProdutoModelo produtoAtualizado = ps.salvar(produto);
            return ResponseEntity.ok(produtoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<ProdutoModelo> produtoExistente = ps.findById(id);
        if (produtoExistente.isPresent()) {
            ps.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
