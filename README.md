# spring-boot-pdf-qrcode-service

## Description

This project is a Spring Boot application that generates PDF files with embedded QR codes. The application provides
RESTful endpoints to create empty PDF files and to add QR codes at specified locations within the PDF. It leverages the
iText library for PDF manipulation and the ZXing library for QR code generation.

## Features

- **Generate Empty PDF**: Create an empty PDF file of A4 size.
- **Add QR Code to PDF**: Embed a QR code at the bottom of the PDF page with a specified text.
- **REST API**: Simple RESTful API to interact with the PDF generation functionalities.

## Technologies Used

- **Spring Boot**: For building the RESTful web service.
- **iText**: For PDF creation and manipulation.
- **ZXing (Zebra Crossing)**: For QR code generation.
- **Java**: As the programming language.
- **Lombok**: To reduce boilerplate code with annotations like `@RequiredArgsConstructor` and `@Slf4j`.

## How to Use

### Generate PDF with QR Code

- **Endpoint**: `/generateQRCodePDF`
- **Method**: POST
- **Request Body**:
  ```json
  {
    "text": "HelloWorld",
    "pdfPath": "/path/to/your/file.pdf"
  }
   ```

### Example Request:

- **POST http://localhost:8080/generateQRCodePDF**
- **Content-Type: application/json**

 ```json
{
  "text": "HelloWorld",
  "pdfPath": "/path/to/your/file.pdf"
}
```