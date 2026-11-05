package com.movieflix.service.impl;

import com.movieflix.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename(); //used to separate directory names within a single file path.
        String filePath = path + File.separator + fileName;

        File f = new File(filePath);
        if (!f.exists()) {
            f.mkdir();
        }

        // copy file to the path
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);// REPLACE EXISTING FILE WITH NEW IF NAME ARE SAME

        return fileName;
    }

    @Override
    public InputStream getResourceFile(String path, String filename) throws IOException {
        String filePath = path + File.separator + filename;
        return new FileInputStream(filePath);
    }
}
