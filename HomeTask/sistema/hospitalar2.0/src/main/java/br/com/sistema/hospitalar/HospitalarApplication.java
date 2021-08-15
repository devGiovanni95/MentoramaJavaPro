package br.com.sistema.hospitalar;

import br.com.sistema.hospitalar.entities.PacienteEntity;
import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import br.com.sistema.hospitalar.repositories.InternacaoRepository;
import br.com.sistema.hospitalar.repositories.PacienteRepository;
import br.com.sistema.hospitalar.repositories.ProfissionalSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HospitalarApplication implements CommandLineRunner {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private ProfissionalSaudeRepository profissionalSaudeRepository;

	@Autowired
	private InternacaoRepository internacaoRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



        ProfissionalSaudeEntity ps1 = new ProfissionalSaudeEntity(null, 1000, "Marcos", "Pediatria", "Pediatria", "19999-9999");
        ProfissionalSaudeEntity ps2 = new ProfissionalSaudeEntity(null, 1024, "Gloria", "Cardiopneumologia", "Geral", "175099-888");
        ProfissionalSaudeEntity ps3 = new ProfissionalSaudeEntity(null, 1547, "Frederico", "Médico", "Geral", "193599-7777");
        ProfissionalSaudeEntity ps4 = new ProfissionalSaudeEntity(null, 1258, "Sandra", "Ortopedia e Traumatologia", "Geral", "199899-6666");
        ProfissionalSaudeEntity ps5 = new ProfissionalSaudeEntity(null, 1245, "Marcio", "Ortopedia e Traumatologia", "Ortopedista", "199479-2222");
        ProfissionalSaudeEntity ps6 = new ProfissionalSaudeEntity(null, 7895, "Ana", "Cirurgia", "Geral", "19899-1111");
        ProfissionalSaudeEntity ps7 = new ProfissionalSaudeEntity(null, 1025, "Richard", "Dermatologia", "Ambulatório Geral e Didático, Alergia", "199589-0000");

        	profissionalSaudeRepository.saveAll(Arrays.asList(ps1, ps2, ps4, ps5, ps6, ps7));

        PacienteEntity p1 = new PacienteEntity(null, "Neilton", "197845-6585", "25/07/1995");
        PacienteEntity p2 = new PacienteEntity(null, "Marcelo", "194745-6585", "07/08/1980");
        PacienteEntity p3 = new PacienteEntity(null, "Miguel", "197845-6585", "30/12/2008");
        PacienteEntity p4 = new PacienteEntity(null, "Elaine", "193645-6585", "05/05/1960");
        PacienteEntity p5 = new PacienteEntity(null, "Simone", "487845-6585", "07/07/1998");
        PacienteEntity p6 = new PacienteEntity(null, "Rian", "189045-6585", "16/11/2010");
        PacienteEntity p7 = new PacienteEntity(null, "Claudione", "191807-6585", "17/2/2003");
        PacienteEntity p8 = new PacienteEntity(null, "Rodrigo", "356284-6585", "24/01/1910");

        pacienteRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));

    }
}
