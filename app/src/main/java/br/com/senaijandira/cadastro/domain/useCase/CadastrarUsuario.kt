package br.com.senaijandira.cadastro.domain.useCase

import br.com.senaijandira.cadastro.domain.repository.UsuarioRepository
import br.com.senaijandira.cadastro.model.ApiResult
import br.com.senaijandira.cadastro.model.Usuario
import retrofit2.Callback

class CadastrarUsuario (
        val repository: UsuarioRepository,
        val callback: Callback<ApiResult>
) {

    fun execute(usuario:Usuario){
        repository
                .insert(usuario)
                .enqueue(callback)
    }
}