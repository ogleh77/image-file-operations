package org.ogleh.imagedemo.arrange.controllers;

import lombok.RequiredArgsConstructor;
import org.ogleh.imagedemo.arrange.services.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/add")
    public String addProfile(@RequestParam("profile") MultipartFile profile) throws Exception {
        return profileService.addProfile(profile);
    }

    @GetMapping("/{path}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String path) throws Exception {
        byte[] imageData = profileService.getProfile(path);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    @DeleteMapping("/{path}")
    public boolean deleteImage(@PathVariable String path) throws Exception {
        return profileService.deleteImage(path);
    }

    @PutMapping("/{path}")
    public String updateImage(@PathVariable String path, @RequestParam("profile") MultipartFile profile) throws Exception {
        return profileService.updateProfile(path, profile);
    }
}
