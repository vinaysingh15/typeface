package com.vinay.typeface.service;

import com.vinay.typeface.model.FileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileStorageService {

    @Value("${upload.directory}")
    private String uploadDirectory;

    public String storeFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        File targetFile = new File(uploadDirectory, fileName);
        file.transferTo(targetFile);
        return fileName;
    }

    public List<FileInfo> listFiles() {
        List<FileInfo> fileInfos = new ArrayList<>();
        File uploadDir = new File(uploadDirectory);
        File[] files = uploadDir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.lastModified() != 0) {
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.setName(file.getName());
                    fileInfo.setCreatedTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), ZoneId.systemDefault()));
                    fileInfos.add(fileInfo);
                }
            }
        }

        return fileInfos;
    }
}

