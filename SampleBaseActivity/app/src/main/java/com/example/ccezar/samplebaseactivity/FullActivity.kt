package com.example.ccezar.samplebaseactivity

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_full.*

class FullActivity : AppCompatActivity() {
    private var feeds = mutableListOf<Feed>()
    private var adapter: FeedAdapter? = null
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full)
        this.title = "FullActivity"

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayoutFull!!, R.string.app_name, R.string.app_name)

        listFeeds()
        configureMenu()

        adapter = FeedAdapter(this, feeds.toMutableList())
        feeds_full_list_view.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }

    fun listFeeds() {
        feeds.add(Feed("AUTOR", "", "TITULO", "", "URL"))
        feeds.add(Feed("AUTOR", "", "TITULO", "", "URL"))
        feeds.add(Feed("AUTOR", "", "TITULO", "", "URL"))
        feeds.add(Feed("AUTOR", "", "TITULO", "", "URL"))
        feeds.add(Feed("AUTOR", "", "TITULO", "", "URL"))
    }

    private fun configureMenu() {
        drawerLayoutFull!!.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        navigation_view_full!!.setNavigationItemSelectedListener { item ->
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

            drawerLayoutFull!!.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle!!.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }
}
