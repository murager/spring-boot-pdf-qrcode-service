package kz.egov.qrcode.controller;

import com.google.zxing.WriterException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import kz.egov.qrcode.model.GeneratePdfRequest;
import kz.egov.qrcode.service.PdfService;
import kz.egov.qrcode.service.QrCodeGeneratorService;
import kz.egov.qrcode.service.QrCodeToPdfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class QrCodeController {
  private final QrCodeToPdfService qrCodeToPdfService;
  private final QrCodeGeneratorService qrCodeGeneratorService;
  private final PdfService pdfService;

  @PostMapping("/generateQRCodePDF")
  public String generateQRCodePDF(@RequestBody GeneratePdfRequest request) {
    try {
      pdfService.generateEmptyPDF(request.pdfPath());
      BufferedImage qrCodeImage = qrCodeGeneratorService.generateQRCodeImage(request.text());
      qrCodeToPdfService.addQRCodeToPDF(request.pdfPath(), qrCodeImage);
      return "PDF generated successfully with QR Code";
    } catch (WriterException | IOException e) {
      log.error("error" + e);
      return "Error while generating PDF";
    }
  }
}
