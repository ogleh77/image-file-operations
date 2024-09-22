package org.ogleh.imagedemo.arrange.services;

import lombok.RequiredArgsConstructor;
import org.ogleh.imagedemo.arrange.entities.Students;
import org.ogleh.imagedemo.arrange.repo.StudentRepo;
import org.ogleh.imagedemo.images.FileStorage;
import org.ogleh.imagedemo.images.ImagePath;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public Students creatStudent(Students student, MultipartFile studentImage) throws Exception {
        if (studentImage != null) {
            String imagePath = FileStorage.addFile(studentImage, ImagePath.CANDIDATE_PATH.getPath() + "/");
            student.setProfile("/profile/"+imagePath);
        }
//        studentRepo.save(student);

        return student;
    }
}
