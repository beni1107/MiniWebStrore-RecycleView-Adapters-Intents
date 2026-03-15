package com.example.miniwebstrore_recycleviewadaptersintents

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.attribute.PosixFileAttributeView

class ProductAdapter(val product_list: ArrayList<ProductModel>) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.product_item_layout,parent,false)
        return ProductHolder(v)
    }

    override fun onBindViewHolder(
        holder: ProductHolder,
        postion: Int
    ) {
        holder.itemImage.setImageResource(product_list.get(postion).productImage)
        holder.itemName.setText(product_list.get(postion).product_name)
    }

    override fun getItemCount(): Int {
        return product_list.size
    }


    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var itemImage : ImageView
        lateinit var itemName : TextView

        init{
            itemImage =itemView.findViewById<ImageView>(R.id.product_imageView)
            itemName = itemView.findViewById<TextView>(R.id.product_name)

            itemView.setOnClickListener {
                val position = adapterPosition
                if ( position != RecyclerView.NO_POSITION) {

                    val product = product_list[position]
                    val context = itemView.context
                    val intent = Intent(context, ProductListActivity::class.java)
                    intent.putExtra("product_name",product.product_name)
                    context.startActivity(intent)


                }

            }

        }
    }
}