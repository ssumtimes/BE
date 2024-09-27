package org.sometimes.sometimes.content.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sometimes.sometimes.global.aws.ImageUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContentService {

    //UTIL
    private final ImageUploadService imageUploadService;
    public void addPhoto(MultipartFile contentImage) {
        imageUploadService.uploadContentImage(contentImage);
    }
}
