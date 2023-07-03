package com.box.springproject12pm.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@GetMapping("/upload")
	public String getuploadpage(HttpSession session) {
		
		if(session.getAttribute("validuser")==null) {
			return "login";
		}
		
		return "UploadForm";
	}
	
	@PostMapping("/upload")
	public String postupload(@RequestParam MultipartFile image,Model model,HttpSession session) {
		
		if(session.getAttribute("validuser")==null) {
			return "login";
		}
		
		if(!image.isEmpty()) {
			try {
				
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/images/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			model.addAttribute("message","File uploaded successfully");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "UploadForm";
	}

}
