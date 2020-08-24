package py.edu.facitec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;

@Controller
public class SuscritoController {
	
	
	
	//Inyección de dependencias.
	@Autowired
	private SuscritoRepository suscritoRepository;
	
	
	@RequestMapping("/form_suscrito")
	public String metodo() {
		
		
		      //carpeta   html
		return "suscrito/index";
		
	}
	
	
	@RequestMapping(value="/registrar_suscrito", method = RequestMethod.POST)
							
	
							// nombre y correo	
							//recibe los datos del formulario
							
							
	public ModelAndView registrar(Suscrito suscrito) {
		
		
		
		//registrar un suscrito
		//jpa Hibernate   crea el sql
		
		suscritoRepository.save(suscrito);
		
		System.out.println("Registrado con éxito: "+suscrito);
		
		
		return new ModelAndView("redirect:form_suscrito");
		
	}

}
