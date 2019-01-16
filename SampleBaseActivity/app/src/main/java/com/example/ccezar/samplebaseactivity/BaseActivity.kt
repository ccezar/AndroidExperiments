package com.example.ccezar.samplebaseactivity

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_base.*

open class BaseActivity : AppCompatActivity() {
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_base)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout!!, R.string.app_name, R.string.app_name)

        configureMenu()
    }
    override fun setContentView(layoutResID: Int) {
        layoutInflater.inflate(layoutResID, frame_container, true)
    }

    private fun configureMenu() {
        drawerLayout!!.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        navigation_view!!.setNavigationItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                R.id.itemHome -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                R.id.itemListView -> {
                    val intent = Intent(this, ListViewActivity::class.java)
                    startActivity(intent)
                }

                R.id.itemFullActivity -> {
                    val intent = Intent(this, FullActivity::class.java)
                    startActivity(intent)
                }
            }

            drawerLayout!!.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle!!.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }
}
