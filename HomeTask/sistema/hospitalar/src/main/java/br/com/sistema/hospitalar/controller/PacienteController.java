package br.com.sistema.hospitalar.controller;

import br.com.sistema.hospitalar.entities.PacienteEntity;
import br.com.sistema.hospitalar.repositories.PacienteRepository;
import br.com.sistema.hospitalar.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {


    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteRepository pacienteRepository;

    /*Funcionando*/
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> listar(@PathVariable Long id) {
        PacienteEntity obj = pacienteService.busca(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    @RequestMapping
    public List<PacienteEntity> findAll() {
        return  this.pacienteService.findAll();
//        return ResponseEntity.ok().body(obj);
    }



//
//    @GetMapping
//    @RequestMapping
//    public ResponseEntity<?> FindAll() {
//        List<PacienteEntity> obj = pacienteService.findAll();
//        return ResponseEntity.ok().body(obj);
//    }

//    @GetMapping("{id}")
//    @RequestMapping
//    public List<PacienteEntity> findById(@PathVariable("id") final Long id) {
//      return this.pacienteRepository.findById(id);
//    }
//
//    @GetMapping
//    @RequestMapping
//    public List<PacienteEntity> findAll() {
//        return this.pacienteRepository.findAll().
//                stream().map(PacienteEntity).collect(Collectors.toList());
////                List<PacienteEntity> obj = pacienteRepository.findAll();
//
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id) {
        this.pacienteRepository.deleteById(id);
    }

//
//    @Autowired
//    private final PacienteRepository pacienteRepository;
//
//
//    public PacienteController(PacienteRepository pacienteRepository) {
//        this.pacienteRepository = pacienteRepository;
//    }
//
//    @GetMapping
//    public List<PacienteEntity> findAll(){
//        return this.pacienteRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public PacienteEntity findyById(@PathVariable("id") final  Long id){
//        return this.pacienteRepository.findById(id).orElse(null);
//    }
//
//    @PostMapping
//    public void createNew(@RequestBody final PacienteEntity paciente){
//        this.pacienteRepository.save(paciente);
//    }
//
//    @PutMapping
//    public void update(@RequestBody final PacienteEntity pacienteEntity){
//        this.pacienteRepository.save(pacienteEntity);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") final Long id){
//        this.pacienteRepository.deleteById(id);
//    }


}
