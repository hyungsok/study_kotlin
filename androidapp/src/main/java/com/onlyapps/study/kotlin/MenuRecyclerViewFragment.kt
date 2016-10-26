package com.onlyapps.study.kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.SimpleOnItemTouchListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.onlyapps.study.kotlin.recyclerview.DividerItemDecoration
import com.onlyapps.study.kotlin.study.StudyLoopActivity
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
        recyclerview.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST))
        recyclerview.addOnItemTouchListener(SimpleOnItemTouchListener())
        (recyclerview.adapter as ListAdapter).onItemClickListener = {
            position ->
            Toast.makeText(activity, "Postion : " + position, Toast.LENGTH_SHORT).show()
                when(position) {
                    0 -> startActivity(Intent(activity, StudyLoopActivity::class.java))
                }
        }
    }

    fun getMenuLists(): ArrayList<String> {
        var lists = ArrayList<String>()
        lists.add("0. Loop Study")
        return lists
    }

    class ListAdapter(var context: Context, var lists: ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        var onItemClickListener: ((position: Int) -> Unit)? = null

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
            var v = LayoutInflater.from(context).inflate(R.layout.fragment_menu_recyclerview_item, parent, false)
            return Item(v, onItemClickListener)
        }

        override fun getItemCount(): Int {
            return lists.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            (holder as Item).bindData(position, lists[position])
        }

        class Item(itemView: View, var onItemClickListener: ((position: Int) -> Unit)?) : RecyclerView.ViewHolder(itemView) {
            fun bindData(position: Int, text: String) {
                itemView.textView.text = text
                itemView.textView.setOnClickListener{
                    onItemClickListener?.invoke(position)
                }
            }
        }
    }
}

