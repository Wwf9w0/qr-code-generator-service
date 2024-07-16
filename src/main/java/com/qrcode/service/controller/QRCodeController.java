package com.qrcode.service.controller;

import com.google.zxing.WriterException;
import com.qrcode.service.service.QRCodeGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/qr-code")
@RequiredArgsConstructor
public class QRCodeController {

    private final QRCodeGeneratorService qrCodeGeneratorService;

    @PostMapping("/generate")
    public ResponseEntity<HttpStatus> generateQRCode(@RequestParam String text){
        qrCodeGeneratorService.generateQRCodeGenerator(text);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
