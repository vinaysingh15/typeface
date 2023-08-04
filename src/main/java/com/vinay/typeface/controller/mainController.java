package com.vinay.typeface.controller;

import com.vinay.typeface.model.FileInfo;
import com.vinay.typeface.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/typeface/api")
public class mainController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = fileStorageService.storeFile(file);
        return ResponseEntity.ok("File uploaded successfully. File name: " + fileName);
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> listFiles() {
        List<FileInfo> fileInfos = fileStorageService.listFiles();
        return ResponseEntity.ok(fileInfos);
    }
}
