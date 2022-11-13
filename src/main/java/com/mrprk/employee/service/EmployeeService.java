package com.mrprk.employee.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mrprk.employee.entity.Employee;
import com.mrprk.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository fileDataRepository;

	private final String FOLDER_PATH = "C:\\Users\\ATIM\\Desktop\\MyFiles\\";

	public String UploadImageToFileSystem(MultipartFile file) throws IOException {
		String filePath = FOLDER_PATH + file.getOriginalFilename();
		Employee fileData = fileDataRepository.save(Employee.builder().name(file.getOriginalFilename())
				.type(file.getContentType()).filePath(filePath).build());
		file.transferTo(new File(filePath));

		if (fileData != null) {
			return "file upload successfully :" + filePath;
		}
		return null;
	}

	public byte[] downloadImageFromFileSyatem(String fileName) throws IOException {
		Optional<Employee> fileData = fileDataRepository.findByName(fileName);
		System.out.println("============================= fileData ==========================" + fileData);
		String filePath = fileData.get().getFilePath();
		byte[] images = Files.readAllBytes(new File(filePath).toPath());
		return images;
	}

}
