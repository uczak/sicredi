package com.test.sicredi.repository;

import com.test.sicredi.model.RelatorioCompraDiario;
import com.test.sicredi.model.RelatorioCompraDiarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface RelatorioCompraRepository extends JpaRepository<RelatorioCompraDiario, RelatorioCompraDiarioId> {


    @Query(value =
            "SELECT trunc(com.data) data, cmp.produto_id, pro.nome, pro.valor, count(*) quantidade " +
                    "from compra com, compra_produto cmp, produto pro " +
                    "where com.id=cmp.compra_id " +
                    "and pro.id=cmp.produto_id " +
                    "group by trunc(com.data), cmp.produto_id, pro.nome, pro.valor;", nativeQuery = true)
    List<RelatorioCompraDiario> relatorioCompra();


}
