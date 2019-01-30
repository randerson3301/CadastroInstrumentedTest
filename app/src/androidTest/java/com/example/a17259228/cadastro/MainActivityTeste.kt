package com.example.a17259228.cadastro

import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.Button
import android.widget.EditText
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTeste {
    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    lateinit var activity: MainActivity

    @Before
    fun setUp(){
        activity = rule.activity
    }

    @Test
    fun activityCarregaCorretamente(){
        val userName = activity.findViewById<EditText>(R.id.txt_nome)
        val email = activity.findViewById<EditText>(R.id.txt_email)
        val senha = activity.findViewById<EditText>(R.id.txt_senha)

        Assert.assertThat(userName.hint.toString(), equalTo("Nome de Usuário"))
        Assert.assertThat(email.hint.toString(), equalTo("E-mail"))
        Assert.assertThat(senha.hint.toString(), equalTo("Senha"))
    }

    @Test
    fun botaoCarregaCorreto(){
        val btn = activity.findViewById<Button>(R.id.btn_cadastro)

        //comparando se o texto do botão é igual com "cadastrar"
        Assert.assertThat(btn.text.toString(), equalTo("Salvar"))
    }

    //teste com espresso, testando input de dados
    @Test
    fun testeNomeComDoisChars(){
        val userName  = onView(withHint("Nome de Usuário")) //acessando o componente que possui a hint determinada

        userName.perform(typeText("al")) //digitando no editText automaticamente

        userName.perform(ViewActions.closeSoftKeyboard())

       // val btn = activity.findViewById<Button>(R.id.btn_cadastro)

        //btn.performClick()

        val btn = onView(withText("Salvar"))

        btn.perform(click())

        val textError = "Nome deve ter pelo menos ${MainActivity.MINIMO_CHAR_NOME} caracteres"


        userName.check(matches(hasErrorText(textError))) //verifica se a msg de erro é a mesma
    }

    @Test
    fun testeValidarEmail(){
        val email = onView(withHint("E-mail"))

        email.perform(typeText("teste"))

        email.perform(ViewActions.closeSoftKeyboard())

        val btn = onView(withText("Salvar"))

        btn.perform(click())

        val textError = "E-mail deve possuir @"


        email.check(matches(hasErrorText(textError))) //verifica se a msg de erro é a mesma


    }

    @Test
    fun testeValidaSenhaSemSeq(){
        val senha = onView(withHint("Senha"))

        senha.perform(typeText("123"))

        senha.perform(ViewActions.closeSoftKeyboard())

        val btn = onView(withText("Salvar"))

        btn.perform(click())

        val textError = "Senha não pode ser sequencia"


        senha.check(matches(hasErrorText(textError))) //verifica se a msg de erro é a mesma

    }

    @Test
    fun testeValidaSenhaQuatroCaracteres(){
        val senha = onView(withHint("Senha"))

        senha.perform(typeText("1st"))

        senha.perform(ViewActions.closeSoftKeyboard())

        val btn = onView(withText("Salvar"))

        btn.perform(click())

        val textError = "Senha deve ter pelo menos ${MainActivity.MINIMO_CHAR_SENHA} caracteres"

        senha.check(matches(hasErrorText(textError))) //verifica se a msg de erro é a mesma

    }

    @Test
    fun testeValidaSenhaUmNum(){
        val senha = onView(withHint("Senha"))

        senha.perform(typeText("teste"))

        senha.perform(ViewActions.closeSoftKeyboard())

        val btn = onView(withText("Salvar"))

        btn.perform(click())

        val textError = "Senha deve ter pelo menos um número"


        senha.check(matches(hasErrorText(textError))) //verifica se a msg de erro é a mesma

    }

}



