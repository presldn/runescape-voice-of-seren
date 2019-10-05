package com.presldn.runescapevoiceofseren.view.ui.adapters

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.presldn.runescapevoiceofseren.R
import com.presldn.runescapevoiceofseren.model.Clan
import com.presldn.runescapevoiceofseren.util.Helper

class ClansListAdapter : RecyclerView.Adapter<ClansListAdapter.ViewHolder>() {

    private lateinit var context: Context

    private var clans: List<Clan> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.clan_grid_item,
                parent,
                false
            )
        )
    }

    fun setClans(clans: List<Clan>) {
        this.clans = clans
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = clans.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val clan = clans[position]

        val clanName = context.getString(clan.name)

        val info = context.resources.getStringArray(clan.info)

        holder.name.text = clanName
        holder.symbol.setImageResource(clan.symbol)


        holder.view.setOnClickListener {
            AlertDialog.Builder(context)
                .setTitle(clanName)
                .setMessage(Helper.concatInfo(info))
                .setPositiveButton("Dismiss", null)
                .show()
        }
    }


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val symbol = view.findViewById(R.id.clanSymbol) as ImageView
        val name = view.findViewById(R.id.clanName) as TextView
    }

}