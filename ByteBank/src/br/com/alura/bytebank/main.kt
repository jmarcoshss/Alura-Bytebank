package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.teste.testaHOF

fun main() {
testaHOF()
}

fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12
    println("a taxa mensal é $taxaMensal")

    val contaPoupanca = ContaPoupanca(Cliente(nome = "alex", cpf = "111.111.111-11", senha = 1234), numero = 1000)

    contaPoupanca.run {
        deposita(1000.0)
        println(saldo)
        saldo * taxaMensal
    }.let { rendimentoMensal ->
        println("rendiemnto mensal é :$rendimentoMensal")
    }

    val rendimentoAnual = run {
        var saldo = contaPoupanca.saldo
        repeat(12) {
            saldo += saldo * taxaMensal
        }
        saldo
    }
    println("rendimento anual é :$rendimentoAnual")
}

fun testaWith() {
    with(Endereco()) {
        logradouro = "rua vergeiro"
        numero = 3185
        bairro = "vila mariana"
        cidade = "são paulo"
        estado = "SP"
        cep = "0231-063"
        complemento = "apartamento"
        completo()
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
    }
}









