package com.ForoHub.Controlador;

import com.ForoHub.DatosJWTToken.DatosJWTToken;
import com.ForoHub.Modelo.Usuario;
import com.ForoHub.Seguridad.DatosAutenticacionUsuario;
import com.ForoHub.Seguridad.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid DatosAutenticacionUsuario datos) {
        var authToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.clave());
        var authentication = authenticationManager.authenticate(authToken);

        var usuario = (Usuario) authentication.getPrincipal(); // cast si es necesario
        var jwtToken = tokenService.generarToken(usuario.getLogin()); // <-- CORRECTO

        return ResponseEntity.ok(new DatosJWTToken(jwtToken));
    }

}
