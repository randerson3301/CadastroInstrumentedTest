package br.com.senaijandira.cadastro

import br.com.senaijandira.cadastro.ui.ehSequenciaNumerica
import br.com.senaijandira.cadastro.ui.textoContemNumero
import br.com.senaijandira.cadastro.ui.validarMinimoCaracteres
import br.com.senaijandira.cadastro.ui.validarTextoComArroba
import org.junit.Assert
import org.junit.Test

class ValidacoesCadastroTest {


    @Test
    fun validarCaracteresSucesso(){

        val input = "ariele"
        val resultadoEsperado = true

        val resultado = validarMinimoCaracteres(input, 3)

        Assert.assertEquals(resultadoEsperado, resultado)
    }

    @Test
    fun validarCaracteresSucessoDuasLetras(){

        val input = "ar"
        val resultadoEsperado = false

        val resultado = validarMinimoCaracteres(input, 3)

        Assert.assertEquals(resultadoEsperado, resultado)
    }

    @Test
    fun validarCaracteresSucessoTresLetras(){

        val input = "ari"
        val resultadoEsperado = true

        val resultado = validarMinimoCaracteres(input, 3)

        Assert.assertEquals(resultadoEsperado, resultado)
    }


    @Test
    fun `validar arroba no email`(){

        val input = "joao@gmail.com"
        val resultadoEsperado = true

        val resultado = validarTextoComArroba(input)

        Assert.assertEquals(resultadoEsperado, resultado)
    }

    @Test
    fun `validar email sem arroba`(){

        val input = "joaogmail.com"
        val resultadoEsperado = false

        val resultado = validarTextoComArroba(input)

        Assert.assertEquals(resultadoEsperado, resultado)
    }

    @Test
    fun `validar dois arrobas no email`(){

        val input = "joao@@gmail.com"
        val resultadoEsperado = true

        val resultado = validarTextoComArroba(input)

        Assert.assertEquals(resultadoEsperado, resultado)
    }


    @Test
    fun `senha com menos de 4 caracteres`(){

        val input = "abc"
        val resultadoEsperado = false

        val resultado = validarMinimoCaracteres(input, 4)

        Assert.assertEquals(resultadoEsperado, resultado)
    }

    @Test
    fun `senha com mais de 4 caracteres`(){

        val input = "1234"
        val resultadoEsperado = true

        val resultado = validarMinimoCaracteres(input, 4)

        Assert.assertEquals(resultadoEsperado, resultado)
    }


    @Test
    fun `senha contem numero`(){

        val input = "oie2tudobem"
        val resultadoEsperado = true

        val resultado = textoContemNumero(input)

        Assert.assertEquals(resultadoEsperado, resultado)
    }

    @Test
    fun `senha sem numeros`(){

        val input = "oietudobem"
        val resultadoEsperado = false

        val resultado = textoContemNumero(input)

        Assert.assertEquals(resultadoEsperado, resultado)
    }


    @Test
    fun `eh senha com sequencia de numeros`(){

        val input = "1234"
        val resultadoEsperado = true

        val resultado = ehSequenciaNumerica(input)

        Assert.assertEquals(resultadoEsperado, resultado)
    }

    @Test
    fun `senha sem sequencia de numeros`(){

        val input = "1234A"
        val resultadoEsperado = false

        val resultado = ehSequenciaNumerica(input)

        Assert.assertEquals(resultadoEsperado, resultado)
    }




}