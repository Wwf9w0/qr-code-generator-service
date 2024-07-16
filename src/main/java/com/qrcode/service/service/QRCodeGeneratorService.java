package com.qrcode.service.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
@Slf4j
public class QRCodeGeneratorService {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/QRCode.png";
    private static Integer WIDTH = 250;
    private static Integer HEIGHT = 250;

    public void generateQRCodeGenerator(String text)  {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);

        }catch (WriterException e){
            log.error("QR Code writer encode exception : {}", e);        }

        Path path = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH);
        try {
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        } catch (IOException e) {
            log.error("MatrixToImageWriter exception! - couse : {} , message : {} , stactTrace : {}", e.getCause(), e.getMessage(), e.getStackTrace());
            throw new RuntimeException(e);
        }
    }
}
