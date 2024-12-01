package br.com.odontofast.controllers;

import br.com.odontofast.models.Associado;
import br.com.odontofast.models.Status;
import br.com.odontofast.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @PostMapping
    public Associado adicionarAssociado(@RequestBody Associado associado) {
        return associadoService.salvarAssociado(associado);
    }

    @GetMapping
    public List<Associado> listarAssociados() {
        return associadoService.listarAssociados();
    }

    @GetMapping("/{id}")
    public Associado buscarAssociado(@PathVariable Long id) {
        return associadoService.buscarAssociado(id);
    }

    @PutMapping("/{id}/status")
    public Associado alterarStatusAssociado(@PathVariable Long id, @RequestParam Status status) {
        return associadoService.alterarStatusAssociado(id, status);
    }
}
