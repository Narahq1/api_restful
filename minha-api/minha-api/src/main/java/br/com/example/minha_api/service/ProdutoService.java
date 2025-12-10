package br.com.example.minha_api.service;

import br.com.example.minha_api.repository.ProdutoRepository;
import br.com.example.minha_api.model.ProdutoModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Iterable<ProdutoModelo> listar() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModelo> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public ProdutoModelo salvar(ProdutoModelo produto) {
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
