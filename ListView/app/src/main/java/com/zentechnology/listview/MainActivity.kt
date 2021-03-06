package com.zentechnology.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.recipe_list_view)

        val recipeList = Recipe.getRecipesFromFile("recipes.json", this)

        val adapter = RecipeAdapter(this, recipeList)
        listView.adapter = adapter

        val context = this

        listView.setOnItemClickListener{ _,_, position,_->
            val selectedRecipe = recipeList[position]
            val detailIntent = RecipeDetailActivity.newIntent(context, selectedRecipe)
            startActivity(detailIntent)

        }
    }
}
