package com.example.miniwebstrore_recycleviewadaptersintents

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
        Toast.makeText(this, "Cart size: ${Cart.cart_items.size}", Toast.LENGTH_SHORT).show()

        val cartRecyclerView = findViewById<RecyclerView>(R.id.cart_recyclerview)
        cartRecyclerView.layoutManager = LinearLayoutManager(this)
        cartRecyclerView.adapter = CartAdapter(Cart.cart_items)

        var sum = 0
        Cart.cart_items.forEach {
            val priceInt = it.cartItem_Price.replace(" eur","").toInt()
            sum += priceInt
        }
        findViewById<TextView>(R.id.cart_price_sum).text = "$sum €"
    }
}