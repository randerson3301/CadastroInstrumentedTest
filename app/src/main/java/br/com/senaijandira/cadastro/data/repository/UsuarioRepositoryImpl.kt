package br.com.senaijandira.cadastro.data.repository

import br.com.senaijandira.cadastro.data.service.ApiService
import br.com.senaijandira.cadastro.domain.repository.UsuarioRepository
import br.com.senaijandira.cadastro.model.ApiResult
import br.com.senaijandira.cadastro.model.Usuario
import retrofit2.Call

class UsuarioRepositoryImpl (
        val apiService: ApiService
) : UsuarioRepository {

    override fun insert(usuario: Usuario): Call<ApiResult> {
        return apiService
                .cadastrarUsuario(usuario.nome,
                                  usuario.email,
                                  usuario.senha)
    }
}