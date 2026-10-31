package entidades;

public class Categoria {

	// Essa classe será contida nas outras
	
		private String nomeCategoria;

		public Categoria() {	
		}
		
		public Categoria(String nomeCategoria) {
			this.nomeCategoria = nomeCategoria;
		}

		public String getNomeCategoria() {
			return nomeCategoria;
		}

		public String toString() {
			return getNomeCategoria().toUpperCase();
		}
		
}
