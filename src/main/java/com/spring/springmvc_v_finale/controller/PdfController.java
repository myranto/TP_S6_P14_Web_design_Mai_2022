package com.spring.springmvc_v_finale.controller;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring.springmvc_v_finale.model.Category;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

@Controller
public class PdfController {

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generatePdf() throws Exception {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);

        document.open();

        // Ajouter un titre au document
        Paragraph title = new Paragraph("Liste des catégories");
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Ajouter une introduction avant la table
        Paragraph intro = new Paragraph("Voici la liste de toutes les catégories :");
        intro.setAlignment(Element.ALIGN_LEFT);
        intro.setSpacingBefore(10f);
        document.add(intro);

        // Ajouter une ligne vide
        Paragraph emptyLine = new Paragraph(" ");
        document.add(emptyLine);

        // Créer une table pour la liste des catégories
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);

        // Ajouter les en-têtes de colonnes à la table
        PdfPCell cell1 = new PdfPCell(new Paragraph("ID"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("Nom"));
        table.addCell(cell1);
        table.addCell(cell2);
        // Ajouter les données de la liste à la table
        ArrayList<Category> list = new Category().SelectAll();
        for (Category category : list) {
            PdfPCell idCell = new PdfPCell(new Paragraph(Integer.toString(category.getIdcategory())));
            PdfPCell nameCell = new PdfPCell(new Paragraph(category.getName_category()));
            table.addCell(idCell);
            table.addCell(nameCell);
        }

        // Ajouter la table au document
        document.add(table);

        document.close();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "example.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(baos.toByteArray());
    }
}
