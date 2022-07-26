/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;
import com.tienda.entity.Persona;
import java.util.List;

/**
 *
 * @author XLight
 */
public interface IPersonaService {
    public List<Persona> getAllpersona();
    public Persona getPersonaById (long id);
    public void savePersona (Persona persona);
    public void delete (long id);
    public Persona findByNombre (String nombre);
}
