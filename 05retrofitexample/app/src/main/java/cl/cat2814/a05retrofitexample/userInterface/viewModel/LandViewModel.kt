package cl.cat2814.a05retrofitexample.userInterface.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.cat2814.a05retrofitexample.data.LandRepository
import cl.cat2814.a05retrofitexample.data.local.LandDatabase
import cl.cat2814.a05retrofitexample.data.remote.Land
import cl.cat2814.a05retrofitexample.data.remote.RetrofitClientWtf
import kotlinx.coroutines.launch

class LandViewModel(application: Application) : AndroidViewModel(application) {

    private val landRepository: LandRepository
    fun liveDataLands() = landRepository.getLands()

    init {
        val api = RetrofitClientWtf.getRetrofitClient()
        val landDatabase = LandDatabase.getDatabase(application).getLandsDao()
        landRepository = LandRepository(api, landDatabase)
    }

    fun getAllLands() = viewModelScope.launch {
        landRepository.loadLands()
    }
}