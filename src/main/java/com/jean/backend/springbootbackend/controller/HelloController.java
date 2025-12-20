package com.jean.backend.springbootbackend.controller;
import com.jean.backend.springbootbackend.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //instancia de la clase
    private final HelloService helloservice;

    public HelloController(HelloService helloservice){
        this.helloservice = helloservice;
    }
    
    @GetMapping("/hello")
	public String hello (@RequestParam(defaultValue = "world") String name)
	{ 
		return helloservice.saludar(name);
	}

}
