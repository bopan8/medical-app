package com.javamedical.medicalapp.controllers;

import com.javamedical.medicalapp.domain.Prescriptions;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class PDFExporter {
    private List<Prescriptions> prescriptionsList;

    public PDFExporter(List<Prescriptions> prescriptionsList){
        this.prescriptionsList=prescriptionsList;
    }

    private void writeTableHeader(){

    }

    private void writeTableData(){

    }

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document,response.getOutputStream());
        document.open();

        document.add(new Paragraph("THIS IS YOUR PRESCRIPTION"));
        document.close();
    }
}
