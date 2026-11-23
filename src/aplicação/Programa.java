package aplicação;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entidades.Aviso;
import entidades.Categoria;
import entidades.Evento;
import entidades.SubTarefa;
import entidades.Tarefa;
import entidades.enums.StatusTarefa;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int opcao = 0;

		ArrayList<Evento> eventos = new ArrayList<>();
		ArrayList<Tarefa> tarefas = new ArrayList<>();
		ArrayList<Aviso> avisos = new ArrayList<>();
		
		
		while (opcao != 4) {

			
			mostrarProximosEventos(eventos);
			
		


					// MENU PRINCIPAL

					System.out.println();
					System.out.println("(1) EVENTOS");
					System.out.println("(2) AVISOS");
					System.out.println("(3) TAREFAS");
					System.out.println("(4) SAIR");
					System.out.println();
					System.out.print("Escolha uma opção: ");
					
					try {
					opcao = sc.nextInt();
					} catch (InputMismatchException e) {
						
							System.out.println("Opção inválida! Tente novamente. ");	
							sc.nextLine();
					}

						switch (opcao) {

						case 1:

						// MENU DE EVENTOS

						menuEventos(sc, eventos);

						
						break;


							case 2:

								// MENU DE AVISOS

								menuAvisos(sc, avisos, eventos);

								break;


								case 3:

									menuTarefas(sc, tarefas, eventos);

									break;


									case 4:

										System.out.println("Encerrando...");

										break;

										default:
											
											
											
											break;
											}
					
					
						
						
				} 
		
		sc.close();
	}
	
	
	// MOSTRAR PLANNER SEMANAL

		public static void mostrarProximosEventos(ArrayList <Evento> eventos) {

			System.out.println("======================================================");
			System.out.println("              ORGANIZADOR PESSOAL                     ");
			System.out.println("======================================================");
			
			if (eventos.isEmpty()) {
				System.out.println("\nNenhum evento cadastrado! ");
			}
				else {
					
					System.out.println("=============== MINHA AGENDA ===============");
				
	
					LocalDate hoje = LocalDate.now();
					
					boolean encontrouEvento = false;
					
						
					
						for (Evento agendaEventos: eventos) {
							
							 if (!agendaEventos.getData().isBefore(hoje)) {
							 encontrouEvento = true;
							 agendaEventos.mostrarEvento();
							 }
							 
							 
						}

						
						if (encontrouEvento == false) {
							System.out.println("Não há eventos encontrados! ");
						}
						
	       

	        System.out.println("================================================");
	        
			}
	        
		}

		



	
	
				// SUBMENU DE EVENTOS

				public static void menuEventos(Scanner sc, ArrayList <Evento> eventos) {

					int opcao = 0;
					LocalDate data = LocalDate.now();
					

						System.out.println("\n========== EVENTOS ==========");
						System.out.println();
																						 
						System.out.println("(1) VER PRÓXIMOS EVENTOS");
						System.out.println("(2) CADASTRAR EVENTO");
						System.out.println("(3) REMOVER EVENTO");
						System.out.println("(4) VOLTAR");
						

						System.out.println("===============================");
						
						
						while (opcao < 4) {
							
						System.out.print("\nEscolha uma opção: ");

						try {
						opcao = sc.nextInt();
							} catch (InputMismatchException e) {
							
							System.out.println("Opção inválida! Tente novamente. ");	
							sc.nextLine();
							}

						switch (opcao) {

						case 1:

							
							if (eventos.isEmpty() == false) {
								
								
								System.out.println();
								
								mostrarProximosEventos(eventos);
							
								
							}
						
								else {
								
								System.out.println("\nNenhum evento cadastrado! ");
								System.out.println();
								
								}
						
								
							break;

								case 2:

									// CADASTRAR EVENTO

									
									System.out.println();
									String nome;
									sc.nextLine();
									
									do {
										
										System.out.print("Nome do evento: ");
										nome = sc.nextLine();
						
										if (nome.isEmpty()) {
											System.out.println("O evento não deverá ficar sem nome.");
										}
										
									} while (nome.isEmpty()); 
										
									Boolean dataValida = false;	
									Boolean horaValida = false;	
									DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
												
												do {
											
												try {	
												System.out.print("Data: ");
												String lerData = sc.nextLine();
												
												data = LocalDate.parse(lerData, fmt);
												
													if (data.isBefore(LocalDate.now())) {
														System.out.println("Data no passado! Cadastre novamente. ");
													}
													else {
														dataValida = true;
													} 
												
											} catch (DateTimeParseException e) {
												System.out.println();
												System.out.println("Data inexistente! Tente novamente.");
											}
									
									} while (!dataValida);
									
												
												
											
											
										do {
											
											try {
												
											System.out.print("Horário: ");
											String lerHora = sc.nextLine();
									
											DateTimeFormatter fmth = DateTimeFormatter.ofPattern("h:mm a", Locale.US);
											LocalTime horario = LocalTime.parse(lerHora, fmth);
									
											eventos.add(new Evento(nome, data, horario));
											eventos.sort(Comparator.comparing(Evento::getData));
											
											System.out.println("Evento cadastrado!");
											horaValida = true;
											System.out.println();
											
											} catch (DateTimeParseException e) {
												System.out.println("Horário inválido! Tente novamente.");
											}
									
										} while (!horaValida);
											
										
									break;


									case 3:

										if (eventos.isEmpty() == false) {
											
											System.out.println("\nNome do evento que será removido: ");
											String removerEvento = sc.nextLine();
											System.out.println();
											
												boolean eventoRemovido = eventos.removeIf(listaEventos -> listaEventos.getNome().equalsIgnoreCase(removerEvento));
										
												
													if (eventoRemovido) {
														System.out.println("\nEvento removido! ");
														System.out.println();
													}
														else {
															System.out.println("\nEvento não encontrado!");
															System.out.println();
														}
										}
										
												
										
										else {
											
											System.out.println("Nenhum evento cadastrado! ");
											System.out.println();
											
										}
										
												break;


											case 4:

													if (eventos.isEmpty() == false) {
													System.out.println();
													mostrarProximosEventos(eventos);
													}
													
												break;


					default:

					System.out.println("Opção inválida!");
					System.out.println();
					
					break;
					
						}
						
				}

				
				
						
			}

		


				// SUBMENU DE AVISOS

				public static void menuAvisos(Scanner sc, ArrayList <Aviso> avisos, ArrayList <Evento> eventos) {

					int opcao = 0; 
					
					

						System.out.println("\n========== AVISOS ==========");
						System.out.println("(1) ESCREVER AVISO");
						System.out.println("(2) MOSTRAR AVISOS");
						System.out.println("(3) REMOVER AVISO");
						System.out.println("(4) VOLTAR");
						System.out.println("\n===============================");
						
						do {
							
							System.out.print("\nEscolha uma opção: ");

							try {
							opcao = sc.nextInt();
								} catch (InputMismatchException e) {
								
								System.out.println("Opção inválida! Tente novamente. ");	
								sc.nextLine();
								}


						switch (opcao) {

							case 1:

								System.out.print("Título do aviso: ");
								String titulo = sc.nextLine();
								System.out.print("Descrição: ");
								String aviso = sc.nextLine();
								
									avisos.add(new Aviso(titulo, aviso));
									
									// Ordena alfabeticamente pelo título, ignorando maiúsculas e minúsculas
									avisos.sort(Comparator.comparing(Aviso::getTitulo, String.CASE_INSENSITIVE_ORDER));
								
								break;


								case 2:

									if (avisos.isEmpty() == false) {
									
										System.out.println("\n========== AVISOS ==========");
										
										for (Aviso listaAvisos: avisos) {
											listaAvisos.mostrarAviso();
										}

									}
								
										else {
										
											
											System.out.println("\nNenhum lembrete registrado!");
										
										}
								
										System.out.println("\n=========================");	
									
								break;


										case 3:

												if (avisos.isEmpty() == false) {
										
														System.out.println("\n========== AVISOS ==========");
													
														for (Aviso listaAvisos: avisos) {
															listaAvisos.mostrarAviso();
														}
									
														System.out.println("\n=========================");	
														
														
														System.out.print("\nLembrete que será removido:  ");
														String removerAviso = sc.nextLine();
														System.out.println();
										
										boolean avisoRemovido = avisos.removeIf(listaAvisos -> listaAvisos.getTitulo().equalsIgnoreCase(removerAviso));
									
														if (avisoRemovido) {
															System.out.println("\nLembrete removido! ");
														}
														else {
															System.out.println("\nLembrete não encontrado!");
													}
										
									}
									
										else {
										
											System.out.println("\nNenhum lembrete registrado!");
											
										}
									
									break;


									case 4:

										mostrarProximosEventos(eventos);

										
										break;


				default:

					System.out.println("Opção inválida!");

				}

			} while (opcao != 4);
			
			}

		
	

				
				// SUBMENU DE TAREFAS

				public static void menuTarefas(Scanner sc, ArrayList <Tarefa> tarefas, ArrayList <Evento> eventos) {

					int opcao = 0;
					Tarefa tarefa;
					

						System.out.println("\n========== TAREFAS ==========");
						System.out.println();
						System.out.println("(1) AGENDAR TAREFA");
						System.out.println("(2) VER TAREFAS PENDENTES");
						System.out.println("(3) CONCLUIR TAREFA");
						System.out.println("(4) REMOVER TAREFA");
						System.out.println("(5) VOLTAR");
						System.out.println();
						System.out.println("===============================");
						
						
						do {
							
							System.out.print("Escolha uma opção: ");

							try {
							opcao = sc.nextInt();
								} catch (InputMismatchException e) {
								
								System.out.println("Opção inválida! Tente novamente. ");	
								sc.nextLine();
								}

					

						switch (opcao) {

							case 1:

								char adicionarData, adicionarCategoria, adicionarSubtarefas;
								LocalDate data = null;
								Categoria categoria = null;
								
								System.out.print("Nome da tarefa: ");
								String nome = sc.nextLine();
								
								System.out.print("Adicionar data? (S) (N) ");
								adicionarData = sc.next().toUpperCase().charAt(0);
								sc.nextLine();
								
										if (adicionarData == 'S') {
									
											do {
											
										
												System.out.print("Data: ");
												String lerData = sc.nextLine();
								
												DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
												data = LocalDate.parse(lerData, fmt);
										
													if (data.isBefore(LocalDate.now())) {
														System.out.println("Data inválida! ");
													}	
										
										
											} while (data.isBefore(LocalDate.now()));	
									
									} 
								
								System.out.print("Adicionar categoria? (S) (N) ");
								adicionarCategoria = sc.next().toUpperCase().charAt(0);
								sc.nextLine();
								
								
										if (adicionarCategoria == 'S') {
									
											System.out.print("Nome da categoria: ");
									
											String nomeCategoria = sc.nextLine();
								
											categoria = new Categoria(nomeCategoria);
								
										}
										
								
									ArrayList <SubTarefa> subtarefas = new ArrayList<>();
									char querContinuar;
									
									System.out.print("Adicionar subtarefas? (S) (N)  ");
									adicionarSubtarefas = sc.next().toUpperCase().charAt(0);
									sc.nextLine();
									
											if (adicionarSubtarefas == 'S') {
												
												do {
													
												System.out.print("Nome da subtarefa: ");
												String nomeSubtarefa = sc.nextLine();
												
													SubTarefa subtarefa = new SubTarefa(nomeSubtarefa);
													subtarefas.add(subtarefa);
												
												System.out.print("\nQuer continuar? (S) (N) ");
												querContinuar = sc.next().toUpperCase().charAt(0);
												sc.nextLine();
												
												
												} while (querContinuar == 'S');
												
											}
											
												

									System.out.println();
									
									
									
										if (data != null && categoria != null) {

											tarefa = new Tarefa(nome, data, categoria);

										}
											else if (data != null) {

													tarefa = new Tarefa(nome, data);

											}
												else if (categoria != null) {

														tarefa = new Tarefa(nome, categoria);

												}
													else {

															tarefa = new Tarefa(nome);

														}
												
										
										for (SubTarefa subtarefa : subtarefas) {
										    tarefa.adicionarSubtarefa(subtarefa);
										}

										tarefas.add(tarefa);
										
										// Ordena pela data, deixando tarefas sem data no final
										tarefas.sort(Comparator.comparing(Tarefa::getData,Comparator.nullsLast(Comparator.naturalOrder())));
										
										
									System.out.println("Tarefa cadastrada!");

								break;


							case 2:

							if (tarefas.isEmpty() == false) {
								
								boolean temPendente = false;
							
								for (Tarefa listaTarefas: tarefas) {
									
									
									System.out.println("\n========== TAREFAS ==========");
									
									if (listaTarefas.getStatus() == StatusTarefa.PENDENTE) {
										listaTarefas.mostrarTarefa();
										temPendente = true;
									}
									
									System.out.println("===============================");
									
								}
							
									if (temPendente == false) {
										System.out.println("Não há tarefas pendentes!");
									}
									
							}
								else {
								
									System.out.println("Nenhuma tarefa registrada! ");
								}
							
								break;


							case 3:

								if (tarefas.isEmpty() == false) {
									
								
								System.out.println();
								System.out.print("Nome da tarefa que será concluída:  ");
								String concluirTarefa = sc.nextLine();

									boolean tarefaConcluida = false;
									
										for (Tarefa lista: tarefas) {
											
											if (lista.getNome().equalsIgnoreCase(concluirTarefa)) {
												tarefaConcluida = true;
												lista.concluir();
												System.out.println("Tarefa concluída!");
											}
										
										}
										
									
									
									
										if (tarefaConcluida == false) {
										    System.out.println("\nTarefa não encontrada!");
										}
								
								
								
								} else {
										
										System.out.println("\nNenhuma tarefa registrada! ");
									}
								
								
									
								break;


							case 4:

								if (tarefas.isEmpty() == false) {
									
									System.out.println("Nome da tarefa que será removida: ");
									String removerTarefa = sc.nextLine();

									boolean tarefaRemovida = tarefas.removeIf(listaTarefas->listaTarefas.getNome().equalsIgnoreCase(removerTarefa));
									System.out.println();
									
											if (tarefaRemovida == true) {
												System.out.println("\nTarefa removida!");
											}
											else {
												System.out.println("\nTarefa não encontrada!");
												}
									
								}
								
								else {

									System.out.println("\nNenhuma tarefa registrada! ");
									
								}
								
								break;


							case 5:

								mostrarProximosEventos(eventos);	
								
								break;


				}

			} while (opcao != 5);


			}

				
	}

