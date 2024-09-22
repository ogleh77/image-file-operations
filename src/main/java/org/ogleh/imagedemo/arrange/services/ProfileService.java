package org.ogleh.imagedemo.arrange.services;

import org.ogleh.imagedemo.images.FileStorage;
import org.ogleh.imagedemo.images.ImagePath;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProfileService {
    private final String candidatePath = ImagePath.CANDIDATE_PATH.getPath();

    public String addProfile(MultipartFile image) throws Exception {
        return FileStorage.addFile(image, candidatePath);
    }


    public byte[] getProfile(String profilePath) throws Exception {
        return FileStorage.findImage(profilePath, candidatePath);
    }

    public String deleteImage(String filePath) throws Exception {
        return FileStorage.deleteImage(filePath, candidatePath);
    }

    public String updateProfile(String path, MultipartFile profile) throws Exception {
        return FileStorage.updateImage(path, candidatePath, profile);
    }
}
