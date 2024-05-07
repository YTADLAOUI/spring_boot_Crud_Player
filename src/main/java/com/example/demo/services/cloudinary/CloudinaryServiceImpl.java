package com.example.demo.services.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {

    private final Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            File convertedFile = convertMultipartFileToFile(file);
            Map uploadedFile = cloudinary.uploader().upload(convertedFile, ObjectUtils.emptyMap());
            return uploadedFile.get("url").toString();
        }catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public File convertMultipartFileToFile(MultipartFile file) throws Exception{
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fileOutputStream = new FileOutputStream(convertedFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        return convertedFile;
    }
}
