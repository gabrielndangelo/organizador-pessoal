package entidades;

public class Aviso {

// Esses são os atributos da classe
	private String titulo;
	private String aviso;
	
		public Aviso(String titulo, String aviso) {
			this.titulo = titulo;
			this.aviso = aviso;
		}
	
		public String getTitulo() {
			return titulo;
		}
	
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
	
		public String getAviso() {
			return aviso;
		}
	
		public void setAviso(String aviso) {
			this.aviso = aviso;
		}
	
		public void mostrarAviso() {
			
			System.out.println();
			System.out.println("Título: " + getTitulo());
			System.out.println("Aviso: " + getAviso());
			System.out.println();
		
		}
	
}
