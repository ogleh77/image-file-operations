package org.ogleh.imagedemo.arrange.repo;

import org.ogleh.imagedemo.arrange.entities.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {
    Optional<StudentProfile> findByProfileUrl(String url);
}
