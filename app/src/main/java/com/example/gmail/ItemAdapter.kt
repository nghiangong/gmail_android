package com.example.gmail

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView

class ItemAdapter(val items: ArrayList<ItemModel>): BaseAdapter() {
    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item, parent, false)

            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder
        }
        viewHolder.textN.text = items[position].name[0].toString()
        viewHolder.textName.text = items[position].name
        viewHolder.textContent.text = items[position].content
        viewHolder.textTime.text = items[position].time
        viewHolder.checkSelected.isChecked = items[position].selected

        viewHolder.checkSelected.setOnClickListener {
            items[position].selected = (it as CheckBox).isChecked
            notifyDataSetChanged()
        }

        return itemView
    }

    class ViewHolder(itemView: View) {
        val textN: TextView
        val textName: TextView
        val textContent: TextView
        val textTime: TextView
        val checkSelected: CheckBox
        init {
            textN = itemView.findViewById(R.id.text_n)
            textName = itemView.findViewById(R.id.text_name)
            textContent = itemView.findViewById(R.id.text_content)
            textTime = itemView.findViewById(R.id.text_time)
            checkSelected = itemView.findViewById(R.id.check_selected)
        }
    }
}