package com.presldn.runescapevoiceofseren.view.ui.clans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.presldn.runescapevoiceofseren.R
import com.presldn.runescapevoiceofseren.util.Helper
import com.presldn.runescapevoiceofseren.view.ui.adapters.ClansListAdapter


class ClansFragment : Fragment() {

    private val clansViewModel: ClansViewModel by lazy {
        ViewModelProviders.of(this).get(ClansViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_clans, container, false)

        val recyclerView = root.findViewById(R.id.recyclerView) as RecyclerView

        val gridLayoutManager =
            GridLayoutManager(activity, 3, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = gridLayoutManager

        val adapter = ClansListAdapter()

        recyclerView.adapter = adapter

        clansViewModel.clans.observe(this, Observer {
            adapter.setClans(it)
        })

        val allClansInfo = root.findViewById(R.id.allClansInfo) as TextView

        allClansInfo.text = context?.resources?.getStringArray(R.array.all_clans_info)?.let {
            Helper.concatInfo(
                it
            )
        }

        return root
    }
}