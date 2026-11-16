package com.kayky.mracademia.Service;

import com.kayky.mracademia.Model.Usuario;
import com.kayky.mracademia.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário nao encontrado" + id));
    }

    public Usuario buscarPorEmail(String email) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.orElseThrow(() -> new RuntimeException("Usuário nao encontrado" + email));
    }

    public Usuario salvar(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("Esse email já está cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticarUsuario(String email, String senha) {
        Usuario x = buscarPorEmail(email);
        if (senha.equals(x.getSenha())) {
            return x;
        } else {
            throw new RuntimeException("Senha incorreta");
        }
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

}
