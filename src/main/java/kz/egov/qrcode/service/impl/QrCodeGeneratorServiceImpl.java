package kz.egov.qrcode.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import kz.egov.qrcode.service.QrCodeGeneratorService;
import org.springframework.stereotype.Service;

@Service
public class QrCodeGeneratorServiceImpl implements QrCodeGeneratorService {
  @Override
  public BufferedImage generateQRCodeImage(String barcodeText) throws WriterException {
    QRCodeWriter barcodeWriter = new QRCodeWriter();
    com.google.zxing.common.BitMatrix bitMatrix =
        barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

    return MatrixToImageWriter.toBufferedImage(bitMatrix);
  }
}
