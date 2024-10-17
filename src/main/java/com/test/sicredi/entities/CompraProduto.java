package com.test.sicredi.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "compra_produto")
public class CompraProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "produto_id")
    private Long produtoId;
    @Column(name = "compra_id")
    private Long compraId;

    public CompraProduto(Long produtoId, Long compraId) {
        this.produtoId = produtoId;
        this.compraId = compraId;
    }
}