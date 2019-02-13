package br.com.senaijandira.cadastro.data.retrofit

import br.com.senaijandira.cadastro.data.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

class RetrofitFactory {

    private fun retrofit() =
            Retrofit.Builder()
                    .baseUrl("http://10.0.2.2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


    fun createApiService()=
            retrofit().create(ApiService::class.java)



}