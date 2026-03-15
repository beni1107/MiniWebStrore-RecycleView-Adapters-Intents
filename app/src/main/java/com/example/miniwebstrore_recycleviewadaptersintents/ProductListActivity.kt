package com.example.miniwebstrore_recycleviewadaptersintents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_list)

        val product = intent.getStringExtra("product_name") ?: " No category"
        findViewById<TextView>(R.id.product_list_title).setText(product)


       val laptops: ArrayList<ProductDetailModel> = arrayListOf(
           ProductDetailModel(
               R.drawable.asus1,
               "Asus Zenbook",
               "Asus the best line",
               "1200 eur",
           ),
           ProductDetailModel(
               R.drawable.asus2,
               "Asus Zenbook X",
               "Asus X Line",
               "1500 eur",
           ),
           ProductDetailModel(
               R.drawable.lenovo1,
               "Lenovo ThinkPand",
               "Performance laptop",
               "2200 eur",
           ),
           ProductDetailModel(
               R.drawable.lenovo2,
               "Lenovo IdeaPad",
               "For everyday Users",
               "1200 eur",
           ),
           ProductDetailModel(
               R.drawable.lenovo3,
               "Lenovo X-Carbon",
               "Top of the top ",
               "3200 eur",
           ),
           ProductDetailModel(
               R.drawable.dell1,
               "Dell XPS",
               "Dev machine",
               "2200 eur",
           ),
           ProductDetailModel(
               R.drawable.dell2,
               "Dell blabla",
               "Everyday Joes best friend",
               "700 eur",
           ),

       )
        val recyclerView = findViewById<RecyclerView>(R.id.product_list_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductDetailListAdapter(laptops)

        val openCartButton = findViewById<Button>(R.id.open_cart_button)
        openCartButton.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)

        }


    }
}