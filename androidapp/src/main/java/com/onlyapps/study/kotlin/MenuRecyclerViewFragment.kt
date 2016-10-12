package com.onlyapps.study.kotlin

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_menu_recyclerview.*
import kotlinx.android.synthetic.main.fragment_menu_recyclerview_item.view.*
import java.util.*

/**
 * Created by hyungsoklee on 2016. 10. 12..
 */
class MenuRecyclerViewFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_menu_recyclerview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = ListAdapter(context, getMenuLists())
        recyclerview.setHasFixedSize(true)
    }

    fun getMenuLists(): ArrayList<String> {
        var lists = ArrayList<String>()
        lists.add("JAVA")
        lists.add("KOTLIN")
        lists.add("PHP")
        lists.add("SWIFT")
        lists.add("JAVA Script")
        lists.add("MYSQL")
        return lists
    }

    class ListAdapter(var context: Context, var lists: ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
            var v = LayoutInflater.from(context).inflate(R.layout.fragment_menu_recyclerview_item, parent, false)
            return Item(v)
        }

        override fun getItemCount(): Int {
            return lists.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            (holder as Item).bindData(lists[position])
        }

        class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bindData(text: String) {
                itemView.textView.text = text
            }
        }
    }
}

