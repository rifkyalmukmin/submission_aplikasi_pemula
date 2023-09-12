package com.example.tour_bandung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tour_bandung.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Tour>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvTour.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this@MainActivity, MyAbout::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListHeroes(): ArrayList<Tour> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_Photo)
        val listTour = ArrayList<Tour>()
        for (i in dataName.indices) {
            val tour = Tour(
                dataName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1)
            )
            listTour.add(tour)
        }
        return listTour
    }

    private fun showRecyclerList() {
        binding.rvTour.layoutManager = LinearLayoutManager(this)
        val listTourAdapter = ListTourAdapter(list)
        binding.rvTour.adapter = listTourAdapter
    }

}

