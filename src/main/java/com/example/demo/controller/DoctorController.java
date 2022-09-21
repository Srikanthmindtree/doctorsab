package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DoctorEntity;
import com.example.demo.repository.DoctorRepository;

@RestController
public class DoctorController {
	@Autowired
private DoctorRepository repo;
	
	@GetMapping("/all")
	public List<DoctorEntity> getAll()
	{
	 return	repo.findAll();
	}
	@PostMapping("/save")
	public DoctorEntity save(@RequestBody DoctorEntity doctor)
	{
		return repo.save(doctor);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "deleted"+id;
	}
}
