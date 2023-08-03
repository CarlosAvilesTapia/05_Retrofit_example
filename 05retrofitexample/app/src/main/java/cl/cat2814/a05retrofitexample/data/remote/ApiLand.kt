package cl.cat2814.a05retrofitexample.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ApiLand {
    @GET("realestate")
    suspend fun getData(): Response<List<Land>>
}