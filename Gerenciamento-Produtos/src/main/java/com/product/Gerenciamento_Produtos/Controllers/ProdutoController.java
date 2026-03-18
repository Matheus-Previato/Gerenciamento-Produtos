package com.product.Gerenciamento_Produtos.Controllers;

import com.product.Gerenciamento_Produtos.Models.ProdutoModel;
import com.product.Gerenciamento_Produtos.Services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    //Criar um novo produto (POST)
    @PostMapping
    public ResponseEntity<ProdutoModel> criar(@RequestBody ProdutoModel produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(produto)); // Retorna 201
    }

    //Listar todos os produtos (GET)
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listar() {
        return ResponseEntity.ok(service.listarTodos()); // Retorna 200
    }

    // Buscar um produto pelo ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok) // Retorna 200
                .orElse(ResponseEntity.notFound().build()); //Retorna 404
    }

    // Deletar um produto pelo ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna 204
    }
}