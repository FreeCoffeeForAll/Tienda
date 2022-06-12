/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Persona;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author XLight
 */
@Controller
public class PersonaController {
    @Autowired
    private IPersonaService personaService;
    
    //          este GetMapping vendria siendo el URL. Ejemplo: localhost/persona
    @GetMapping("/persona")
    
    //          Model nos permite pasar informacion al HTML
    public String index (Model model){
        List<Persona> listaPersona = personaService.getAllpersona();
        model.addAttribute("titulo","Tabla Personas");
        model.addAttribute("personas",listaPersona);
        return "personas";
    }    
}