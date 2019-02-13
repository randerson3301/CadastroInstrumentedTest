package br.com.senaijandira.cadastro.data.service

import br.com.senaijandira.cadastro.model.ApiResult
import br.com.senaijandira.cadastro.model.Usuario
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("inf4m/contatos/inserir_usuario.php")
    fun cadastrarUsuario(@Field("nome")  nome: String,
                         @Field("email") email:String,
                         @Field("senha") senha:String): Call<ApiResult>

    @FormUrlEncoded
    @POST("inf4m/contatos/login_usuario.php")
    fun loginUsuario(@Field("email") email:String,
                     @Field("senha") senha:String): Call<ApiService>

}