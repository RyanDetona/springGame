package com.senai.ryan.PrjGame.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.senai.ryan.PrjGame.entities.Jogo;
import com.senai.ryan.PrjGame.repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	private final Repository repository;
	
	@Autowired
	public Service (Repository repository) {
		this.repository = repository;
	}
	
	public Jogo saveJogo(Jogo jogo) {
		return repository.save(jogo);
	}
	
	public List<Jogo> getAlljogo(){
		return repository.findAll();
	}
	
	public Jogo getJogoById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void deleteJogo(Long id) {
		repository.deleteById(id);
	}

}
