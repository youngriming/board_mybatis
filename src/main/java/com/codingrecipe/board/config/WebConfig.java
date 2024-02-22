package com.codingrecipe.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private String resourcePath = "/upload/**"; // view에서 사용할 경로
    private String savePath = "file:///Users/youngriming/Desktop/Practice/"; // 실제 파일 저장 경로
//    private String savePath = "file:///C:/development/intellij_community/spring_upload_files/"; 윈도우 버전

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcePath)
                .addResourceLocations(savePath);
    }
}
