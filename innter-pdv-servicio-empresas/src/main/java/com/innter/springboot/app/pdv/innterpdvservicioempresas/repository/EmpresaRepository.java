package com.innter.springboot.app.pdv.innterpdvservicioempresas.repository;

import com.innter.springboot.app.pdv.innterpdvservicioempresas.models.entity.Empresa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpresaRepository extends CrudRepository<Empresa,Long>{
    @Query(value = "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE table_name='empresas' AND table_schema=DATABASE ();",
    nativeQuery = true)
    public Long getAutoIncrement();
}
