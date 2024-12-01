package br.com.odontofast.controllers;

import br.com.odontofast.models.Recepcionista;
import br.com.odontofast.models.Status;
import br.com.odontofast.service.RecepcionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class RecepcionistaController {

    @Autowired
    private RecepcionistaService recepcionistaService;

    // Endpoint para adicionar um novo recepcionista
    @PostMapping
    public Recepcionista adicionarFuncionario(@RequestBody Recepcionista recepcionista) {
        return recepcionistaService.salvarFuncionario(recepcionista);  // Salva o recepcionista
    }

    // Endpoint para listar todos os recepcionistas
    @GetMapping
    public List<Recepcionista> listarFuncionarios() {
        return recepcionistaService.listarFuncionarios();  // Lista todos os recepcionistas
    }

    // Endpoint para buscar um recepcionista pelo ID
    @GetMapping("/{id}")
    public Recepcionista buscarFuncionario(@PathVariable Long id) {
        return recepcionistaService.buscarFuncionario(id);  // Busca um recepcionista pelo ID
    }

    // Endpoint para alterar o status de um recepcionista
    @PutMapping("/{id}/status")
    public Recepcionista alterarStatusFuncionario(@PathVariable Long id, @RequestParam Status status) {
        return recepcionistaService.alterarStatusFuncionario(id, status);  // Altera o status do recepcionista
    }
}
