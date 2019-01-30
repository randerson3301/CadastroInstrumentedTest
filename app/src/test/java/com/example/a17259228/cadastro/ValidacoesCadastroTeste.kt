package com.example.a17259228.cadastro

import org.junit.Assert
import org.junit.Test



    class ValidacoesCadastroTeste {
        @Test
        fun validarCharsSucesso(){
            val input = "ariele"
            val resultEsperado = true //essa constante armazena o resulktado que esperamos

            val result = validar_min_chars(input, 3)

            Assert.assertEquals(resultEsperado, result) //verifica a igualdade entre o result esperado e o inputado
        }

        @Test
        fun validarCharsSucessoDuasLetras(){
            val input = "ar"
            val resultEsperado = false //essa constante armazena o resulktado que esperamos

            val result = validar_min_chars(input, 3)

            Assert.assertEquals(resultEsperado, result) //verifica a igualdade entre o result esperado e o inputado
        }

        @Test
        fun validarCharsSucessoTresLetras(){
            val input = "ari"
            val resultEsperado = true //essa constante armazena o resulktado que esperamos

            val result = validar_min_chars(input, 3)

            Assert.assertEquals(resultEsperado, result) //verifica a igualdade entre o result esperado e o inputado
        }

        @Test
        fun `validar arroba no email`(){
            val input = "joao@@gmail.com"
            val resultEsperado = true

            val result = validarEmail(input)

            Assert.assertEquals(resultEsperado, result)
        }

        @Test
        fun `senha com menos de 4 chars`(){
            val input = "abc"
            val resultEsperado = false

            val result = validar_min_chars(input, 4)

            Assert.assertEquals(resultEsperado, result)
        }

        @Test
        fun `senha com mais de 4 chars`(){
            val input = "abcd"
            val resultEsperado = true

            val result = validar_min_chars(input, 4)

            Assert.assertEquals(resultEsperado, result)
        }

        @Test
        fun `senha com nums`(){
            val input = "1234"
            val resultEsperado = true

            val result = validar_min_chars(input, 4)

            Assert.assertEquals(resultEsperado, result)
        }
        @Test
        fun `senha sem nums`(){

        }

        @Test
        fun `senha sem sequencia de nums`(){
            val input = "1234"
            val resEsp = true

            val result = isSeqNum(input)

            Assert.assertEquals(resEsp, result)
        }

        @Test
        fun `senha com sequencia de nums`(){
            val input = "rvmls"
            val resEsp = false

            val result = isSeqNum(input)

            Assert.assertEquals(resEsp, result)
        }
    }
