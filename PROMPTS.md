# PROMPTS: Grupo ____

**Integrantes:**

1. Adelia Vivian Conscetta 
2. Maria Eduarda Queiroz de Almeida 
3. Marina Santos Bessa Macedo 

**Prova:** API em MVC (Reserva de Salas)

**Usamos IA?** (X) Sim  ( ) Não

**Qual ferramenta e modelo (se usaram):**

ChatGpt
## Registro, na ordem



### Prompt 1

**O prompt (cópia exata):**

>  # Prova de API em MVC com IA: Reserva de Salas da Escola

| Duração | Grupo | IA | Conceitos |
| --- | --- | --- | --- |
| 45 minutos | Até 3 alunos | Liberada (opcional) | Camadas (Model, Repository, Service, Controller), regras de negócio, validação e status HTTP |

## Como esta prova funciona

Nesta prova vocês podem usar IA, e quem preferir fazer sem ela também pode. O que importa é mostrar **como a API foi construída**, não só o resultado.

A nota tem duas partes:

| Parte | Pontos | O que olhamos |
| --- | --- | --- |
| Produto | 6,0 | A API entregue: camadas, regras de negócio, validação e respostas HTTP |
| Processo | 4,0 | O caminho: o que vocês pediram, em que ordem, o que conferiram e o que entenderam |

Não tem passo a passo. O enunciado conta o problema e as regras. As rotas, os nomes e a ordem de construção são decisões de vocês.

## A situação

A escola quer uma API para controlar a reserva de suas salas: laboratórios, auditório, salas de aula. Cada sala tem um código, um nome e uma capacidade, e a escola precisa saber quais estão reservadas e quais estão livres.

## O que a API precisa fazer

- Cadastrar uma sala, listar todas, buscar uma pelo id e excluir.
- Reservar uma sala e liberar uma sala.
- Responder cada situação com o status HTTP certo: sucesso, criado, sem conteúdo, não encontrado, conflito e dados inválidos.

## As regras da escola

- Toda sala cadastrada começa livre.
- O **código é único**: não pode haver duas salas com o mesmo código.
- **Código e nome são obrigatórios**, e a **capacidade precisa ser maior que zero**.
- Uma sala que já está reservada **não pode ser reservada de novo**.
- Só pode ser liberada uma sala que **está reservada**.
- Uma sala reservada **não pode ser excluída**.
- Pedir, reservar, liberar ou excluir uma sala que não existe é um caso de "não encontrado".

## O que o projeto precisa ter

- O projeto **`Escola-base`**, que o professor entrega, e que vocês usam como ponto de partida. Ele já traz Spring Web, Spring Data JPA, validação e banco **H2 em memória**, e já sobe sem nenhuma classe de vocês. Não precisa criar projeto. O arquivo `README.md` dele explica como rodar.
- Organização em camadas, **cada uma no seu pacote, criado por vocês** dentro de `src/main/java/escola`: `model`, `repository`, `service` e `controller`. O projeto base não traz essas pastas prontas.
- As regras da escola ficam na **Service**. O **Controller** só recebe a requisição, chama a Service e devolve a resposta HTTP. O Controller não conversa direto com o Repository.
- As rotas seguem o padrão REST. Vocês escolhem os nomes.

## Roteiro de conferência

Com o banco vazio (recém-iniciado), façam os pedidos abaixo na ordem. A primeira sala cadastrada recebe o id 1.

| Passo | O que fazer | Status esperado |
| --- | --- | --- |
| 1 | Cadastrar a sala de código LAB-01, nome Lab Informatica, capacidade 30 | 201 |
| 2 | Cadastrar outra sala com o mesmo código LAB-01 | 409 |
| 3 | Cadastrar uma sala sem nome | 400 |
| 4 | Reservar a sala 1 | 200 |
| 5 | Reservar a sala 1 de novo | 409 |
| 6 | Excluir a sala 1 (que está reservada) | 409 |
| 7 | Liberar a sala 1 | 200 |
| 8 | Liberar a sala 1 de novo | 409 |
| 9 | Excluir a sala 1 | 204 |
| 10 | Buscar a sala 1 | 404 |

O `README.md` do projeto base já traz esta tabela com duas colunas a mais: **a rota que vocês usaram** e **o status que a API devolveu de verdade**. Preencham as duas. Se algum passo não bater, escrevam o que aconteceu.

Como fazer os pedidos fica a critério de vocês (Postman, Insomnia, `curl`, arquivo `.http`, outro).

> **Dica.** Se o JSON levar acento (por exemplo, "Laboratório"), alguns programas no Windows enviam o texto numa codificação que a API recusa com 400. Se isso acontecer num passo que deveria dar certo, testem sem acento antes de procurar erro no código.

## Registro do processo: o arquivo PROMPTS.md

O arquivo `PROMPTS.md` já está dentro do projeto base. Preencham **durante** a prova, não depois.

- Registrem cada prompt **exatamente como foi enviado**, na ordem. Copiem e colem, não reescrevam.
- Ao lado de cada prompt, escrevam em uma ou duas linhas o que a IA devolveu e o que vocês fizeram com a resposta (usaram, alteraram ou descartaram) e por quê.
- Quem não usar IA também preenche o arquivo, descrevendo cada passo na ordem em que foi feito.
- Nos 5 minutos finais, **sem consultar a IA**, respondam as três perguntas da seção "Perguntas finais", logo abaixo, na última parte do `PROMPTS.md`.

O arquivo precisa se explicar sozinho: quem ler deve entender o caminho que vocês seguiram sem precisar perguntar nada.

