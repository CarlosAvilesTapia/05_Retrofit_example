package cl.cat2814.a05retrofitexample.data

import cl.cat2814.a05retrofitexample.data.remote.ApiLand
import cl.cat2814.a05retrofitexample.data.remote.Land

class LandRepository(private val apiLand: ApiLand) {

    suspend fun getLand(): List<Land> {
        val response = apiLand.getData()
        if (response.isSuccessful) {
            val responseLand = response.body()
            responseLand?.let {
                return it
            }
        }
        return emptyList()
    }
}