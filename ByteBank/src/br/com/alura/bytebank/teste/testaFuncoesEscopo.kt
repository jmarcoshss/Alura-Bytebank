package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco

fun testaFuncoesEscopo() {
    //    val endereco = Endereco(logradouro = "rua vergueiro", numero = 3018)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(enderecoEmMaiusculo)

    run {
        println("run")
    }

    Endereco(logradouro = "rua vergueiro", numero = 3018)
        .run {
            "$logradouro, $numero".toUpperCase()
        }.let { enderecoEmMaiusculo: String ->
            println(enderecoEmMaiusculo)
        }

    listOf(
        Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento")
    ).filter { endereco -> endereco.complemento.isNotEmpty() }.let(::println)
}