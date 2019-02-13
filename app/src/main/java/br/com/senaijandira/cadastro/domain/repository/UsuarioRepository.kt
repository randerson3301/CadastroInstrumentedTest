package br.com.senaijandira.cadastro.domain.repository

import br.com.senaijandira.cadastro.model.ApiResult
import br.com.senaijandira.cadastro.model.Usuario
import retrofit2.Call

interface UsuarioRepository {

    fun insert(usuario:Usuario): Call<ApiResult>

}