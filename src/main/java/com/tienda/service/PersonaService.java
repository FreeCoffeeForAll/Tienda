/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tienda.repository.PersonaRepository;

/**
 *
 * @author XLight
 */
@Service
public class PersonaService implements IPersonaService{
    
    //      Inyeccion de dependencias (construir conexion entre los distintos elementos entre el service y el repositorio)
    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public List<Persona> getAllpersona() {
        return (List<Persona>)personaRepository.findAll();
    }

    @Override
    public Persona getPersonaById(long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void delete(long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findByNombre(String nombre){
        return personaRepository.findByNombre(nombre);
    }    
}
