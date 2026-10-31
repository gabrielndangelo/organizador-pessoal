

# Organizador Pessoal

Um organizador pessoal desenvolvido em Java, com o objetivo de centralizar compromissos, avisos e tarefas em uma única aplicação de terminal.

O projeto surgiu de uma necessidade cotidiana: organizar atividades que normalmente ficam distribuídas entre o Google Tarefas, Google Calendar e anotações físicas em um planner. A proposta é transformar essa experiência em uma aplicação própria, utilizando os conceitos de programação e orientação a objetos estudados durante minha formação em Java.


## 1. Origem e proposta

A ideia inicial foi criar uma ferramenta simples para reunir três necessidades da organização pessoal:

- **Eventos:** registrar compromissos com data e horário.
- **Avisos:** guardar informações e lembretes que precisam permanecer acessíveis.
- **Tarefas:** organizar atividades, acompanhar seu andamento e dividi-las em subtarefas.

O desenvolvimento começou com um planejamento das funcionalidades, dos menus e das classes necessárias para representar cada elemento do sistema.

Uma das preocupações desde o início foi manter uma estrutura organizada, separando a lógica de navegação das entidades responsáveis por representar os dados.


## 2. Desenvolvimento

A implementação foi realizada gradualmente, utilizando os fundamentos de Java e Programação Orientada a Objetos.

A aplicação possui um menu principal que permite acessar os três módulos independentes: Eventos, Avisos e Tarefas.

Durante o desenvolvimento, foram utilizados conceitos como:

- Classes, atributos e métodos;
- Encapsulamento e construtores;
- Enumerações (`enum`);
- Listas dinâmicas com `ArrayList`;
- Manipulação e remoção de elementos;
- Ordenação de coleções com `Comparator`;
- Expressões lambda;
- Manipulação de datas e horários com a API `java.time`;
- Estruturas condicionais e de repetição;
- Modularização por meio de métodos.


## 3. Funcionalidades da versão 1.0

### Eventos
- Cadastro de eventos ou compromissos com nome, data e horário.
- Adição opcional de categoria.
- Consulta dos próximos eventos.
- Identificação e negação de eventos com datas anteriores à data atual.
- Remoção de eventos pelo nome, ignorando diferenças entre letras maiúsculas e minúsculas.
- Ordenação dos eventos por data.
- Exibição dos horários no formato de 12 horas (AM/PM).

### Avisos
- Cadastro de avisos com título e descrição.
- Consulta dos avisos registrados.
- Ordenação alfabética pelo título.
- Remoção de avisos pelo título, sem distinção entre letras maiúsculas e minúsculas.

### Tarefas
- Cadastro de tarefas com nome.
- Adição opcional de data e categoria.
- Criação de subtarefas vinculadas a uma tarefa principal.
- Identificação do estado da tarefa por meio de enumeração (`StatusTarefa`).
- Consulta exclusiva das tarefas pendentes.
- Conclusão de tarefas sem a necessidade de removê-las manualmente da lista.
- Remoção de tarefas pelo nome.
- Ordenação por data, mantendo tarefas sem data ao final da lista.

## 4. Tecnologias e recursos utilizados

| Tecnologia / Recurso | Aplicação no projeto |
|---|---|
| Java | Linguagem principal |
| Programação Orientada a Objetos | Organização das classes e responsabilidades |
| ArrayList | Armazenamento e manipulação dos registros |
| Java Time API | Tratamento de datas e horários |
| Comparator | Ordenação de eventos, avisos e tarefas |
| Enum | Representação dos estados das tarefas |
| Scanner | Entrada de dados pelo usuário |
| Eclipse IDE | Ambiente de desenvolvimento |

## 5. Escopo da versão 1.0

Esta primeira versão concentra-se no funcionamento básico dos módulos e na manipulação dos registros durante a execução do programa.

Algumas características importantes:

- Aplicação executada pelo terminal.
- Dados armazenados temporariamente em memória por meio de `ArrayList`.
- Não possui integração com banco de dados.
- Não possui tratamento específico de exceções.
- Não possui salvamento permanente em arquivos.
- Eventos e tarefas recorrentes ainda não foram implementados.


Os registros são mantidos enquanto o programa está em execução. Ao encerrá-lo, os dados cadastrados são perdidos.

## 6. Próximas etapas

O projeto foi pensado para receber melhorias progressivas, acompanhando o aprendizado e a implementação de novos recursos.

Entre as possibilidades para versões futuras estão:

- Salvamento e recuperação de dados em arquivos.
- Implementação de eventos e tarefas recorrentes.
- Desenvolvimento de um planner semanal com distribuição dos compromissos pelos dias da semana.
- Melhorias na organização e apresentação das informações.
- Possível evolução para uma interface gráfica.


## 7. Objetivo de aprendizado

Mais do que desenvolver uma ferramenta de organização, este projeto representa uma oportunidade de aplicar conhecimentos de Java em uma situação prática.

A proposta é construir uma aplicação útil, evoluindo sua estrutura gradualmente e consolidando conceitos de lógica de programação, orientação a objetos e manipulação de coleções.

**Projeto pessoal em desenvolvimento.**
**Autor: Gabriel do Nascimento D'angelo**
**Última atualização: 30/10/2026**
