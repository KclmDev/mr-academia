package com.kayky.mracademia.Controller;

import com.kayky.mracademia.Model.Usuario;
import com.kayky.mracademia.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // GET: listar todos
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodosUsuarios());
    }
    // GET: buscar por id
    @GetMapping("/{id}")
    public ResponseEntity <Usuario> buscarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // POST: criar usuario
    @PostMapping
    public ResponseEntity <Usuario> criar (@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity <Usuario> login (@RequestBody Usuario usuario){
        Usuario loginUsuario = usuarioService.autenticarUsuario(usuario.getEmail(), usuario.getSenha());
        return ResponseEntity.status(HttpStatus.CREATED).body(loginUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
