package com.miempresa.dem_whatsapp

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import android.view.*

import android.content.Intent
import android.graphics.BitmapFactory
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuprincipal,menu)
        return true
    }



    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: myViewAdapter

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar!!.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple)))

        tabLayout=findViewById(R.id.tab)
        viewPager2=findViewById(R.id.view)

        adapter=myViewAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter=adapter
        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->{
                    tab.text="Call"
                }
                1->{
                    tab.text="Chats"
                }
                2->{
                    tab.text="Contacts"
                }
            }
        }.attach()


        lista.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this);

        var llenarLista = ArrayList<Elementos>()
        for (i in 1 until 20){
            llenarLista.add(
                Elementos("Elementos"+i,

                    BitmapFactory.decodeResource(resources, R.drawable.perfil)))
        }

        val adapter = AdaptadorElementos(llenarLista)
        lista.adapter = adapter

        registerForContextMenu(lista)
    }
    }

