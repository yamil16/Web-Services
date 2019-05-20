package com.example.garbage_collector.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.garbage_collector.model.TotalMaterial;
import com.example.garbage_collector.model.TotalReciclado;
import com.example.garbage_collector.model.Usuario;
import com.example.garbage_collector.model.UsuarioReciclado;
import com.example.garbage_collector.service.UsuarioRecicladoService;
import com.example.garbage_collector.service.UsuarioService;

@RestController
public class GarbageCollectorController {

	@Autowired
	UsuarioService us;
	
	@Autowired
	UsuarioRecicladoService rs;
	
	//Servicio 1 Registra un usuario. (1)
	@PostMapping(path = "/api/usuario")
	public ResponseEntity<Usuario> registerPersona(@RequestBody Usuario u){
		Usuario newP = us.register(u);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newP.getId())
				.toUri();
		return ResponseEntity.created(location).body(newP);
	}
	
	// Lista de los usuarios. (2)
	@GetMapping(path = "/api/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios( ){
		List<Usuario> list = us.getAllUsuario();
		return ResponseEntity.ok(list);
	}
	
	// Segun un ID me da un usuario. (3)
	@GetMapping(path = "/api/usuario/{name}/")
	public ResponseEntity<Usuario> getUsuario(@PathVariable(value = "name")Long name){
		Usuario p = us.findByName(name);
		return ResponseEntity.ok(p);
	}
	
	//Servicio 2 Agregar un reciclaje a un usuario. (4)
	@PostMapping(path = "/api/reciclado")
	public ResponseEntity<UsuarioReciclado> registerRegistrado(@RequestBody UsuarioReciclado r){
		Usuario p = us.findByName(r.getId_r());
		r.setUsuario(p);
		UsuarioReciclado newP = rs.register(r);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newP.getId())
				.toUri();
		return ResponseEntity.created(location).body(newP);
	}
	
	// Dame todos los reciclados. (5)
	@GetMapping(path = "/api/reciclados")
	public ResponseEntity<List<UsuarioReciclado>> getUsuarioReciclados( ){
		List<UsuarioReciclado> list = rs.getAllReciclados();
		return ResponseEntity.ok(list);
	}
	
	// Dado un ID me da todos los reciclados. (6)
	@GetMapping(path = "/api/reciclados/{name}/")
	public ResponseEntity<List<UsuarioReciclado>> getRecicladoU(@PathVariable(value = "name")Long name){
		List<UsuarioReciclado> list = rs.getAllRecicladosU(name);
		return ResponseEntity.ok(list);
	}
	
	
	// Servicio 3 Obtener todos los reciclajes de un usuario y se van sumando. (7)
	@GetMapping(path = "/api/reciclado/{name}/")
	public ResponseEntity<TotalMaterial> getTotalUserRecycling(@PathVariable(value = "name") Long name){
		List<UsuarioReciclado> list = rs.getAllRecicladosU(name);
		TotalMaterial totalMaterial = new TotalMaterial();
		int bottles = 0, tetrabriks = 0, glass = 0, paperboard = 0, cans = 0;
		if (list.size() != 0) {
			for(int i = 0; i < list.size(); i++) {
				bottles += list.get(i).getBottles();
				tetrabriks += list.get(i).getTetrabriks();
				glass += list.get(i).getGlass();
				paperboard += list.get(i).getPaperboard();
				cans += list.get(i).getCans();
			}
			
			totalMaterial.setName(rs.buscarId(name).getUsuario().getUsername());
			totalMaterial.setBottles(bottles);
			totalMaterial.setCans(cans);
			totalMaterial.setGlass(glass);
			totalMaterial.setPaperboard(paperboard);
			totalMaterial.setTetrabriks(tetrabriks);
		}
		return ResponseEntity.ok(totalMaterial);
	}
	
	//Servicio 4 Obtener el total reciclado. (8)
	@GetMapping(path = "/api/reciclado/")
	public ResponseEntity<TotalReciclado> getTotal(){
		List<UsuarioReciclado> list = rs.getAllReciclados();
		TotalReciclado totalReciclado = new TotalReciclado();
		int bottles = 0, tetrabriks = 0, glass = 0, paperboard = 0, cans = 0;
		int total = 0;
		for(int i = 0; i < list.size(); i++) {
			bottles += list.get(i).getBottles();
			tetrabriks += list.get(i).getTetrabriks();
			glass += list.get(i).getGlass();
			paperboard += list.get(i).getPaperboard();
			cans += list.get(i).getCans();
		}
		
		total = bottles + tetrabriks + glass + paperboard + cans; 
		
		totalReciclado.setName("Reciclado de todos los usuarios");
		totalReciclado.setBottles(bottles);
		totalReciclado.setCans(cans);
		totalReciclado.setGlass(glass);
		totalReciclado.setPaperboard(paperboard);
		totalReciclado.setTetrabriks(tetrabriks);
		totalReciclado.setToneladas(total);
		return ResponseEntity.ok(totalReciclado);
	}
}
