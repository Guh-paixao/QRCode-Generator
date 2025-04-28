package br.com.gustavopaixao.qrcodegenerator.controller;

import br.com.gustavopaixao.qrcodegenerator.dto.qrcode.QrCodeGenerateRequest;
import br.com.gustavopaixao.qrcodegenerator.dto.qrcode.QrCodeGenerateResponse;
import br.com.gustavopaixao.qrcodegenerator.service.QrCodeGenerateService;
import com.google.zxing.WriterException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGenerateService qrCodeService;

    public QrCodeController(QrCodeGenerateService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request) {
        try {
            QrCodeGenerateResponse response = this.qrCodeService.generateAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);
        } catch (WriterException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
