package com.zentechnology.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.*
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    lateinit var adapter: ArrayAdapter<*>
    lateinit var listView: ListView
    lateinit var emptyView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        listView = findViewById(R.id.listView)
        emptyView = findViewById(R.id.emptyView)

        adapter = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.months_array))

        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener {
            adapterView, _, position, _ ->
                Toast.makeText(this,
                    adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        val search = menu.findItem(R.id.appSearchBar)
        val searchView = search.actionView as SearchView

        searchView.queryHint = "Search"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }
}
