package com.example.ApiG25.Controladores;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ApiG25.Modelos.UsuarioModelo;
import com.example.ApiG25.Servicios.UsuarioServicio;

@RestController
//http://localhost:8080/usuario:
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio servicio;
    //http://localhost:8080/usuario/guardar
    @PostMapping("/guardar")
    public UsuarioModelo guardaUsuario(@RequestBody UsuarioModelo usuario){
        return servicio.guardarUsuario(usuario);
    }

    //http://localhost:8080/usuario/consultar
    @GetMapping("/consultar")
    public ArrayList<UsuarioModelo> consultarUsario(){
        return servicio.consultarUsarios();
    }

    //http://localhost:8080/usuario/consultarporId/
    @GetMapping("/consultardocumento/{documento}")
    public Optional<UsuarioModelo> consultaDocumento(@PathVariable("documento") Long documento){
        return servicio.buscarPorDocumento(documento);
    }

    //http://localhost:8080/usuario/eliminar
    @DeleteMapping("eliminar/{documento}")
    public Boolean eliminar(@PathVariable("documento") Long documento){
        return servicio.eliminaUsuario(documento);
    }

    //http://localhost:8080/usuario/buscarxapellido/ramirez
    @GetMapping("/buscarxapellido/{apellido}")
    public ArrayList<UsuarioModelo> buscaXapllido(@PathVariable("apellido") String apellido){
        return servicio.buscarXapellido(apellido); 
    }

    //http://localhost:8080/usuario/buscarxnombre/Jonatan
    @GetMapping("/buscarxnombre/{nombre}")
    public ArrayList<UsuarioModelo> buscaXnombre(@PathVariable("nombre") String nombre){
        return servicio.buscarXnombre(nombre); 
    }

    //http://localhost:8080/usuario/buscarxcorreo/Jonatan@gmail.com
    @GetMapping("/buscarxcorreo/{correo}")
    public ArrayList<UsuarioModelo> buscaXcorreo(@PathVariable("correo") String correo){
        return servicio.buscarXcorreo(correo); 
    }

    
}
