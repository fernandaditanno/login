package io.github.fernandaditanno.rest.controller;

import io.github.fernandaditanno.domain.entity.Usuario;
import io.github.fernandaditanno.domain.repository.Usuarios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("api/usuarios")
public class UsuarioController {

    private Usuarios usuarios;

    public UsuarioController(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @RequestMapping(
            value = "/hello/{nome}",
            method = RequestMethod.GET
    )
    @ResponseBody
    public String hello(@PathVariable ("nome") String nomeUsuario){
        return String.format("Hello %s!", nomeUsuario);
    }

    @GetMapping("/obterPorId/{id}")
    @ResponseBody
    public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable Integer id){
        Optional<Usuario> objeto = usuarios.findAllById(id);
        if(objeto.isPresent()){
            ResponseEntity<Usuario> responseEntity = new ResponseEntity<>(objeto.get(), HttpStatus.OK);
            return ResponseEntity.ok(objeto.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
        Usuario objeto = usuarios.save(usuario);
        return ResponseEntity.ok(objeto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity deleteUsuario(@PathVariable Integer id){
        Optional<Usuario> objeto = usuarios.findAllById(id);
        if (objeto.isPresent()){
            usuarios.delete(objeto.get());
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping()
    @ResponseBody
    public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario){
        Optional<Usuario> objeto = usuarios.findAllById(usuario.getId());

        if (objeto.isPresent()){
            Usuario edicao = usuarios.save(usuario);
            return ResponseEntity.ok(edicao);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
