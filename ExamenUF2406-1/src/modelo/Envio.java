package modelo;

import java.util.Objects;

public class Envio {
	
	private String ciudadOrigen;
	private boolean origenNacional;
	private String ciudadDestino;
	private boolean destinoNacional;
	private String tipoEnvio;
	private int peso;
	
	//constructor sin parámetros
	public Envio() {
		this.ciudadOrigen ="";
		this.origenNacional =true;
		this.ciudadDestino = "";
		this.destinoNacional = true;
		this.tipoEnvio = "";
		this.peso = 1;
		
		
	}
	//constructor con parámetros
	public Envio(String ciudadOrigen, boolean origenNacional, String ciudadDestino, boolean destinoNacional,
			String tipoEnvio, int peso) {
		
		this.ciudadOrigen = ciudadOrigen;
		this.origenNacional = origenNacional;
		this.ciudadDestino = ciudadDestino;
		this.destinoNacional = destinoNacional;
		this.tipoEnvio = tipoEnvio;
		this.peso = peso;
	}
	
	//getters y setters
	public String getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	public boolean isOrigenNacional() {
		return origenNacional;
	}
	public void setOrigenNacional(boolean origenNacional) {
		this.origenNacional = origenNacional;
	}
	public String getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	public boolean isDestinoNacional() {
		return destinoNacional;
	}
	public void setDestinoNacional(boolean destinoNacional) {
		this.destinoNacional = destinoNacional;
	}
	public String getTipoEnvio() {
		return tipoEnvio;
	}
	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	// hshCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(ciudadDestino, ciudadOrigen, destinoNacional, origenNacional, peso, tipoEnvio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Envio other = (Envio) obj;
		return Objects.equals(ciudadDestino, other.ciudadDestino) && Objects.equals(ciudadOrigen, other.ciudadOrigen)
				&& destinoNacional == other.destinoNacional && origenNacional == other.origenNacional
				&& peso == other.peso && Objects.equals(tipoEnvio, other.tipoEnvio);
	}
	// tosString
	@Override
	public String toString() {
		return "Envio [ciudadOrigen=" + ciudadOrigen + ", origenNacional=" + origenNacional + ", ciudadDestino="
				+ ciudadDestino + ", destinoNacional=" + destinoNacional + ", tipoEnvio=" + tipoEnvio + ", peso=" + peso
				+ "]";
	}
	
	public double calculaImporte() {
		
		double precio = 7;
		double recargoPeso = 3.5;
		
		if(this.origenNacional && this.destinoNacional) {
			precio = 4;
		
		}
		if(tipoEnvio.equals("Paq 10 - Antes de las 10 h")) {
			precio = precio +5;
		}else if(tipoEnvio.equals("Paq 14 - Antes de las 14 h")) {
			precio =precio +2;
			
		}
		precio = precio + peso/10 * recargoPeso;
		return precio;

	}
	
	
	
	
	
	
	




}
