#language: pt

Funcionalidade: Verificar se o cliente esta habilitado para obter empréstimo.

  @CT001_001
  Cenario: Conta atende todos os itens
    Dado que o cliente nunca emitiu cheques sem fundo
    E que não constam restrições nos sistemas
    E que o cliente possui uma renda comprovada de R$ 7.500,00
    E que o cliente não está usando cheque especial
    E que o cliente não esta usando cartão rotativo superior a  R$ 2.500,00
    E que o possui conta ativa mais de dois anos
    Quando é verificado os requisitos de elegibilidade do cliente
    Então o banco autoriza a solicitação de empréstimo


  @CT002_001
  Cenario: Conta não atende algum requesito
    Dado que o cliente não atende a um ou mais requisitos de elegibilidade
    Quando o funcionário do banco verifica os requisitos de elegibilidade do cliente
    Então o banco informa ao cliente não estar habilitador para o empréstimo


  @CT003_001
  Cenario: Cliente não possui uma conta corrente ativa no banco aha mais  de 2 anos
    Dado que o cliente não possui uma conta corrente ativa a mais de 2 anos
    Quando o funcionário do banco verifica os requisitos
    Então o funcionário do banco solicita que o cliente abra uma conta  ou espere ate atingir o prazo mínimo.


  @CT004_001
  Cenario: Cliente nunca emitiu cheques sem fundo
    Dado quer o cliente nunca emitiu cheques sem fundo
    Quando é verificado os requisitos de elegibilidade do cliente..
    Então o funcionário do banco informa ao cliente que ele não esta habilitado para obter o empréstimo devido à emissão de cheques sem fundo

  @CT005_001
  Cenario: Cliente não possui renda comprovada de pelo menos R$ 7.500,00
    Dado que o cliente não possui renda comprovada de no mínimo R$ 7.500,00
    Quando é verificado os requisitos de elegibilidade do cliente.
    Então o funcionário do banco deve informar ao cliente que ele não esta habilitado para obter o empréstimo devido não ter renda sufiuciente


  @CT006_001
  Cenario: Cliente não esta usando cartao rotativo com o valor superior a R$ 2.500,00
    Dado que o Cliente não esta usando cartao rotativo com o valor superior a R$ 2.500,00
    Quando é verificado os requisitos de elegibilidade do cliente...
    Então o funcionário do banco informa ao cliente que ele  não esta habilitado   para obter o empréstimo devido ter  cartao rotativo com o valor superior a R$ 2.500,



  @CT007_001
  Cenario: Cliente não está usando cheque especial
    Dado que o cliente não está usando cheque especial.
    Quando é verificado os requisitos de elegibilidade do cliente....
    Então o funcionário do banco informa ao cliente que ele  não esta habilitado   para obter o empréstimo devido ter  cheque especial.


