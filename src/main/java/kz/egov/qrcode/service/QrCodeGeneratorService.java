package kz.egov.qrcode.service;

import com.google.zxing.WriterException;
import java.awt.image.BufferedImage;

public interface QrCodeGeneratorService {
  BufferedImage generateQRCodeImage(String barcodeText) throws WriterException;
}
