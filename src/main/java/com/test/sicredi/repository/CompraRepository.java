package com.test.sicredi.repository;

import com.test.sicredi.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {


    @Query(value =
            "select " +
                    "   com.id, " +
                    "   pes.cpf, " +
                    "   pes.nome, " +
                    "   com.valor_total, " +
                    "   com.data " +
                    "from " +
                    "   compra com, " +
                    "   pessoa pes " +
                    "where " +
                    "   pes.cpf=com.pessoa_cpf " +
                    "   and com.data BETWEEN ?2 AND ?3 " +
                    "   and com.pessoa_cpf = ?1 ;", nativeQuery = true)
    List<Object[]> consultarComprasPorCpfEDataInicialEDataFinal(String cpf, Date dataInicial, Date dataFinal);


}
