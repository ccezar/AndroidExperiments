package com.example.ccezar.samplebaseactivity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : BaseActivity() {
    private var feeds = mutableListOf<Feed>()
    private var adapter: FeedAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        this.title = "ListView"

        listFeeds()

        adapter = FeedAdapter(this, feeds.toMutableList())
        feeds_list_view.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }

    fun listFeeds() {
        feeds.add(Feed("AUTOR", "", "TITULO", "", "URL"))
        feeds.add(Feed("AUTOR", "", "TITULO", "", "URL"))
        feeds.add(Feed("AUTOR", "", "TITULO", "", "URL"))
        feeds.add(Feed("AUTOR", "", "TITULO", "", "URL"))
        feeds.add(Feed("AUTOR", "", "TITULO", "", "URL"))
    }
}

class Feed {
    var articleAuthor: String? = ""
    var articleBackgroundImage: String? = ""
    var articleName: String? = ""
    var articleStoreLogo: String? = ""
    var articleURL: String? = ""

    constructor()

    constructor(articleAuthor: String,
                articleBackgroundImage: String,
                articleName: String,
                articleStoreLogo: String,
                articleURL: String) {
        this.articleAuthor = articleAuthor
        this.articleBackgroundImage = articleBackgroundImage
        this.articleName = articleName
        this.articleStoreLogo = articleStoreLogo
        this.articleURL = articleURL
    }

}