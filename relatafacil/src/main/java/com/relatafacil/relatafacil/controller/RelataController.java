package com.relatafacil.relatafacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relatafacil.relatafacil.dto.RelataDTO;
import com.relatafacil.relatafacil.model.RelataModel;
import com.relatafacil.relatafacil.repository.RelataRepository;
import com.relatafacil.relatafacil.service.RelataService;

@RestController
@RequestMapping("a")
public class RelataController {

	@Autowired
    private RelataService relataService;
	
	@Autowired
	RelataRepository repo;
	
	// Retorna todos os relatórios.
		@GetMapping
	    public List<RelataModel> listar() {
	        return relataService.listarTodos(); 
	    }
	
	// Cria um novo relatório.
	@PostMapping("/pi")
	public ResponseEntity<RelataModel> criar(@RequestBody RelataModel relatamodel){
		return new ResponseEntity<>(relataService.salvar(relatamodel), HttpStatus.CREATED);
	}
	

	// Retorna o relatório ou 404 se não encontrado.
    @GetMapping("/{id}")
    public ResponseEntity<RelataModel> getRelatorioById(@PathVariable Long id) {
    	RelataModel relatamodel = relataService.buscarPorId(id);
        return relatamodel != null? ResponseEntity.ok(relatamodel):(ResponseEntity.notFound().build()); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody RelataDTO relataDTO){
    	RelataModel us = repo.findById(id).get();
	    us.updateDTO(relataDTO);// Atualiza o modelo com os dados do DTO
	    repo.save(us);
	    return ResponseEntity.ok("Atualizado com sucesso");
    }

    // Deleta o relatório.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelatorio(@PathVariable Long id){ 
        relataService.deletar(id); 
        return ResponseEntity.noContent().build(); 
        // Retorna 204 No Content.
    }
    
}
