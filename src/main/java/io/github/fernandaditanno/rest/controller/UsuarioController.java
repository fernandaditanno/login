package io.github.fernandaditanno.rest.controller;

import io.github.fernandaditanno.domain.entity.Usuario;
import io.github.fernandaditanno.domain.repository.Usuarios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
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
    public String hello(@PathVariable ("nome") String nomeUsuario){
        return String.format("Hello %s!", nomeUsuario);
    }

    @GetMapping("/obterPorId/{id}")
    public Usuario obterUsuarioPorId(@PathVariable Integer id){
        Optional<Usuario> objeto = usuarios.findAllById(id);
        if(objeto.isPresent()){
            ResponseEntity<Usuario> responseEntity = new ResponseEntity<>(objeto.get(), HttpStatus.OK);
            return objeto.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return usuarios.save(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuario(@PathVariable Integer id){
        Optional<Usuario> objeto = usuarios.findAllById(id);
        if (objeto.isPresent()){
            usuarios.delete(objeto.get());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Usuario alterarUsuario(@RequestBody Usuario usuario){
        Optional<Usuario> objeto = usuarios.findAllById(usuario.getId());

        if (objeto.isPresent()){
            Usuario edicao = usuarios.save(usuario);
            return edicao;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }

    @GetMapping()
    public List<Usuario> obterTodos(){
        List<Usuario> lista = usuarios.findAll();
        if (lista.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não possui usuarios");
        }else {
            return lista;
        }
    }
}
