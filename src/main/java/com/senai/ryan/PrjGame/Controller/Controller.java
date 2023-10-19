package com.senai.ryan.PrjGame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.ryan.PrjGame.Service.Service;
import com.senai.ryan.PrjGame.entities.Jogo;

@RestController
@RequestMapping("/jogos")
public class Controller {

	private Service service;

	@Autowired
	public Controller(Service service) {
		this.service = service;
	}

	@PostMapping
	public Jogo createJogo(@RequestBody Jogo jogo) {
		return service.saveJogo(jogo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getJogo(@PathVariable Long id) {
		Jogo jogo = service.getJogoById(id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping
	public List<Jogo> getAllJogo() {
		return service.getAlljogo();
	}

	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		service.deleteJogo(id);
	}

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
}