## Perguntas finais

1. Quando chega um pedido de reservar uma sala, qual é o caminho até a resposta? Passe por cada camada (Controller, Service, Repository e Model).
2. Por que a regra "uma sala reservada não pode ser reservada de novo" fica na Service e não no Controller?
3. Se a escola trocar o H2 por outro banco de dados, quais classes precisam mudar? Por quê?

## Sugestão de tempo

| Minutos | O que fazer |
| --- | --- |
| 0 a 5 | Ler a prova e combinar como o grupo vai trabalhar |
| 5 a 32 | Construir e testar a partir do projeto base, registrando os prompts |
| 32 a 40 | Rodar o roteiro de conferência e preencher o README |
| 40 a 45 | Responder as três perguntas, sem IA |

Se o projeto não subir a tempo, entreguem o código mesmo assim e registrem no `PROMPTS.md` o que travou e o que tentaram. O processo também vale nota.

## O que entregar

Uma pasta por grupo, com:

- o projeto `Escola-base` com o código de vocês, sem a pasta `target`;
- o `README.md` do projeto, com os nomes dos integrantes e o roteiro de conferência preenchido;
- o `PROMPTS.md` do projeto, preenchido.

## Como será corrigida

- [ ] Os pacotes das quatro camadas foram criados, cada um com a sua responsabilidade, e o Controller não usa o Repository.
- [ ] As regras da escola estão na Service.
- [ ] Cada situação responde com o status HTTP certo.
- [ ] Os dados inválidos são recusados com 400.
- [ ] O roteiro de conferência preenchido bate com o que o código faz.
- [ ] O `PROMPTS.md` mostra o caminho: prompts na ordem, o que foi conferido e o que foi corrigido.
- [ ] As respostas finais mostram que o grupo entende o que entregou.


# PROMPTS: Grupo ____

**Integrantes:**

1.
2.
3.

**Prova:** API em MVC (Reserva de Salas)

**Usamos IA?** ( ) Sim  ( ) Não

**Qual ferramenta e modelo (se usaram):**

> Quem não usou IA: troque "prompt" por "passo". Em cada bloco abaixo, descreva o que vocês fizeram naquele passo, na ordem em que aconteceu, e preencha os outros campos do mesmo jeito.

## Registro, na ordem

Copie o bloco abaixo para cada prompt. Escreva o prompt exatamente como foi enviado.

### Prompt 1

**O prompt (cópia exata):**

> 

**O que a IA devolveu (uma ou duas linhas):**

**O que fizemos com a resposta:** ( ) usamos como veio  ( ) alteramos  ( ) descartamos

**Por quê (o que conferimos, o que mudamos):**

### Prompt 2

**O prompt (cópia exata):**

> 

**O que a IA devolveu (uma ou duas linhas):**

**O que fizemos com a resposta:** ( ) usamos como veio  ( ) alteramos  ( ) descartamos

**Por quê (o que conferimos, o que mudamos):**

(continuem com quantos blocos precisarem)

## Como conferimos

Descrevam como vocês testaram o que ficou pronto. Colem aqui a saída do programa (POO) ou o resultado do roteiro (API) e digam se bateu com a tabela da prova. Se não bateu, digam o que fizeram.

## Onde a IA errou, ou onde nós erramos

Contem pelo menos um erro que apareceu durante a prova: o que era, como perceberam e como resolveram. Se não apareceu nenhum, expliquem como vocês têm certeza disso.

## Respostas finais, sem consultar a IA

Respondam com as suas palavras, nos últimos 5 minutos. Não copiem de lugar nenhum.


O ChatGPT disse:
Entendi! Você enviou a prova completa de API em MVC – Reserva de Salas da Escola, incluindo as regras, os testes obrigatórios e o modelo do PROMPTS.md.

Posso ajudar vocês a desenvolver o projeto usando Java + Spring Boot, respeitando exatamente a estrutura exigida pelo professor.

Podemos construir:

Model: classe Sala, com id, código, nome, capacidade e status de reserva.

Repository: acesso ao banco H2 usando Spring Data JPA.

Service: implementação de todas as regras de negócio.

Controller: rotas REST e respostas HTTP corretas.

Testes: os 10 passos do roteiro de conferência.

PROMPTS.md: registro organizado do uso da IA.

Também posso explicar cada classe para que vocês consigam entender e apresentar o código.

Por onde você quer começar: pela criação de todo o código da API ou pela explicação passo a passo de como desenvolver o projeto?


Você disse:
criacao de todo o codigo explicando como faz

**O que a IA devolveu (uma ou duas linhas):**

**O que fizemos com a resposta:** (X) usamos como veio  ( ) alteramos  ( ) descartamos

**Por quê (o que conferimos, o que mudamos):**
pedimos para a IA rodar para ver se havia erros

**O que a IA devolveu (uma ou duas linhas):**
A explicaçao junto com cada código, depois pedimos para ela ver se não tinha erros, havia erros e corrigimos 


## Como conferimos

Pedimos para a própria IA ver se tinha erros 

## Onde a IA errou, ou onde nós erramos

Na hora dos testes
## Respostas finais, sem consultar a IA
1. O Controller recebe o pedido, a Service verifica se a sala está livre, o Repository procura no banco e o Model guarda os dados. Se estiver livre, a sala é reservada.

2. Porque a Service cuida das regras do sistema, e o Controller só recebe os pedidos e responde.

3. Principalmente as configurações do banco. Se continuar usando JPA, provavelmente não precisa mudar as outras classes.
