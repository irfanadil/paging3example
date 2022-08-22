package com.demo.characterdemoapp

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import timber.log.Timber
import java.lang.Exception

class CharactersPagingDataSource(private val service: ServerApi) :
    PagingSource<Int, CharacterDetail>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDetail> {
        val pageNumber = params.key ?: 1
        Timber.e("load $pageNumber")
        return try {

            val response = service.getCharacterById(pageNumber)
            val pagedResponse = response.body()
            val data = pagedResponse?.characterList
            Timber.tag("Api-loading = ").e(data.toString())

            var nextPageNumber: Int? = null
            if (pagedResponse?.pageInfo?.next != null) {
                val uri = Uri.parse(pagedResponse.pageInfo.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            LoadResult.Page(
                data = data.orEmpty(),
                prevKey = null,
                nextKey = nextPageNumber
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDetail>): Int = 1

}