package com.mrprk.employee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mrprk.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService fileUploadService;

	@PostMapping("/upload")
	public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image") MultipartFile file) throws IOException {
		String uploadImage = fileUploadService.UploadImageToFileSystem(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	@GetMapping("/get/{fileName}")
	public ResponseEntity<?> downloadImageFromSystem(@PathVariable String fileName) throws IOException {
		byte[] imageData = fileUploadService.downloadImageFromFileSyatem(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
	}



}
