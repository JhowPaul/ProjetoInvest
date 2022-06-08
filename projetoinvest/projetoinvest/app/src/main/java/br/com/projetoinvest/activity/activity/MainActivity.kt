package br.com.projetoinvest.activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import br.com.projetoinvest.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var toolBar: Toolbar?= null
    private  var fragmentHost: Fragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolBar= findViewById(R.id.Toolbar) as Toolbar
        fragmentHost= supportFragmentManager.findFragmentById(R.id.fragmentNavHost)

        setUpToolBar()

    }

    private fun setUpToolBar(){
        setSupportActionBar(toolBar)

        navController=fragmentHost?.findNavController()!!
        appBarConfiguration= AppBarConfiguration(navController.graph)

        setupActionBarWithNavController(navController, appBarConfiguration)

    }
}