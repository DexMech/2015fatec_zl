package br.sceweb.model;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

public class Convenio {
	private String cnpj;
	private DateTime dataInicio;
	private DateTime dataTerminino;
	Logger logger = Logger.getLogger(Convenio.class);
	public String getCNPJ(){
		return cnpj;
	}
	/**
	 * valida a data de inicio 
	 * @param dataInicio - data do inicio da vigencia de um convenio
	 * @throws IllegalArgumentException
	 */
	public void setDataInicio(String dataInicio) throws IllegalArgumentException {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>data inicio = " + dataInicio);
		if (validaData(dataInicio)){
		        this.dataInicio = new DateTime(Integer.parseInt(dataInicio.substring(6, 10)),
			                                      Integer.parseInt(dataInicio.substring(3, 5)),
			                                      Integer.parseInt(dataInicio.substring(0, 2)), 0, 0);
		}
		else{
		       throw new IllegalArgumentException("data invalida");
		}
	}
	public String getDataInicio(){
		
		return dataInicio.toString("dd/MM/yyyy");
	}
	/**
	 * valida o formato da data
	 * @param data no formato dd/MM/yyyy
	 * @return true se a data estiver no formato valido e false para formato invalido
	 */	
	public boolean validaData(String data){
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");  
		df.setLenient (false); // 
		try {  
		    df.parse (data);  // data v�lida  
		    return true;
		} catch (ParseException ex) { 
			logger.error("Erro na validacao de data - " + ex.getMessage());			return false;
		}  
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Convenio other = (Convenio) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataTerminino == null) {
			if (other.dataTerminino != null)
				return false;
		} else if (!dataTerminino.equals(other.dataTerminino))
			return false;
		return true;
	}


}