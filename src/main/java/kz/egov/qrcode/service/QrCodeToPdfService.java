package kz.egov.qrcode.service;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface QrCodeToPdfService {
  void addQRCodeToPDF(String pdfPath, BufferedImage qrCodeImage) throws IOException;
}
