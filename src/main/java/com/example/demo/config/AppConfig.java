package com.example.demo.config;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dkjzkg5mk");
        config.put("api_key", "495627671349999");
        config.put("api_secret", "1ku-h5_YzRSMhnqFaCKM2T6X7DE");
        return new Cloudinary(config);
    }
}
