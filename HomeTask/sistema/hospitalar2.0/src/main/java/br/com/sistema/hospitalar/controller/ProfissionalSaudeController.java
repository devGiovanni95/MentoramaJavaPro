package br.com.sistema.hospitalar.controller;

import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import br.com.sistema.hospitalar.repositories.ProfissionalSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profissionalSaude")
public class ProfissionalSaudeController {

    @Autowired
    private  ProfissionalSaudeRepository profissionalSaudeRepository;

//    public ProfissionalSaudeController(ProfissionalSaudeRepository profissionalSaudeRepository) {
//        this.profissionalSaudeRepository = profissionalSaudeRepository;
//    }

    @GetMapping
    public List<ProfissionalSaudeEntity> findAll(){
        return this.profissionalSaudeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProfissionalSaudeEntity findyById(@PathVariable("id") final  Long id){
        return this.profissionalSaudeRepository.findById(id).orElse(null);
    }

    @GetMapping("/{quantidadePorDepartamento}")
    public Object findByNumberMedicByDepartament(@PathVariable("quantidadePorDepartamento") final  String departament){
        return this.profissionalSaudeRepository.findByNumberMedicByDepartament(departament);
    }

    @PostMapping
    public void createNew(@RequestBody final ProfissionalSaudeEntity profissional){
        this.profissionalSaudeRepository.save(profissional);
    }

    @PutMapping
    public void update(@RequestBody final ProfissionalSaudeEntity profissionalSaudeEntity){
        this.profissionalSaudeRepository.save(profissionalSaudeEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id){
        this.profissionalSaudeRepository.deleteById(id);
    }

}
