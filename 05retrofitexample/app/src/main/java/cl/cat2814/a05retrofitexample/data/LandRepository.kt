package cl.cat2814.a05retrofitexample.data

import androidx.lifecycle.LiveData
import cl.cat2814.a05retrofitexample.data.local.LandDao
import cl.cat2814.a05retrofitexample.data.local.LandEntity
import cl.cat2814.a05retrofitexample.data.remote.ApiLand
import cl.cat2814.a05retrofitexample.data.remote.Land

class LandRepository(
    private val apiLand: ApiLand,
    private val landDao: LandDao
) {

    fun getLands(): LiveData<List<LandEntity>> = landDao.getAllLands()

    suspend fun loadLands() {
        val response = apiLand.getData()
        if (response.isSuccessful) {
            val responseLand = response.body()
            responseLand?.let { lands ->
                val landsEntity = lands.map { it.toEntity() }
                landDao.insertLands(landsEntity)
            }
        }
    }
}

fun Land.toEntity(): LandEntity = LandEntity(this.id, this.price, this.type, this.imgUrl)