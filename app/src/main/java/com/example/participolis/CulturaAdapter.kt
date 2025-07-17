package com.example.participolis

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CulturaAdapter(private val context: Context, private val items: List<Pair<String, String>>) : BaseAdapter() {

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_cultura, parent, false)
            holder = ViewHolder()
            holder.title = view.findViewById(R.id.textViewCulturaTitulo)
            holder.subject = view.findViewById(R.id.textViewCulturaAsunto)
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val item = items[position]
        holder.title?.text = item.first
        holder.subject?.text = item.second

        view.setOnClickListener {
            val intent = Intent(context, ChatCulturaForo::class.java)
            intent.putExtra("chatKey", "${item.first}_${item.second}")
            context.startActivity(intent)
        }

        return view
    }

    private class ViewHolder {
        var title: TextView? = null
        var subject: TextView? = null
    }
}
