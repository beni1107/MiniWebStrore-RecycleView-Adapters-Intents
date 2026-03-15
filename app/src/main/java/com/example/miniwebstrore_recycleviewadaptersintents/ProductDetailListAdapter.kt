package com.example.miniwebstrore_recycleviewadaptersintents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ProductDetailListAdapter (val product_detail_list: ArrayList<ProductDetailModel>)
    : Adapter<ProductDetailListAdapter.ProductDetailHolder>(){

    //inner class for holding reference
    inner class ProductDetailHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
            lateinit var productDetail_Image: ImageView
            lateinit var productDetail_Title: TextView
            lateinit var productDetail_Description : TextView

            lateinit var productDetail_Price : TextView

            var productDetail_AddToCartButton = itemView.findViewById<Button>(R.id.product_detail_addToCartButton)

            init{

                productDetail_Image = itemView.findViewById<ImageView>(R.id.cart_item_image)
                productDetail_Title = itemView.findViewById<TextView>(R.id.cart_item_title)
                productDetail_Description = itemView.findViewById<TextView>(R.id.product_detail_description)
                productDetail_Price = itemView.findViewById<TextView>(R.id.cart_item_price)


                //Add to cart

            }
    }




   //inflate holder with XML
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductDetailHolder {

       return ProductDetailHolder(
           LayoutInflater.from(parent.context)
               .inflate(
                   R.layout.product_detail_item,
                   parent,
                   false
               )
       )
    }

    override fun onBindViewHolder(
        holder: ProductDetailHolder,
        position: Int
    ) {
        holder.productDetail_Image.setImageResource(
            product_detail_list.get(position).productDetail_Image)

        holder.productDetail_Title.text =
            product_detail_list[position].productDetail_Title

        holder.productDetail_Description.text =
            product_detail_list[position].productDetail_Description

        holder.productDetail_Price.text =
            product_detail_list[position].productDetail_Price

        holder.productDetail_AddToCartButton.setOnClickListener {

        val product = product_detail_list[position]
            val item = CartModel (
                cartItem_Image = product.productDetail_Image,
                cartItem_Name = product.productDetail_Title,
                cartItem_Price = product.productDetail_Price
            )

            Cart.cart_items.add(item)

            Toast.makeText(holder.itemView.context,
                "${product_detail_list.get(position).productDetail_Title} added to cart", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return product_detail_list.size
    }



}