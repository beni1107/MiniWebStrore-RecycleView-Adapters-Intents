package com.example.miniwebstrore_recycleviewadaptersintents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CartAdapter(val cart_items : ArrayList<CartModel>) :
RecyclerView.Adapter<CartAdapter.CartItemHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewGroup: Int
    ): CartItemHolder {
        return CartItemHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_item_layout,parent,false)
        )
    }

    override fun onBindViewHolder(
        holder: CartItemHolder,
        position: Int
    ) {
        holder.itemImage.setImageResource(cart_items[position].cartItem_Image)
        holder.itemTitle.text = cart_items[position].cartItem_Name
        holder.itemPrice.text = cart_items[position].cartItem_Price
    }

    override fun getItemCount(): Int {
        return cart_items.size
    }

    // inner class holder
    inner class CartItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var itemImage: ImageView
        lateinit var itemTitle: TextView
        lateinit var itemPrice : TextView

        init {
            itemImage = itemView.findViewById<ImageView>(R.id.cart_item_image)
            itemTitle = itemView.findViewById<TextView>(R.id.cart_item_title)
            itemPrice = itemView.findViewById<TextView>(R.id.cart_item_price)
        }
    }
}