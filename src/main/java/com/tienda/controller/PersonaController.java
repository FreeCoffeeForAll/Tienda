/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.IPaisService;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author XLight
 */
@Controller
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IPaisService paisService;

    //          este GetMapping vendria siendo el URL. Ejemplo: localhost/persona
    @GetMapping("/persona")

    //          Model nos permite leer la informacion de la base de datos y mostrarla al HTML
    public String index(Model model) {
        List<Persona> listaPersona = personaService.getAllpersona();
        model.addAttribute("titulo", "Tabla Personas");
        model.addAttribute("personas", listaPersona);
        return "personas";
    }

    //          este GetMapping vendria siendo el URL. Ejemplo: localhost/personaN
    @GetMapping("/personaN")

    //          Model nos permite crear nuevos objetos tipo persona y almacenarlos en la base de datos
    public String crearPersona(Model model) {
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", listaPaises);
        return "crear";
    }

    //          este PostMapping vendria siendo el URL para insert los datos a MySQL
    @PostMapping("/save")

    //          Model nos permite guardar  nuevos objetos tipo persona y almacenarlos en la base de datos
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaService.savePersona(persona);
        return "redirect:/persona";
    }

    //          este GetMapping vendria siendo el URL para retornar la informacion de la base de datos
    @GetMapping("/editPersona/{id}")

    //          Model nos permite editar objetos tipo persona y actualizarlo en la base de datos
    public String editarPersona(@PathVariable("id") Long idPersona, Model model) {
        Persona persona = personaService.getPersonaById(idPersona);
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", persona);
        model.addAttribute("paises", listaPaises);
        return "crear";
    }

    //          este GetMapping vendria siendo el URL para eliminar la informacion de la base de datos
    @GetMapping("/delete/{id}")

    //          Model nos permite eliminar objetos tipo persona en la base de datos
    public String eliminarPersona(@PathVariable("id") Long idPersona) {
        personaService.delete(idPersona);
        return "redirect:/persona";
    }
}
