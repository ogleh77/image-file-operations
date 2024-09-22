package org.ogleh.imagedemo.images;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

public class FileStorage {

    public static String addFile(MultipartFile image, String filePath) throws Exception {

        File directory = new File(filePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = UUID.randomUUID() + "." + getFileExtension(Objects.requireNonNull(image.getOriginalFilename()));
        File imagePath = new File(directory, fileName);

        image.transferTo(imagePath);

        return fileName;
    }


    public static byte[] findImage(String filePath, String directory) throws Exception {
        Path path = getPath(filePath, directory);
        return Files.readAllBytes(path);
    }


    public static String deleteImage(String filePath, String directory) throws Exception {
        Path path = getPath(filePath, directory);

        boolean deleteImage = path.toFile().delete();

        if (!deleteImage) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        return path.toString();

    }

    public static String updateImage(String filePath, String directory, MultipartFile profile) throws Exception {
        deleteImage(filePath, directory);

        return addFile(profile, directory);
    }


    private static Path getPath(String filePath, String directory) throws FileNotFoundException {
        Path path = Paths.get(directory + "/" + filePath);
        if (!path.toFile().exists()) {
            throw new FileNotFoundException("Image is not exist " + filePath);
        }
        return path;
    }

    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


}
