package com.innter.springboot.app.pdv.innterpdvservicioempresas.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="empresas")
public class Empresa implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", length=11, nullable=false, unique=true)
	private Long id;
    @Column(name="id_text", length=255)
	private String idText;	
    @Column(name="giro_comercial", length=255)
	private String giroComercial;
    @Column(name="nombre_razonSocial", length=255)
	private String nombreRazonSocial;
    @Column(name="codigo_sat", length=11)
	private int codigoSat;
    @Column(name="regimen", length=255)
	private String regimen;
    @Column(name="fecha_alta")
    @Temporal(TemporalType.DATE)
	private Date fechaAlta;
    @Column(name="representante", length=255)
	private String representante;
    @Column(name="cargo", length=255)
	private String cargo;
    @Column(name="rfc", length=255)
	private String rfc;
    @Column(name="curp", length=255)
	private String curp;
    @Column(name="registro_patronal", length=255)
	private String registroPatronal;
    @Column(name="tipoRiesgo", length=255)
	private String tipoRiesgo;
    @Column(name="pagina_web", length=255)
	private String paginaWeb;
    @Column(name="correo", length=255)
	private String correo;
    @Column(name="fecha_creacion")
    @Temporal(TemporalType.DATE)
	private Date fechaCreacion;
    @Column(name="creado_por", length=255)
	private String creadoPor;
    
    @PrePersist
    public void prePersist() {
    	fechaCreacion=new Date();
    }
    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getIdText() {
		return idText;
	}


	public void setIdText(String idText) {
		this.idText = idText;
	}


	public String getGiroComercial() {
		return giroComercial;
	}


	public void setGiroComercial(String giroComercial) {
		this.giroComercial = giroComercial;
	}


	public String getNombreRazonSocial() {
		return nombreRazonSocial;
	}


	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}


	public int getCodigoSat() {
		return codigoSat;
	}


	public void setCodigoSat(int codigoSat) {
		this.codigoSat = codigoSat;
	}


	public String getRegimen() {
		return regimen;
	}


	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}


	public Date getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public String getRepresentante() {
		return representante;
	}


	public void setRepresentante(String representante) {
		this.representante = representante;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getRfc() {
		return rfc;
	}


	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	public String getCurp() {
		return curp;
	}


	public void setCurp(String curp) {
		this.curp = curp;
	}


	public String getRegistroPatronal() {
		return registroPatronal;
	}


	public void setRegistroPatronal(String registroPatronal) {
		this.registroPatronal = registroPatronal;
	}


	public String getTipoRiesgo() {
		return tipoRiesgo;
	}


	public void setTipoRiesgo(String tipoRiesgo) {
		this.tipoRiesgo = tipoRiesgo;
	}


	public String getPaginaWeb() {
		return paginaWeb;
	}


	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getCreadoPor() {
		return creadoPor;
	}


	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}


	@Override
	public String toString() {
		return "Empresa [id=" + id + ", giroComercial=" + giroComercial + ", nombreRazonSocial=" + nombreRazonSocial
				+ ", codigoSat=" + codigoSat + ", regimen=" + regimen + ", fechaAlta=" + fechaAlta + ", representante="
				+ representante + ", cargo=" + cargo + ", rfc=" + rfc + ", curp=" + curp + ", registroPatronal="
				+ registroPatronal + ", tipoRiesgo=" + tipoRiesgo + ", paginaWeb=" + paginaWeb + ", correo=" + correo
				+ ", fechaCreacion=" + fechaCreacion + ", creadoPor=" + creadoPor + "]";
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
