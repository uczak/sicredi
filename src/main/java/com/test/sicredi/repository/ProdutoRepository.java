package com.test.sicredi.repository;

import com.test.sicredi.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    @Query(value =
            "SELECT " +
                    "    pro.id, " +
                    "    pro.nome, " +
                    "    pro.valor " +
                    "FROM produto pro " +
                    "JOIN compra_produto cmp ON pro.id = cmp.produto_id " +
                    "WHERE " +
                    "    UPPER(pro.nome) LIKE :produto_nome " +
                    "    AND cmp.compra_id = :id ;", nativeQuery = true)
    List<Produto> findByCompraIdAndProdutoNome(@Param("produto_nome") String produtoNome, @Param("id") Long compraId);

}
