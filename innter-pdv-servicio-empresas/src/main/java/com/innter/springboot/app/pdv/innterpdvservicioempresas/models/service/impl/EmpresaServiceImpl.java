package com.innter.springboot.app.pdv.innterpdvservicioempresas.models.service.impl;

import java.util.List;

import com.innter.springboot.app.pdv.innterpdvservicioempresas.models.entity.Empresa;
import com.innter.springboot.app.pdv.innterpdvservicioempresas.models.service.IEmpresaService;
import com.innter.springboot.app.pdv.innterpdvservicioempresas.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

	@Autowired
	EmpresaRepository repository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return (List<Empresa>) repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Empresa findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empresa save(Empresa empresa) {
		// TODO Auto-generated method stub
		return repository.save(empresa);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Long getAutoIncrement() {
		// TODO Auto-generated method stub
		return repository.getAutoIncrement();
	}

	
}
