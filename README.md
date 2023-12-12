# ESTI – ESCOLA SUPERIOR DA TECNOLOGIA DA INFORMAÇÃO
## GRADUAÇÃO EM ENGENHARIA DE COMPUTAÇÃO

### Matéria: Desenvolvimento Back-End

#### Professor: Rafael Soares de Souza

## Índice

- [ESTI – ESCOLA SUPERIOR DA TECNOLOGIA DA INFORMAÇÃO](#esti--escola-superior-da-tecnologia-da-informação)
   - [GRADUAÇÃO EM ENGENHARIA DE COMPUTAÇÃO](#graduação-em-engenharia-de-computação)
      - [Matéria: Desenvolvimento Back-End](#matéria-desenvolvimento-back-end)
         - [Professor: Rafael Soares de Souza](#professor-rafael-soares-de-souza)
   - [Índice](#índice)
   - [Introdução](#introdução)
   - [Funcionalidades](#funcionalidades)
   - [Arquitetura da Plataforma](#arquitetura-da-plataforma)
   - [Diagrama de Caso de Uso](#diagrama-de-caso-de-uso)
      - [Usuário](#usuário)
      - [Administrador](#administrador)
   - [Entidades Identificadas](#entidades-identificadas)
   - [Diagrama de Classes](#diagrama-de-classes)
   - [Diagrama de Estados](#diagrama-de-estados)
   - [Diagrama de Atividades](#diagrama-de-atividades)

## Introdução

A Livraria App é uma plataforma online inovadora destinada a apaixonados por livros. Com uma interface amigável e uma gama de funcionalidades intuitivas, a Livraria App permite aos usuários explorar, gerenciar e atualizar uma vasta coleção de títulos literários.

## Funcionalidades

- Lista de Livros: Os usuários podem navegar por uma lista completa de livros disponíveis na Livraria App. A seleção pode ser refinada por gênero para uma experiência personalizada de busca.

- Detalhes do Livro: Cada livro vem acompanhado de detalhes essenciais como nome, preço, capa e informações adicionais, permitindo que o usuário conheça profundamente cada obra antes de tomar uma decisão de compra ou leitura.

- Adicionar Livro: A plataforma oferece a opção de enriquecer a biblioteca adicionando novos títulos. Os usuários podem inserir informações como gênero, nome, preço, capa e detalhes para manter a coleção atualizada e diversificada.

- Remover Livro: Caso seja necessário, livros podem ser facilmente removidos da lista. A interface permite selecionar o título desejado para remoção de maneira simples e rápida.

- Atualizar Livro: A Livraria App compreende a dinâmica do mundo literário e oferece a possibilidade de atualizar as informações dos livros sempre que necessário, garantindo que a base de dados esteja sempre correta e atual.

## Arquitetura da Plataforma

A Livraria App foi desenvolvida com uma arquitetura modular que facilita a navegação e a gestão de conteúdo. O diagrama a seguir ilustra o fluxo de interação entre as diversas funcionalidades da plataforma.
<img src="/assets/img/DiagramaFluxo.png">

## Diagrama de Caso de Uso

### Usuário

- Navegar pela Lista de Livros: O usuário pode explorar a lista completa de livros disponíveis, com a opção de refinar sua seleção por gênero.
- Visualizar Detalhes do Livro: Após escolher um livro, o usuário pode visualizar detalhes como nome, preço, capa e informações adicionais.
- Adicionar Livro: Permite ao usuário inserir um novo livro na lista, fornecendo detalhes como gênero, nome, preço, capa e outras informações relevantes.
- Remover Livro: O usuário pode selecionar e remover um livro da lista.
Atualizar Livro: Permite ao usuário modificar as informações de um livro já listado.


### Administrador

- Gerenciar Lista de Livros: O administrador tem controle sobre a lista de livros, provavelmente com capacidades adicionais além das dos usuários comuns.
- Atualizar Informações do Sistema: Responsável por manter o sistema atualizado, seja em relação ao conteúdo ou à infraestrutura técnica.
- Monitorar Atividades dos Usuários: O administrador pode acompanhar as ações dos usuários para manter a ordem e segurança do sistema.

<img src="/assets/img/DiagramaCasosUso.png">

## Entidades Identificadas

1. **Livro**
- Descrição: Representa os detalhes de um livro disponível na Livraria App.
- Campos:
- - ID do Livro: um identificador único para o livro.
- - Título: o nome do livro.
- - Autor: o(s) autor(es) do livro.
- - Gênero: a categoria ou gênero literário do livro.
- - Preço: o custo de compra do livro.
- - ISBN: número padrão internacional do livro.
- - Capa: uma imagem ou design da capa do livro.
- - Descrição: uma sinopse ou informações adicionais sobre o livro.
- Relacionamento:
- - Está associado a zero ou mais pedidos (através de Itens de Pedido).
- - Pode ser adicionado, removido ou atualizado pelo Usuário ou Administrador.


2. **Usuário**
- Descrição: Alguém que usa o Livraria App para explorar e interagir com a lista de livros.
- Campos:
-- ID do Usuário: um identificador único para o usuário.
-- Nome: o nome completo do usuário.
-- Email: o endereço de e-mail do usuário para contato.
-- Senha: uma senha para a conta do usuário.
- Relacionamento:
-- Pode criar, atualizar ou remover um Livro (se tiver permissões).
-- Pode realizar um Pedido.

3. **Pedido**
- Descrição: Registra a aquisição de um ou mais livros por um usuário.
- Campos:
-- ID do Pedido: um identificador único para o pedido.
-- Data do Pedido: a data e hora em que o pedido foi realizado.
-- Status: o estado atual do pedido (por exemplo, pendente, pago, enviado).
-- Usuário ID: o identificador do usuário que realizou o pedido.
- Relacionamento:
-- Associa um ou mais livros ao usuário que fez o pedido (através de Itens de Pedido).
-- Um usuário pode ter vários Pedidos.


## Diagrama de Classes

- **Livro:** Detalha os atributos de um livro...
- **Usuário:** Representa um usuário da plataforma...
- **Pedido:** Registra os pedidos feitos pelos usuários...

## Diagrama de Estados

- **Estado do Livro:** O livro começa no estado "Disponível"...
- **Estado do Pedido:** O pedido é "Criado" inicialmente...

## Diagrama de Atividades

- **Lista de Livros:** Este processo permite ao usuário visualizar...
- **Selecionar Livro:** A partir da lista, o usuário seleciona um livro...

