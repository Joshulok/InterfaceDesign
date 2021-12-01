package votaciones;


public class Partido {
	
	private String nombre;
	private int votos = 0;
	
	public Partido(String nombre, int votos) {
		this.nombre = nombre;
		this.votos = votos;
	}
	
	public void voto() {
		this.votos++;
	}
	
	public int getVotos() {
		return this.votos;
	}
	

}
