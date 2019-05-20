package com.example.garbage_collector.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.garbage_collector.model.Usuario;

@Repository ("repositorioUsuario")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{

	public abstract Usuario findById(Long name);
	public abstract List<Usuario> findBy();
	
}
