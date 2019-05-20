package com.example.garbage_collector.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.garbage_collector.model.UsuarioReciclado;

@Repository ("repositorioReciclado")
public interface UsuarioRecicladoRepository extends JpaRepository<UsuarioReciclado, Serializable> {
//Encargado de comunicarse con la base de datos
	
	public abstract UsuarioReciclado findById(Long name);
	public abstract List<UsuarioReciclado> findBy();
	
}
