package entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Evento {

// Esses são os atributos da classe
	private String nome;
	private LocalDate data;
	private LocalTime horario;
	private String local;
	private Categoria categoria;

	
	/*
	 * CONSTRUTOR
	 *
	 * Recebe os dados necessários para criar um evento.
	 *
	 * LocalDate representa uma data sem horário, por exemplo:
	 * 02/11/2026.
	 *
	 * LocalTime representa somente o horário, por exemplo:
	 * 19:00, que será exibido como 7:00 PM.
	 *
	 * O local e a categoria podem ser null quando o usuário
	 * responder que não deseja informar esses dados.
	 */
	
			public Evento(String nome, LocalDate data, LocalTime horario) {
				this.nome = nome;
				this.data = data;
				this.horario = horario;
			}
	
			// Esse construtor receberá os parâmetros se o usuário no programa principal mencionar o local e a categoria
			
			public Evento(String nome, LocalDate data, LocalTime horario, String local, Categoria categoria) {
				this.nome = nome;
				this.data = data;
				this.horario = horario;
				this.local = local;
				this.categoria = categoria;
			}
	
			public String getNome() {
				return nome;
			}
	
			public LocalDate getData() {
				return data;
			}
	
	
			public LocalTime getHorario() {
				return horario;
			}
	
			public void setHorario(LocalTime horario) {
				this.horario = horario;
			}
	
			public String getLocal() {
				return local;
			}
	
	
			public Categoria getCategoria() {
				return categoria;
			}
	
	
			/*
			 * FORMATAÇÃO DA DATA
			 *
			 * O objeto LocalDate guarda a data de maneira própria
			 * do Java. Ele não guarda a data como uma String.
			 *
			 * DateTimeFormatter define como queremos EXIBIR essa data.
			 *
			 * dd/MM/uuuu significa:
			 * dd   = dia com dois algarismos;
			 * MM   = mês com dois algarismos;
			 * uuuu = ano com quatro algarismos.
			 *
			 * Por exemplo, uma data armazenada como 2026-11-02
			 * será exibida como 02/11/2026.
			 *
			 * O formato de exibição não muda a data armazenada.
			 */


			/*
			 * FORMATAÇÃO DO HORÁRIO
			 *
			 * LocalTime armazena o horário usando o padrão de 24 horas.
			 * Por exemplo, 19:00 representa sete horas da noite.
			 *
			 * O formato "h:mm a" significa:
			 * h   = hora no formato de 12 horas;
			 * mm  = minutos com dois algarismos;
			 * a   = indicador AM ou PM.
			 *
			 * Assim, 19:00 será apresentado como 7:00 PM.
			 *
			 * O Locale.US é usado aqui para garantir que o indicador
			 * seja AM ou PM, independentemente do idioma do computador.
			 */

	

			public void mostrarEvento() {

				DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
				
				DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("h:mm a", Locale.US);
				
				System.out.println();
				System.out.println(getNome().toUpperCase());
				System.out.println("Data: " + data.format(formatoData));
				System.out.println("Horário: " + horario.format(formatoHora));

						if (local != null) {
							System.out.println("Local: " + getLocal());
						}

						if (categoria != null) {
							System.out.println("Categoria: " + categoria.getNomeCategoria());
						}
 
						
				System.out.println();
				
			}

}