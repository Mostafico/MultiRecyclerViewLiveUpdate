package com.devgeeks.multirecyclerviewliveupdate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var adapter: FirestoreRecyclerAdapter<Order, OrderViewHolder>? = null
    private var adapter2: FirestoreRecyclerAdapter<Order, OrderViewHolder>? = null
    private var adapter3: FirestoreRecyclerAdapter<Order, OrderViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerViews()
    }

    private fun initRecyclerViews() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView3.layoutManager = LinearLayoutManager(this)

        initFireStore()
    }

    private fun initFireStore() {
        val ref = FirebaseFirestore.getInstance().collection("orders")
        val query1 = ref.whereEqualTo("status", "posted")
        val query2 = ref.whereEqualTo("status", "accepted")
        val query3 = ref.whereEqualTo("status", "delivered")

        val options = FirestoreRecyclerOptions.Builder<Order>().setQuery(query1, Order::class.java).build()
        val options2 = FirestoreRecyclerOptions.Builder<Order>().setQuery(query2, Order::class.java).build()
        val options3 = FirestoreRecyclerOptions.Builder<Order>().setQuery(query3, Order::class.java).build()

        adapter = object : FirestoreRecyclerAdapter<Order, OrderViewHolder>(options){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
                val view: View = LayoutInflater.from(this@MainActivity).inflate(R.layout.list_item_status, parent, false)
                return OrderViewHolder(view)
            }

            override fun onBindViewHolder(holder: OrderViewHolder, position: Int, model: Order) {
                holder.setOrderID(model.id)
            }
        }

        adapter2 = object : FirestoreRecyclerAdapter<Order, OrderViewHolder>(options2){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
                val view: View = LayoutInflater.from(this@MainActivity).inflate(R.layout.list_item_status, parent, false)
                return OrderViewHolder(view)
            }

            override fun onBindViewHolder(holder: OrderViewHolder, position: Int, model: Order) {
                holder.setOrderID(model.id)
            }
        }

        adapter3 = object : FirestoreRecyclerAdapter<Order, OrderViewHolder>(options3){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
                val view: View = LayoutInflater.from(this@MainActivity).inflate(R.layout.list_item_status, parent, false)
                return OrderViewHolder(view)
            }

            override fun onBindViewHolder(holder: OrderViewHolder, position: Int, model: Order) {
                holder.setOrderID(model.id)
            }
        }

        adapter!!.startListening()
        recyclerView.adapter = adapter

        adapter2!!.startListening()
        recyclerView2.adapter = adapter2

        adapter3!!.startListening()
        recyclerView3.adapter = adapter3

    }

    override fun onStart() {
        super.onStart()
    }
}