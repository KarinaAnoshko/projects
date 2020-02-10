package by.local.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageService {

    public static final String IMAGE_FOLDER = "/var/project/images/";

    public void saveImage(MultipartFile file) throws IOException {
        file.transferTo(new File(IMAGE_FOLDER + file.getOriginalFilename()));
    }
}
