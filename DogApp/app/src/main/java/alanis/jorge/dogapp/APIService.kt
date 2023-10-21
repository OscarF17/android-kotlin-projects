package alanis.jorge.dogapp

import retrofit2.http.GET
import retrofit2.http.Url
import retrofit2.Response

interface APIService {
    @GET
    suspend fun getDogsByBreeds(@Url url:String): Response<DogResponse>
}