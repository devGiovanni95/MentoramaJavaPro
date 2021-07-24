package br.com.sistemahospitalar.controller;

import br.com.sistemahospitalar.entities.InternacaoEntity;
import br.com.sistemahospitalar.repositories.InternacaoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/internacoes")
public class InternacaoController {

    private final InternacaoRepository internacaoRepository;

    public InternacaoController(InternacaoRepository internacaoRepository) {
        this.internacaoRepository = internacaoRepository;
    }

    @GetMapping
    public List<InternacaoEntity> findAll() {
        return this.internacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public InternacaoEntity findById(@PathVariable("id") final Long id) {
        return this.internacaoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void createNew(@RequestBody final InternacaoEntity product) {
        this.internacaoRepository.save(product);
    }

    @PutMapping
    public void update(@RequestBody final InternacaoEntity productEntity) {
        this.internacaoRepository.save(productEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id){
        this.internacaoRepository.deleteById(id);
    }
}
