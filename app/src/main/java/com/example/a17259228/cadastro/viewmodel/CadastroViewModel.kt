package com.example.a17259228.cadastro.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.SystemClock
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CadastroViewModel : ViewModel(){

    val loading = MutableLiveData<Boolean>();

    fun cadastrarUser(){
        loading.postValue(true)

        //Efetuar cadastro em si
        doAsync {
            SystemClock.sleep(2000)

            uiThread {
                cadastroUsuarioSucesso()
            }
        }

    }

    fun cadastroUsuarioSucesso(){
        loading.postValue(false)
    }
}