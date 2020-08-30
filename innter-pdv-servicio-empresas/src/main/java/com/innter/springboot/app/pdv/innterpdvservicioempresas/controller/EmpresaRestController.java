package com.innter.springboot.app.pdv.innterpdvservicioempresas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.innter.springboot.app.pdv.innterpdvservicioempresas.models.entity.Empresa;
import com.innter.springboot.app.pdv.innterpdvservicioempresas.models.service.IEmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
public class EmpresaRestController {
	
	@Autowired
	private IEmpresaService empresaService;
	
	@GetMapping("/")
	public List<Empresa> getClientes(){
		return empresaService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCliente(@PathVariable(name="id") Long id) {

		
		Map<String, Object> response = new HashMap<>();
		Empresa empresa =null;
		try {
			empresa =empresaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la BD");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(empresa == null){
			response.put("mensaje", "La empresa con el id "+ id +" no existe");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> postEmpresa(@RequestBody Empresa empresa) {
		
		empresa.setIdText(String.format("EMP%05d",empresaService.getAutoIncrement()));
		Map<String, Object> response = new HashMap<>();
		Empresa newEmpresa=null;
		try {
			newEmpresa=empresaService.save(empresa);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la BD");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Empresa>(newEmpresa,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> putEmpresa(@RequestBody Empresa empresa,@PathVariable(name="id") Long id) {
		
		Map<String, Object> response = new HashMap<>();
		Empresa updateEmpresa=null;
		if(empresaService.findById(id)==null){
			response.put("mensaje", "La empresa con el id "+ id +" no existe");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			empresa.setId(id);
			updateEmpresa = empresaService.save(empresa);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la BD");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Empresa>(updateEmpresa,HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> deleteEmpresa(@PathVariable(name="id") Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			empresaService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar empresa en la BD");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La empresa con el id "+id+" fue eliminado con exito");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);	
	}
	

}
