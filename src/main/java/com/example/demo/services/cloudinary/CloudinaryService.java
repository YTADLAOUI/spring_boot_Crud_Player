package com.example.demo.services.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface CloudinaryService {
    public String uploadFile(MultipartFile file);
    public File convertMultipartFileToFile(MultipartFile file) throws Exception;
}
