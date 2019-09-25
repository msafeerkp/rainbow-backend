package com.rainbow.school.rest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainbow.school.model.CircularModel;
import com.rainbow.school.service.CircularService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/circular")
public class CircularResource {
	
	@Autowired
	private CircularService circularService; 
	
	
	@PostMapping
	public boolean createCircular(@RequestBody CircularModel circularModel) {
		circularService.addCircular(circularModel);
		return true;
	}
	
	@GetMapping("/distinct/ciriculat-date")
	public List<String> getDiffCircularDateList() {
		return circularService.getDifferentCircularDateList();
	}
	
	@GetMapping("/list")
	public List<CircularModel> getDiffCircularDateList(@RequestParam String date) {
		return circularService.getCircularListByDate(date);
	}

}
