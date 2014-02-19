package br.com.webpoc.controller;

import java.io.InputStream;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.ServletContextScope;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import br.com.webpoc.model.Person;
import br.com.webpoc.service.PersonService;
import br.com.webpoc.teste.CompileClass;
import br.com.webpoc.teste.CreateClass;
import br.com.webpoc.teste.Engine;
import br.com.webpoc.teste.InstantiateClass;

   
@Controller    
public class PersonController {  
   
	@Autowired
	private PersonService personService;
	
	@Autowired
	public CreateClass createClass;
	
	@Autowired
	public CompileClass compileClass;
	
	@Autowired
	public InstantiateClass instantiateClass;
	
	@Autowired
	public Engine engine;

    @RequestMapping(value = "/person", method = RequestMethod.GET)  
	public String getPersonList(ModelMap model) {  
        model.addAttribute("personList", personService.listPerson());  
        return "output";  
    }  
    
    @RequestMapping(value = "/person/save", method = RequestMethod.POST)  
	public View createPerson(@ModelAttribute Person person, ModelMap model) throws Exception {
    	criarClasse(person.getName());
    	if(StringUtils.hasText(person.getId())) {
    		personService.updatePerson(person);
    	} else {
    		personService.addPerson(person);
    	}
    	return new RedirectView("/web-poc/person");  
    }
        
    @RequestMapping(value = "/person/delete", method = RequestMethod.GET)  
	public View deletePerson(@ModelAttribute Person person, ModelMap model) {  
        personService.deletePerson(person);  
        return new RedirectView("/web-poc/person");  
    }   
    
	public void criarClasse(String className) throws Exception {
		createClass.create(className);
		if (compileClass.compile(className)) {
			System.out.println("Executando " + className + ":\n");
			instantiateClass.instantiate(className);
		} else{
			System.out.println(className + " não compilou.");
		}
	}
}
