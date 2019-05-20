package com.example.garbage_collector.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.garbage_collector.model.UsuarioReciclado;
import com.example.garbage_collector.repository.UsuarioRecicladoRepository;

@Service
public class UsuarioRecicladoServiceImp implements UsuarioRecicladoService{
// @Autowired digo que voy a injectar y @Quailifier le indico que injecto
	
	@Autowired
	@Qualifier("repositorioReciclado")
	UsuarioRecicladoRepository rr;
	
	@Override
	public UsuarioReciclado register(UsuarioReciclado ur) {
		return rr.save(ur);
	}

	@Override
	public List<UsuarioReciclado> getAllReciclados() {
		return rr.findBy();
	}

	@Override
	public List<UsuarioReciclado> getAllRecicladosU(Long l) {
		List<UsuarioReciclado> lista = this.getAllReciclados();
		List<UsuarioReciclado> listau = new ArrayList<UsuarioReciclado>();
		for(int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId_r() == l) {
				listau.add(lista.get(i));
			}
		}
		return listau;
	}

	@Override
	public UsuarioReciclado buscarId(Long name) {
		return rr.findById(name);

	}
	
}
