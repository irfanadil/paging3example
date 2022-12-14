package com.demo.characterdemoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val characterRepository: CharacterRepository) : ViewModel() {

    fun getCharacterList(): LiveData<PagingData<CharacterDetail>> {
        return characterRepository.getAllCharacters().cachedIn(viewModelScope)
    }

}