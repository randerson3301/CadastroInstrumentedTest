package br.com.senaijandira.cadastro.domain.repository

import br.com.senaijandira.cadastro.model.LoginResult
import br.com.senaijandira.cadastro.model.Usuario
import retrofit2.Call

interface LoginRepository {
    fun login(usuario: Usuario): Call<LoginResult>
}