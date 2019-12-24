package com.example.bdt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class bdViewModeld(application: Application) : AndroidViewModel(application){
    private val repository: bdRepository

    val allBDs: LiveData<List<DB>>

    init {
        val bddao = bdDatabase.getInstance(application).bdDao()
        repository = bdRepository(bddao)
        allBDs = repository.alldb
    }

    fun insertBD(db: DB) = viewModelScope.launch {
        repository.insertBD(db)
    }
}