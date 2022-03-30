package com.reinaldo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.domain.Cliente;
import com.reinaldo.domain.OS;
import com.reinaldo.domain.Tecnico;
import com.reinaldo.domain.enums.Prioridade;
import com.reinaldo.domain.enums.Status;
import com.reinaldo.os.repositories.ClienteRepository;
import com.reinaldo.os.repositories.OSRepository;
import com.reinaldo.os.repositories.TecnicoRepository;

@SpringBootApplication
public class OsApplication implements CommandLineRunner{

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico t1 = new Tecnico(null, "Reinaldo Alves", "261.075.260-13", "(88) 98888-8888");
		Cliente c1 = new Cliente(null, "Betina Campos", "667.362.810-32", "(88) 98888-7777");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OD", Status.ANDAMENTO, t1, c1);
		
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
		
	}

}
