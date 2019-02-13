package br.com.senaijandira.cadastro.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.SystemClock
import android.util.Log
import br.com.senaijandira.cadastro.data.repository.UsuarioRepositoryImpl
import br.com.senaijandira.cadastro.data.retrofit.RetrofitFactory
import br.com.senaijandira.cadastro.domain.repository.UsuarioRepository
import br.com.senaijandira.cadastro.domain.useCase.CadastrarUsuario
import br.com.senaijandira.cadastro.model.ApiResult
import br.com.senaijandira.cadastro.model.Usuario
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroViewModel : ViewModel() {

    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()
    val success = MutableLiveData<ApiResult>()


    //Criando a API com retrofit
    private val apiService = RetrofitFactory().createApiService()

    //Criando o repository
    private val repository :UsuarioRepository = UsuarioRepositoryImpl(apiService)

    val cadastrarUsuario = CadastrarUsuario(repository, callback() )

    inner class callback : Callback<ApiResult>{
        override fun onFailure(call: Call<ApiResult>?, t: Throwable?) {
            Log.e("CadastroViewModel",t?.message)
            error.postValue(true)
        }

        override fun onResponse(call: Call<ApiResult>?, response: Response<ApiResult>?) {
            Log.d("CadastroViewModel",response?.body()?.mensagem)

            val retornoApi = response?.body()
            cadastroUsuarioSucesso(retornoApi)
        }
    }


    fun cadastrarUsuario(user:Usuario){
        loading.postValue(true)
        error.postValue(false)

        //Efetuar o cadastro em si
        cadastrarUsuario.execute(user)
    }

    fun cadastroUsuarioSucesso(result: ApiResult?){
        loading.postValue(false)

        result?.let {
            success.postValue(result)
        }
    }

}