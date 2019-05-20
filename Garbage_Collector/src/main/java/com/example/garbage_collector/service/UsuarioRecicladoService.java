package com.example.garbage_collector.service;

import java.util.List;

import com.example.garbage_collector.model.UsuarioReciclado;

public interface UsuarioRecicladoService {

	UsuarioReciclado register(UsuarioReciclado p);
	
	List<UsuarioReciclado> getAllReciclados();
	
	List<UsuarioReciclado> getAllRecicladosU(Long l);
	
	UsuarioReciclado buscarId(Long name);
	
}
