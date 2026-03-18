package com.product.Gerenciamento_Produtos.Repositories;

import com.product.Gerenciamento_Produtos.Models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
