package org.ogleh.imagedemo.arrange.repo;

import org.ogleh.imagedemo.arrange.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Students, Integer> {
}

