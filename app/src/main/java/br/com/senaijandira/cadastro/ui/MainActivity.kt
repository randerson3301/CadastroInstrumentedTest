package br.com.senaijandira.cadastro.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.senaijandira.cadastro.R
import br.com.senaijandira.cadastro.model.ApiResult
import br.com.senaijandira.cadastro.model.Usuario
import br.com.senaijandira.cadastro.viewmodel.CadastroViewModel
import br.senai.jandira.cadastro.ui.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    companion object {
        val MINIMO_CARACTERES_NOME = 3
        val MINIMO_CARACTERES_SENHA = 4
    }

    private var errorSnack: Snackbar? = null

    val viewModel by lazy {
        ViewModelProviders.of(this).get(CadastroViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btSalvar.setOnClickListener {

            val nome = etUserName.text.toString()
            val email = etEmail.text.toString()
            val senha = etPassword.text.toString()

            if(validarFormulario(nome, email,senha)){
                viewModel.cadastrarUsuario(
                        Usuario(nome,email,senha)
                )
            }

        }

        viewModel.loading.observe(this, Observer {
            updateLoading(it)
        })

        viewModel.error.observe(this, Observer {
            updateError(it)
        })

        viewModel.success.observe(this, Observer {
            updateSucesso(it)
        })
    }

    fun validarFormulario(nome:String, email:String, senha:String) : Boolean{

        var retorno = true

        //validar nome
        if(!validarMinimoCaracteres(nome, MINIMO_CARACTERES_NOME)){
            etUserName.error = "Nome deve ter pelo menos ${MINIMO_CARACTERES_NOME} caracteres"
            retorno = false
        }

        if(!validarTextoComArroba(email)){
            etEmail.error = "Email deve ter @"
            retorno = false
        }

        if(!validarMinimoCaracteres(senha, MINIMO_CARACTERES_SENHA)){
            etPassword.error = "Senha deve ter ${MINIMO_CARACTERES_SENHA} caracteres"
            retorno = false
        }

        if(!textoContemNumero(senha)){
            etPassword.error = "Senha deve ter numero"
            retorno = false
        }

        if(ehSequenciaNumerica(senha)){
            etPassword.error = "Senha não pode ser sequencia"
            retorno = false
        }

        return retorno
    }

    fun updateLoading(loading:Boolean?){

        loading?.let {

            if(loading){
                btSalvar.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            }else{
                btSalvar.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }
    }

    fun updateError(error:Boolean?){

        error?.let {
            if(error){
                errorSnack = Snackbar.make(rootView,
                        "Erro de conexão", Snackbar.LENGTH_INDEFINITE).apply {

                    setAction("Reconectar", object: View.OnClickListener{
                        override fun onClick(v: View?) {
                            viewModel.cadastrarUsuario(getUsuario())
                        }
                    })
                    show()
                }

                progressBar.visibility = View.GONE
                btSalvar.visibility = View.VISIBLE
            } else {
                errorSnack?.dismiss()
            }

        }

    }

    fun updateSucesso(result: ApiResult?){
        result?.let {

            val titulo = if(it.sucesso) "Sucesso" else "Erro"
            alert (it.mensagem, titulo){
                okButton {
                    if(result.sucesso) {
                        startActivity<LoginActivity>()
                        finish()
                    }
                }
            }.show()
        }
    }



    fun getUsuario() : Usuario{
        val nome = etUserName.text.toString()
        val email = etEmail.text.toString()
        val senha = etPassword.text.toString()

        return Usuario(nome, email, senha)
    }
}
