package com.coding.springbootrestmechanismsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.springbootrestmechanismsystem.model.Mechanisamsystem;
import com.coding.springbootrestmechanismsystem.repository.MechanisamsystemRepository;

@Service
public class MachanisamDAO {

	@Autowired
	MechanisamsystemRepository mechanisamsystemRepository;
	
	/*to save*/
	
	public Mechanisamsystem save(Mechanisamsystem mec) {
		
		return mechanisamsystemRepository.save(mec);
		
	}
	
	
	/* search all*/
	public List<Mechanisamsystem> findAll(){
		return mechanisamsystemRepository.findAll();
	}
	
	/* get an name  by id*/
	public Mechanisamsystem findone(Long teamid) {
		return mechanisamsystemRepository.findOne(teamid);
	}
	
	
	/*delete */
	
	public void delete(Mechanisamsystem mec) {
		mechanisamsystemRepository.delete(mec);
	}
}
