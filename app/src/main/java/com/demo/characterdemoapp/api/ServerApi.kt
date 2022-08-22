package com.demo.characterdemoapp


import retrofit2.Response
import retrofit2.http.*

interface ServerApi {

    @GET("api/character/")
    suspend fun getCharacterById(@Query("page") page: Int): Response<CharacterApiResponse>

    suspend fun getMultipleCharacters(ids: List<Int>)

}


