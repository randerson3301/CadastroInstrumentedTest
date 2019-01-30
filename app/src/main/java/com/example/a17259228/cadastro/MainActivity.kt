package com.example.a17259228.cadastro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import com.example.a17259228.cadastro.R

class MainActivity : AppCompatActivity() {

    companion object {
        val MINIMO_CHAR_NOME = 3
        val MINIMO_CHAR_SENHA = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //identificando elementos view
        val btn = findViewById<Button>(R.id.btn_cadastro)
        val txt_name= findViewById<EditText>(R.id.txt_nome)
        val txt_email = findViewById<EditText>(R.id.txt_email)
        val txt_senha = findViewById<EditText>(R.id.txt_senha)


        btn.setOnClickListener{
            val nome = txt_name.text.toString()
            val email = txt_email.text.toString()
            val senha = txt_senha.text.toString()

            //VALIDANDO NOME
            if(!validar_min_chars(nome, MINIMO_CHAR_NOME)){
                txt_name.error = "Nome deve ter pelo menos $MINIMO_CHAR_NOME caracteres"
            }

            if(!validarEmail(email)){
                txt_email.error="E-mail deve possuir @"
            }

            if(!validar_min_chars(senha, MINIMO_CHAR_SENHA)){
                txt_senha.error = "Senha deve ter pelo menos $MINIMO_CHAR_SENHA caracteres"
            }

            if(!textoContemUmNumero(senha)){
                txt_senha.error = "Senha deve ter pelo menos um número"
            }

            if (isSeqNum(senha)){
                txt_senha.error = "Senha não pode ser sequencia"

            }
        }

    }


}
