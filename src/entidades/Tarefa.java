package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import entidades.enums.StatusTarefa;

public class Tarefa {

// Esses são os atributos da classe
	private String nome;
	private LocalDate data;
	private Categoria categoria;
	private StatusTarefa status = StatusTarefa.PENDENTE;
	private ArrayList<SubTarefa> subtarefas;
	
	/*
	 * CONSTRUTOR
	 *
	 * A data pode ser null se o usuário não quiser agendar
	 * a tarefa para um dia específico.
	 *
	 * A categoria também pode ser null.
	 *
	 * Toda tarefa começa como pendente, por isso concluida
	 * recebe false inicialmente.
	 */
	
			public Tarefa(String nome) {
				this.nome = nome;
				this.subtarefas = new ArrayList<>();
			}
			
			public Tarefa(String nome, LocalDate data) {
				this.nome = nome;
				this.data = data;
				this.subtarefas = new ArrayList<>();
			}
			
			public Tarefa(String nome, LocalDate data, Categoria categoria) {
				this.nome = nome;
				this.data = data;
				this.categoria = categoria;
				this.subtarefas = new ArrayList<>();
			}

			public Tarefa(String nome, Categoria categoria) {
				this.nome = nome;
				this.categoria = categoria;
				this.subtarefas = new ArrayList<>();
			}
			
			public String getNome() {
				return nome;
			}
	
			public LocalDate getData() {
				return data;
			}
	
			public Categoria getCategoria() {
				return categoria;
			}
	
			public StatusTarefa getStatus() {
				return status;
			}

			public void concluir() {
				this.status = StatusTarefa.CONCLUÍDA;
			}

			public void adicionarSubtarefa(SubTarefa subtarefa) {
			    subtarefas.add(subtarefa);
			}
			
			public ArrayList<SubTarefa> getSubTarefas() {
				return subtarefas;
			}
			
		/*
		 * Se houver uma data, ela será formatada como dd/MM/uuuu.
		 *
		 * Se data for null, não tentaremos chamar format() sobre
		 * um objeto inexistente. Por isso, verificamos a condição
		 * antes de formatar.
		 */

		public void mostrarTarefa() {

			System.out.println();
			System.out.println("Tarefa: " + getNome());
			
			
								if (!subtarefas.isEmpty()) {
						
								System.out.println("\n    Subtarefas:");

									for (SubTarefa subtarefa : subtarefas) {
									System.out.println("        - " + subtarefa.getNomeSubtarefa());
									}
									
									System.out.println();
									
								}
			
							
							
				if (data != null) {
					System.out.println("Data: " + data.format(DateTimeFormatter.ofPattern("dd/MM/uuuu")));
				}
			
				if (categoria != null) {
					System.out.println("Categoria: " + categoria.getNomeCategoria());
				}
				
			System.out.println("Status: " + getStatus());
			System.out.println();
			
		}

}
