package com.presldn.runescapevoiceofseren.view.ui.clans

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.presldn.runescapevoiceofseren.R
import com.presldn.runescapevoiceofseren.model.Clan

class ClansViewModel : ViewModel() {

    private val _clans = MutableLiveData<List<Clan>>().apply {
        value = arrayListOf(
            Clan(R.drawable.cadarn_clan, R.string.cadarn_name, R.array.cadarn_info),
            Clan(R.drawable.amlodd_clan, R.string.amlodd_name, R.array.amlodd_info),
            Clan(R.drawable.trahaearn_clan, R.string.trahaearn_name, R.array.trahaearn_info),
            Clan(R.drawable.meilyr_clan, R.string.meilyr_name, R.array.meilyr_info),
            Clan(R.drawable.crwys_clan, R.string.crwys_name, R.array.crwys_info),
            Clan(R.drawable.ithell_clan, R.string.ithell_name, R.array.ithell_info),
            Clan(R.drawable.iorwerth_clan, R.string.iorwerth_name, R.array.iorwerth_info),
            Clan(R.drawable.hefin_clan, R.string.hefin_name, R.array.hefin_info)
        )
    }

    val clans: LiveData<List<Clan>> = _clans


}