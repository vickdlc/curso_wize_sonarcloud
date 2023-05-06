/*
 * Copyright (c) 2022 Wizeline
 * All rights reserved.
 */

package com.wizeline.springboot.controlador;

import java.util.List;

import com.wizeline.springboot.entidad.EntidadPais;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wizeline.springboot.otd.OTDPais;
import com.wizeline.springboot.servicio.ServicioPais;

/**
 * @author orlando.rincon@wizeline.com
 */
@RestController
@RequestMapping("/api")
public class ControladorPais {
    private final ServicioPais servicioPais;

    public ControladorPais(ServicioPais servicioPais) {
        this.servicioPais = servicioPais;
    }

    @GetMapping("/paises")
    public List<OTDPais> obtenerTodosLosPaises() {
        return servicioPais.obtenerTodos();
    }

    @GetMapping(value = "/paises/{id}")
    public ResponseEntity<OTDPais> obtenerPorId(@PathVariable("id") Long id) {
        OTDPais OTDPais = servicioPais.obtenerPorId(id);
        if (OTDPais == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(OTDPais);
    }

    @PostMapping(value = "/paisesCrear")
    public ResponseEntity<OTDPais> crearPais(@RequestParam String nombre, @RequestParam Integer poblacion, @RequestParam Long id) {
        OTDPais pais = servicioPais.crearPais(id, nombre, poblacion);
        if (pais == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pais);
    }

    @DeleteMapping(value = "/paiseDelete/{id}")
    public ResponseEntity<String> deletePais(@PathVariable("id") Long id) {
        String result = servicioPais.deletePais(id);
        if ("error".equals(result)) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>("eliminado", HttpStatus.OK);
    }

    @PutMapping(value = "/paisesActualizar")
    public ResponseEntity<String> actualizarPais(@RequestParam String nombre, @RequestParam Integer poblacion, @RequestParam Long id) {
        String result = servicioPais.actualizarPais(id, nombre, poblacion);
        if ("error".equals(result)) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>("actualizado", HttpStatus.OK);
    }

}
