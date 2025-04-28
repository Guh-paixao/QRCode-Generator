package br.com.gustavopaixao.qrcodegenerator.ports;

public interface StoragePort {
    String uploadFile(String fileName, byte[] fileData, String contentType);
}
