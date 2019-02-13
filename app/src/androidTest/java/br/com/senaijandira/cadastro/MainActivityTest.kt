package br.com.senaijandira.cadastro

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.Button
import android.widget.EditText
import br.com.senaijandira.cadastro.ui.MainActivity
import org.hamcrest.CoreMatchers.equalTo
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    lateinit var activity: MainActivity

     @Before
     fun setUp(){
         activity = rule.activity
     }


    @Test
    fun activityCarregaHintsCorretamente(){

        val userName = activity.findViewById<EditText>(R.id.etUserName)
        val email = activity.findViewById<EditText>(R.id.etEmail)
        val senha = activity.findViewById<EditText>(R.id.etPassword)

        Assert.assertThat(userName.hint.toString(), equalTo("Nome de usuário"))
        Assert.assertThat(email.hint.toString(), equalTo("E-Mail"))
        Assert.assertThat(senha.hint.toString(), equalTo("Senha"))
    }

    @Test
    fun botaoCarregaCorretamente(){
        //Verificar se o botão está carregado na tela
        //E se ele possui o texto: Salvar

        val button = activity.findViewById<Button>(R.id.btSalvar)

        Assert.assertThat(button.text.toString(), equalTo("Salvar"))

    }

    @Test
    fun testeNomeComDoisCaracteres(){

        //Acessr o componente da tela com determinado hint
        val userName = onView(withHint("Nome de usuário"))

        //Escrever o texto na caixinha
        userName.perform(typeText("al"))

        //clica no botao com texto 'Salvar'
        onView(withText("Salvar")).perform(click())

        val textError = "Nome deve ter pelo menos ${MainActivity.MINIMO_CARACTERES_NOME} caracteres"

        userName.check(matches(hasErrorText(textError)))

    }


    @Test
    fun testeEmailSemArroba(){

        //Acessr o componente da tela com determinado hint
        val email = onView(withId(R.id.etEmail))

        //Escrever o texto na caixinha
        email.perform(typeText("kassianogmail.com"))

        //clica no botao com texto 'Salvar'
        onView(withText("Salvar")).perform(click())

        val textError = "Email deve ter @"

        email.check(matches(hasErrorText(textError)))

    }


    @Test
    fun testeSenhaMinimoCaracteres(){

        val senha = onView(withId(R.id.etPassword))

        //Escrever o texto na caixinha
        senha.perform(typeText("a1"))

        //clica no botao com texto 'Salvar'
        onView(withText("Salvar")).perform(click())

        val textError = "Senha deve ter ${MainActivity.MINIMO_CARACTERES_SENHA} caracteres"

        senha.check(matches(hasErrorText(textError)))

    }


    @Test
    fun testeSenhaSequenciaNumerica(){

        val senha = onView(withId(R.id.etPassword))

        //Escrever o texto na caixinha
        senha.perform(typeText("123456"))

        //clica no botao com texto 'Salvar'
        onView(withText("Salvar")).perform(click())

        val textError = "Senha não pode ser sequencia"

        senha.check(matches(hasErrorText(textError)))

    }


    @Test
    fun testeSenhaSemNumeros(){

        val senha = onView(withId(R.id.etPassword))

        //Escrever o texto na caixinha
        senha.perform(typeText("admin"))

        //clica no botao com texto 'Salvar'
        onView(withText("Salvar")).perform(click())

        val textError = "Senha deve ter numero"

        senha.check(matches(hasErrorText(textError)))
    }

}