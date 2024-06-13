package kz.egov.qrcode.service.impl;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.property.HorizontalAlignment;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import kz.egov.qrcode.service.QrCodeToPdfService;
import org.springframework.stereotype.Service;

@Service
public class QrCodeToPdfServiceImpl implements QrCodeToPdfService {
  @Override
  public void addQRCodeToPDF(String pdfPath, BufferedImage qrCodeImage) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(qrCodeImage, "png", baos);
    ImageData imageData = ImageDataFactory.create(baos.toByteArray());

    PdfWriter writer = new PdfWriter(new FileOutputStream(pdfPath));
    PdfDocument pdfDoc = new PdfDocument(writer);
    PageSize pageSize = PageSize.A4;
//    PdfPage pdfPage = pdfDoc.addNewPage(pageSize);

    Document document = new Document(pdfDoc);
    Image image = new Image(imageData);

    // Set the position of the QR code at the bottom of the page
    float x = (pageSize.getWidth() - image.getImageScaledWidth()) / 2;
    float y = 20; // Adjust this value as needed to place the QR code at the bottom
    image.setFixedPosition(x, y);
    image.setHorizontalAlignment(HorizontalAlignment.CENTER);

    document.add(image);

    document.close();
  }
}
