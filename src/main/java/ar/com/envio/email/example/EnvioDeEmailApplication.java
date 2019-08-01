package ar.com.envio.email.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.envio.email.example.dto.MailRequest;
import ar.com.envio.email.example.dto.MailResponse;
import ar.com.envio.email.example.service.EmailService;



@SpringBootApplication
@RestController
public class EnvioDeEmailApplication {

	@Autowired
	private EmailService service;

	
	public static void main(String[] args) {
		SpringApplication.run(EnvioDeEmailApplication.class, args);
	}

	
	@PostMapping("/enviarEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "Bangalore,India");
		return service.sendEmail(request, model);

	}
}
