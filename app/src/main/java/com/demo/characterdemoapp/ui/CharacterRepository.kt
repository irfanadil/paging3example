package com.demo.characterdemoapp

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val service: ServerApi,
) {

    fun getAllCharacters(): LiveData<PagingData<CharacterDetail>> {
        return Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 2),
            pagingSourceFactory = { CharactersPagingDataSource(service) }
        ).liveData
    }
}