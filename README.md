# Laboratorio-01

- [Definições](#definições)

- [Diagrama de Caso De Uso](#diagrama-de-caso-de-uso)

- [Diagrama de Classes](#dagrama-de-classes)

- [Histórias de Usuários](#hist%C3%B3rias-de-usu%C3%A1rios)


## Definições

### Arquitetura

Arquitetura utilizada foi a arquitetura em camadas. A camada de CLI (Comand Line Interface) e a camada de Controller (cuida dos dados e da percistencia dos dados).

### Classes

- CLI/App: Classe responsavel por fazer a mediação entre CLI e Controller e Validadar permissões de acesso.
- Controller/Universidade: Gerencia dados de alunos e graduações. Carregar dos arquivos para as listas e persistir estes dados.
- Cotroller/Usuario, Aluno, Professor, Secretaria: Estrutura melhor os dados e define as permições de cada usuário.
- Controller/Materia, Disciplina e Matricula: Servem para estabelecer a relação da classe Graduacao e Usuário.
- Controller/Turma: Serve para estabelecer relação entre matriculas e professores.
- Controller/Graduacao: Gerenciar cursos fornecidos pela classe Universidade.
---

## Diagrama de Caso de Uso:

![Diagrama_CasoDeUso](./Projeto/Diagrama%20de%20Caso%20de%20Uso.png)

---
  
## Dagrama de Classes

![Diagrama_Classes](./Projeto/Diagrama%20de%20Classe.png)

---

## Histórias de usuários:
* US01 - Como aluno, eu quero me matricular nas disciplinas obrigatórias, para poder cursar as disciplinas obrigatórias.
* US02 - Como aluno, eu quero poder me matricular em disciplinas optativas, para poder cursar disciplinas optativas.
* US03 - Como aluno, eu quero cancelar a matrícula, para não estar inscrito em uma disciplina que não poderei cursar.
* US04 - Como aluno, eu quero me inscrever para o semestre, para poder cursar o semestre.
* US05 - Como usuário, eu quero logar no sistema, para poder ter acesso as funcionalidades do sistema.
* US06 - Como professor/aluno, eu quero verificar a ativação da disciplina, para saber o estado da disciplina.
* US07 - Como professor, eu quero verificar os alunos matriculados, para saber quem vai cursar a disciplina.
* US08 - Como Secretaria, eu quero gerar o currículo, para os alunos/professores terem acesso ao currículo.
* US09 - Como Secretaria, eu quero cadastrar disciplinas, para adicionar disciplinas no sistema.
* US10 - Como Secretaria, eu quero atualizar as disciplinas cadastradas, para deixar as disciplinas atualizadas no sistema.
* US11 - Como Secretaria, eu quero ver as disciplinas cadastradas, para saber quais as disciplinas estão no sistema.
* US12 - Como Secretaria, eu quero remover as disciplinas cadastradas, para poder tirar disciplinas do sistema.
* US13 - Como Secretaria, eu quero cadastrar alunos, para adicionar alunos no sistema.
* US14 - Como Secretaria, eu quero atualizar os alunos cadastrados, para deixar os alunos atualizados no sistema.
* US15 - Como Secretaria, eu quero ver os alunos cadastrados, para saber quais os alunos estão no sistema.
* US16 - Como Secretaria, eu quero remover os alunos cadastrados, para poder tirar alunos do sistema.
* US17 - Como Secretaria, eu quero cadastrar professores, para adicionar professores no sistema.
* US18 - Como Secretaria, eu quero atualizar os professores cadastrados, para deixar os professores atualizados no sistema.
* US19 - Como Secretaria, eu quero ver os professores cadastrados, para saber quais os professores estão no sistema.
* US20 - Como Secretaria, eu quero remover os professores cadastrados, para poder tirar professores do sistema.
* US21 - Como Sistema de cobrança, eu quero ser informado da inscrição para o semestre, para gerar os boletos.
