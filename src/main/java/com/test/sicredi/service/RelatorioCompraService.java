package com.test.sicredi.service;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.test.sicredi.model.RelatorioCompraDiario;
import com.test.sicredi.repository.RelatorioCompraRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class RelatorioCompraService {

    @Autowired
    RelatorioCompraRepository relatorioCompraRepository;

    public ResponseEntity<byte[]> relatorioCompras() {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            // Cria um PDF em memória
            PdfWriter writer = new PdfWriter(out);
            com.itextpdf.kernel.pdf.PdfDocument pdf = new com.itextpdf.kernel.pdf.PdfDocument(writer);
            Document document = new Document(pdf);

            List<RelatorioCompraDiario> relatorioCompraDiarios = relatorioCompraRepository.relatorioCompra();

            BigDecimal valorTotal = BigDecimal.ZERO;
            document.add(new Paragraph("----------------------Relatório de compras----------------------"));
            Date data = null;
            Table table = new Table(3).addCell("produto").addCell("valor").addCell("quantidade");

            for (RelatorioCompraDiario relatorioCompraDiario : relatorioCompraDiarios) {

                valorTotal = valorTotal.add((relatorioCompraDiario.getValor().multiply(new BigDecimal(relatorioCompraDiario.getQuantidade()))));

                if (data == null) {
                    data = relatorioCompraDiario.getId().getData();
                    table = new Table(3).addCell("Produto").addCell("Valor Uni.").addCell("Quantidade Pro. vendidos"); // Cria uma tabela com 3 colunas

                } else if (data.getDay() != relatorioCompraDiario.getId().getData().getDay()) {
                    document.add(table);
                    document.add(new Paragraph("-------Data: " + data.toString() + "--- Total: " + valorTotal.toString() ));
                    data = relatorioCompraDiario.getId().getData();
                    table = new Table(3).addCell("Produto").addCell("Valor Uni.").addCell("Quantidade Pro. vendidos"); // Cria uma tabela com 3 colunas
                }
                table.addCell(relatorioCompraDiario.getNome());
                table.addCell(relatorioCompraDiario.getValor().toString());
                table.addCell(relatorioCompraDiario.getQuantidade().toString());
            }
            document.add(table);
            document.add(new Paragraph("-------Data: " + data.toString() + "--- Total: " + valorTotal.toString() ));
            document.add(new Paragraph("Guilherme Uczak"));
            // Fecha o documento
            document.close();

            // Define os headers para o arquivo de resposta
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "arquivo.pdf");

            // Retorna o PDF como array de bytes
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(out.toByteArray());

        } catch (
                Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();  // Retorna 500 em caso de erro
        }
    }
}
