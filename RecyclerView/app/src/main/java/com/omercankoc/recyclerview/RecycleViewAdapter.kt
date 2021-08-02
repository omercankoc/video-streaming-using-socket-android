package com.omercankoc.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omercankoc.recyclerview.databinding.RecyclerRowBinding

class RecycleViewAdapter(private val languageList : ArrayList<Languages>) : RecyclerView.Adapter<RecycleViewAdapter.LanguageHolder>() {

    // Ilgili view'in tutucu nesnesi.
    class LanguageHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) { }

    // View holder olusturuldugunda layout'un view'larini bagla.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LanguageHolder(binding)
    }

    // Baglandiktan sonra ilgili view'a ilgili data'yi aktar.
    override fun onBindViewHolder(holder: LanguageHolder, position: Int) {
        holder.binding.textViewRecycleItem.text = languageList[position].language

        // Item'e tikladiginda ilgili nesnenin detay sayfasina git.
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)

            // Veriyi Intent ile yolla.
            //intent.putExtra("language", languageList[position])

            // Veriyi Singleton ile yolla.
            Singleton.chosenLanguage = languageList[position]

            holder.itemView.context.startActivity(intent)
        }
    }

    // Olusturulacak recycler view sayisini elde et.
    override fun getItemCount(): Int {
        return languageList.size
    }
}