package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.SistemaInterno

fun testaHOF() {
    soma(1, 5, resultado = {valor ->
        println(valor)
    })
    somaReceiver(1, 5, resultado = {
        println(this)
    })

    val autenticavel = object : Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int) = this.senha == senha
    }
    val sistema = SistemaInterno()
    sistema.entra(autenticavel, 1234) {
        println("realizar pagamento")
    }
    sistema.entraReceiver(autenticavel, senha = 1234, autenticado = {
        Pagamento()
    })
}

fun soma (a:Int, b:Int, resultado:(Int) -> Unit){
    println("soma sendo efetuada")
    resultado(a + b)
}
fun somaReceiver (a:Int, b:Int, resultado:Int.() -> Unit){
    println("soma sendo efetuada")
    val total = a + b
    total.resultado()
}