package com.demo.characterdemoapp

import com.google.gson.annotations.SerializedName

data class CharacterApiResponse(
    @SerializedName("info") val pageInfo: PageInfo ,
    @SerializedName("results") val characterList: List<CharacterDetail>
)

data class PageInfo(
    val count: Int? = null,
    val next: String? = null,
    val pages: Int? = null,
    val prev: String?= null
)

data class CharacterDetail(
    val created: String? = null,
    val episode: List<String>? = null,
    val gender: String?= null,
    val id: Int? = null,
    val image: String? = null,
    val location: Location? = null,
    val name: String? = null,
    val origin: Origin? = null,
    val species: String? = null,
    val status: String? = null,
    val type: String? = null,
    val url: String? = null
)



data class Location(
    val name: String?=null,
    val url: String?=null
)

data class Origin(
    val name: String?=null,
    val url: String?=null
)