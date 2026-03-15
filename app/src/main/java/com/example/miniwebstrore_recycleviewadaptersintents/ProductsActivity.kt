package com.example.miniwebstrore_recycleviewadaptersintents

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)

        val category = intent.getStringExtra("category_name") ?: " no category"
        findViewById<TextView>(R.id.products_textTitle).setText(category)
        val products = when(category) {
            "Electronics" -> arrayListOf<ProductModel>(
                ProductModel(R.drawable.camera,"Cameras"),
                ProductModel(R.drawable.headphones,"Headphones"),
                ProductModel(R.drawable.laptop,"Laptops"),
                ProductModel(R.drawable.phone,"Phones"),
                ProductModel(R.drawable.mouse,"Mouse"),
                ProductModel(R.drawable.smartwatch,"SmartWatches"),
                ProductModel(R.drawable.keyboard,"Keyboards"),
            )
            "Food" -> arrayListOf<ProductModel>(
                ProductModel(R.drawable.pommes,"Pommes"),
                ProductModel(R.drawable.beef,"Beef dishes"),
                ProductModel(R.drawable.friedchicken,"Chicken dishes"),
                ProductModel(R.drawable.hamburger,"Burgers"),
                ProductModel(R.drawable.fish,"Fishes"),
                ProductModel(R.drawable.pasta,"Pastas"),
                ProductModel(R.drawable.steak,"Steaks"),
                ProductModel(R.drawable.salate,"Salads"),
            )
            "Books" -> arrayListOf<ProductModel>(
                ProductModel(R.drawable.harrypotter,"Harry Potter"),
                ProductModel(R.drawable.gameofthrones,"Game of Thrones"),
                ProductModel(R.drawable.lordoftherings,"LOTR"),
                ProductModel(R.drawable.thehobbit,"The hobbit"),
                ProductModel(R.drawable.witcher,"Witcher"),
                ProductModel(R.drawable.narnia,"Narnia"),
            )
            "Clothes" -> arrayListOf<ProductModel>(
                ProductModel(R.drawable.jeans,"Jeans"),
                ProductModel(R.drawable.tshirt,"T-shirts"),
                ProductModel(R.drawable.shirt,"Shirts"),
                ProductModel(R.drawable.skirt,"Skirts"),
                ProductModel(R.drawable.jumper,"Jumpers"),
                ProductModel(R.drawable.sweatshirt,"Sweatshirts"),
                ProductModel(R.drawable.socks,"Socks"),
            )
            else -> arrayListOf()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.product_recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(products)


    }
}