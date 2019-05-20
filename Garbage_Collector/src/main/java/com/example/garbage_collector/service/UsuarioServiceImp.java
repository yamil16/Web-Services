package com.example.garbage_collector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.garbage_collector.model.Usuario;
import com.example.garbage_collector.repository.UsuarioRepository;
@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	@Qualifier("repositorioUsuario")
	UsuarioRepository ur;

	@Override
	public Usuario register(Usuario u) {
		return ur.save(u);
	}

	@Override
	public Usuario findByName(Long name) {
		return ur.findById(name);
	}

	@Override
	public List<Usuario> getAllUsuario() {
		return ur.findBy();
	}
	
}
