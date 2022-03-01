package vn.t3h.java2109.services;

import org.springframework.web.multipart.MultipartFile;
import vn.t3h.java2109.utils.FileUtils;

import java.io.IOException;
import java.util.Date;

public class FileService implements IFileService{
    private FileUtils fileManager = new FileUtils();
    private String linkFolder = "C:\\Users\\Admin\\Desktop\\ImageT3H";

    @Override
    public String uploadImage(MultipartFile image) throws IOException {

        String nameImage = new Date().getTime() + "." + fileManager.getFormatFile(image.getOriginalFilename());

        String path = linkFolder + "\\" + nameImage;

        fileManager.createNewMultiPartFile(path, image);
        // TODO save link file to database

        // return link uploaded file
        return nameImage;
    }

}
