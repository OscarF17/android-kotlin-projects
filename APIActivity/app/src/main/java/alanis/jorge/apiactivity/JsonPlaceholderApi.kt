package alanis.jorge.apiactivity

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

// Interfaz para acceder a la API
// La API devuelve un arreglo de objetos [{},{},{}...]
// Definir respuesta como arreglo/lista de objetos para ajustarse al JSON recibido
interface JsonPlaceholderApi {
    @GET
    suspend fun getPosts(@Url url: String): Response<List<Post>>
}