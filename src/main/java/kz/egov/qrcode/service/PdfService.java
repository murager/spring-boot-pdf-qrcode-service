package kz.egov.qrcode.service;

import java.io.FileNotFoundException;

public interface PdfService {
  void generateEmptyPDF(String pdfPath) throws FileNotFoundException;
}
