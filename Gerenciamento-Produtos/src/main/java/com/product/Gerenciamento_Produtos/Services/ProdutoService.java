package com.product.Gerenciamento_Produtos.Services;

import com.product.Gerenciamento_Produtos.Models.ProdutoModel;
import com.product.Gerenciamento_Produtos.Repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoModel salvar(ProdutoModel produto) {
        return repository.save(produto);
    }

    public List<ProdutoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<ProdutoModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
