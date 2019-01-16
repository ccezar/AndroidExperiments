package com.example.ccezar.samplebaseactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class FeedAdapter (private val context: Context,
                   private val dataSource: MutableList<Feed>) : BaseAdapter() {

    private val inflater: LayoutInflater
           = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    fun updateList(feeds: List<Feed>) {
        dataSource.clear()
        dataSource.addAll(feeds)
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item_feed, parent, false)

            holder = ViewHolder()
            holder.titleTextView = view.findViewById(R.id.feed_listitem_title) as TextView
            holder.authorTextView = view.findViewById(R.id.feed_listitem_author) as TextView
            holder.logoImageView = view.findViewById(R.id.feed_listitem_logo) as ImageView
            holder.backgroundImageView = view.findViewById(R.id.feed_listitem_background_image) as ImageView

            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val titleTextView = holder.titleTextView
        val authorTextView = holder.authorTextView
        val logoImageView = holder.logoImageView
        val backgroundImageView = holder.backgroundImageView

        val feed = getItem(position) as Feed

        titleTextView.text = feed.articleName
        authorTextView.text = feed.articleAuthor

        return view
    }

    private class ViewHolder {
        lateinit var titleTextView: TextView
        lateinit var authorTextView: TextView
        lateinit var logoImageView: ImageView
        lateinit var backgroundImageView: ImageView
    }
}