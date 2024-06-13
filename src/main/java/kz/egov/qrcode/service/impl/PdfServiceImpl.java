package kz.egov.qrcode.service.impl;

import kz.egov.qrcode.service.PdfService;
import org.springframework.stereotype.Service;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.FileNotFoundException;
@Service
public class PdfServiceImpl implements PdfService {
  public void generateEmptyPDF(String pdfPath) throws FileNotFoundException {
    PdfWriter writer = new PdfWriter(pdfPath);
    PdfDocument pdfDoc = new PdfDocument(writer);
    pdfDoc.addNewPage();
    pdfDoc.close();
  }
}
