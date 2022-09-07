package com.szyska.employeeAPI.data.adress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szyska.employeeAPI.data.employee.Employee;

@RestController
@RequestMapping
public class AdressConroller {
	
	@Autowired
	AdressRepository adressRepo; 
	
	@GetMapping("/adress")
	public List<Adress> test(){
		return adressRepo.findAll();
	}
	
	@PostMapping(path="/addAdress", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addAdressToDatabase(@RequestBody Adress adress) {
		try {
			this.adressRepo.save(adress);
		}catch(Exception e){
			 
		}
	}
}
