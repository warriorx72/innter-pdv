package com.innter.springboot.app.pdv.innterpdvservicioempresas.models.service;

import java.util.List;

import com.innter.springboot.app.pdv.innterpdvservicioempresas.models.entity.Empresa;


public interface IEmpresaService {

	public List<Empresa> findAll();
	
	public Empresa findById(Long id);
	
	public Empresa save(Empresa empresa);
	
	public void delete(Long id);

	public Long getAutoIncrement();
}
