package com.example.miniwebstrore_recycleviewadaptersintents

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //initialize recyclerView
        val recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.main_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        // DATA SOURCE
        var categories: ArrayList<CategoryModel> = arrayListOf(
            CategoryModel(R.drawable.electronics,"Electronics"),
            CategoryModel(R.drawable.clothes,"Clothes"),
            CategoryModel(R.drawable.food,"Food"),
            CategoryModel(R.drawable.books,"Books")
        )

        recyclerView.adapter = CategoryAdapter(categories)

    }
}