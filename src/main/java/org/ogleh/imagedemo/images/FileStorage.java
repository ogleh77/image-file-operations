package org.ogleh.imagedemo.images;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


public class FileStorage {

    public static String addFile(MultipartFile image, String directory) throws IOException {
        validateFile(image);

        Path dirPath = Paths.get(directory);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        String fileName = UUID.randomUUID() + "." + getFileExtension(image.getOriginalFilename());
        Path imagePath = dirPath.resolve(fileName);

        image.transferTo(imagePath.toFile());

        return fileName;
    }

    public static byte[] findImage(String filePath, String directory) throws IOException {
        Path path = getPath(filePath, directory);
        return Files.readAllBytes(path);
    }

    public static boolean deleteImage(String filePath, String directory) throws IOException {
        Path path = getPath(filePath, directory);
        return Files.deleteIfExists(path);
    }

    public static String updateImage(String filePath, String directory, MultipartFile profile) throws IOException {
        //Add the new image before deleting the prev image because if the adding image is field the prev image not fail
        String newFileName = addFile(profile, directory);
        deleteImage(filePath, directory);
        return newFileName;
    }

    private static Path getPath(String filePath, String directory) throws FileNotFoundException {
        Path path = Paths.get(directory, filePath);
        if (!Files.exists(path)) {
            throw new FileNotFoundException("Image not found: " + filePath);
        }
        return path;
    }

    private static String getFileExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            throw new IllegalArgumentException("Invalid file name");
        }
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    private static void validateFile(MultipartFile image) {
        if (image.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }
        String contentType = image.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("Only image files are allowed");
        }
    }
}


