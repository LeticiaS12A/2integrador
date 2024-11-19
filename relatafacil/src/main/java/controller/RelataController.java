package controller;

import java.util.List;
import java.util.Optional;

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

import model.RelataModel;
import service.RelataService;

@RestController
@RequestMapping("/api")
public class RelataController {

	@Autowired
    private RelataService relataService;

	// Retorna todos os relatórios.
	@GetMapping
    public List<RelataModel> getAllReports() {
        return relataService.findAll(); 
    }

	// Retorna o relatório ou 404 se não encontrado.
    @GetMapping("/{id}")
    public ResponseEntity<RelataModel> getReportById(@PathVariable Long id) {
        Optional<RelataModel> relata = relataService.findById(id);
        return relata.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); 
    }

    // Cria um novo relatório.
    @PostMapping
    public RelataModel createReport(@RequestBody RelataModel relata) {
        return relataService.save(relata); 
    }

    // Retorna 404 se o relatório não existir.
    @PutMapping("/{id}")
    public ResponseEntity<RelataModel> updateReport(@PathVariable Long id, @RequestBody RelataModel relataDetails) {
        Optional<RelataModel> optionalReport = relataService.findById(id);
        if (!optionalReport.isPresent()) {
            return ResponseEntity.notFound().build(); 
        }
        // Atualiza o relatório existente.
        RelataModel report = optionalReport.get();
        report.setTexto(relataDetails.getNomeRelatorio());
        report.setTexto(relataDetails.getTexto());
        return ResponseEntity.ok(relataService.save(report)); 
    }

    // Deleta o relatório.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id){ 
        relataService.delete(id); 
        return ResponseEntity.noContent().build(); 
        // Retorna 204 No Content.
    }
    
}
