package br.com.senaijandira.cadastro.ui


fun validarMinimoCaracteres(texto:String, minimo:Int) : Boolean{

    return texto.length >= minimo

}

fun validarTextoComArroba(texto:String) = texto.contains("@")


fun textoContemNumero(texto:String) :Boolean =
    texto.filter { it.isDigit() }.length > 0



fun ehSequenciaNumerica(texto:String) = "0123456789".contains(texto)



