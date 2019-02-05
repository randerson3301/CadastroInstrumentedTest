package com.example.a17259228.cadastro.ui

//criando uma função  pura - recebe o input e o mesmo output sempre
//: Boolean -> tipo do retorno
fun validar_min_chars(txt: String, min:Int): Boolean {
    return txt.length >= min
}

//função para validar o e-mail
fun validarEmail(txt: String) = txt.contains("@") //jeito mais simples de retornar um valor

//verifica se possui pelo menos um número na senha
fun textoContemUmNumero(txt: String) :Boolean =
        txt.filter { it.isDigit() }.length > 0

fun isSeqNum(txt: String):Boolean =
        "0123456789".contains(txt)
