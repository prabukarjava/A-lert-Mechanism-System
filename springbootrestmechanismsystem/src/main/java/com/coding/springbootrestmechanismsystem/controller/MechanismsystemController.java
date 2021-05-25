package com.coding.springbootrestmechanismsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.springbootrestmechanismsystem.dao.MachanisamDAO;
import com.coding.springbootrestmechanismsystem.model.Mechanisamsystem;

@RestController
@RequestMapping("/name")
public class MechanismsystemController {
	
	@Autowired
	MachanisamDAO machanisamDAO;
	
	/* to save*/
	@PostMapping("/mechanisamdetails")
	public Mechanisamsystem createMechanisamsystem(@Valid @RequestBody Mechanisamsystem mec) {
		return machanisamDAO.save(mec);
	}
    
	/* get all team*/
	@GetMapping("/mechanisamdetails")
	public List <Mechanisamsystem> getAllMechanisamsystem(){
		return machanisamDAO.findAll();
	}
	
	/* get details by id*/
	@GetMapping("/mechanisamdetails/{id}")
	public ResponseEntity<Mechanisamsystem> getmechanisamdetailsById(@PathVariable(value="id")Long teamid){
		Mechanisamsystem mec=MachanisamDAO.findOne(teamid);
		if(mec==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(mec);
		
	}
	
	/* updaste an mechanisamsystem by teamid*/
	@PutMapping("/mechanisamdetails/{id}")
	public ResponseEntity<Mechanisamsystem> updateMechanisamsystem(PathVariable(value="id")Long teamid,@Vaild @RequestBody Mechanisamsystem mecDetails){
		Mechanisamsystem mec=machanisamDAO.findOne(teamid);
				if(mec==null) {
					return ResponseEntity.notFound().build();
				}
            mec.setName(mecDetails.getName());
            mec.setDesignation(mecDetails.getDesignation());
            mec.setExpertise(mecDetails.getExpertise());
            
            Mechanisamsystem updateMechanisamsystem=machanisamDAO.save(mec);
            return ResponseEntity.ok().body(mec);
	}
	
	/* Delete an mechanisamdetails*/
	@DeleteMapping("/mechanisamdetails/{id}")
	public ResponseEntity<Mechanisamsystem> deleteMechanisamsystem(@PathVariable(value="id")Long teamid){
		Mechanisamsystem mec=machanisamDAO.findOne(teamid);
		if(mec==null) {
			return ResponseEntity.notFound().build();
		}
		machanisamDAO.delete(mec);
		return ResponseEntity.ok().build();
		
	}
}
