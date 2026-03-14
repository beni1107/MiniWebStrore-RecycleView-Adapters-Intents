package com.example.miniwebstrore_recycleviewadaptersintents

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    val category_items : ArrayList<CategoryModel>
) : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {


    //inner class holder
    inner class CategoryHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            lateinit var itemImage: ImageView
            lateinit var itemTitle: TextView
        init {
             itemImage = itemView.findViewById<ImageView>(R.id.category_imageView)
             itemTitle = itemView.findViewById<TextView>(R.id.category_textView)


            itemView.setOnClickListener {
                val position = adapterPosition
                if ( position != RecyclerView.NO_POSITION) {
                    val clickedCategory = category_items[position]

                    val context = itemView.context
                    val intent = Intent(context, ProductsActivity::class.java)
                    intent.putExtra("category_name",clickedCategory.category_name)

                    context.startActivity(intent)

                }
            }

        }
    }


    //Creates layout for one item...inflate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {

         val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.categories_item_layout,parent,false)
        return CategoryHolder(v)

    }
    //binds data to viewHolder at specific position
    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {

        holder.itemImage.setImageResource(category_items.get(position).imageView)
        holder.itemTitle.setText(category_items.get(position).category_name)
    }

    override fun getItemCount(): Int {
        return category_items.size
    }


}