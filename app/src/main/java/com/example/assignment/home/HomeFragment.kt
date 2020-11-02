package com.example.assignment.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    var TAG = "MAIN_ACTIVITY"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        // Set the LayoutManager that this RecyclerView will use.
        root.rvItemsList.layoutManager = GridLayoutManager(activity, 4)
        // Adapter class is initialized and list is passed in the param.
        val itemAdapter = activity?.let { ItemAdapter(it, getItemsList()) }
        // adapter instance is set to the recyclerview to inflate the items.
        root.rvItemsList.adapter = itemAdapter
        itemAdapter?.setOnClickListener(object :
            ItemAdapter.OnClickListener {
            override fun onClick(position: Int, model: HomeIcons) {
                when(position){
                    0 -> view?.let { Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_notesFragment) }
                }
            }
        })

        return root
    }



    private fun getItemsList(): ArrayList<HomeIcons> {
        val list = ArrayList<HomeIcons>()
         // 1
        val item1 = HomeIcons(
            "My Notes",
            R.drawable.ic_add_note,
        )

        list.add(item1)

        // 2
        val item2 = HomeIcons(
            "NCERT ",
            R.drawable.ic_books,
        )

        list.add(item2)

        // 3
        val item3 = HomeIcons(
            "JEE-NEET",
            R.drawable.ic_exam,
        )

        list.add(item3)

        // 4
        val item4 = HomeIcons(
            "WhatsApp",
            R.drawable.ic_whatsapp,
        )

        list.add(item4)

        // 5
        val item5 = HomeIcons(
            "NCERT",
            R.drawable.ic_add,
        )

        list.add(item5)

        // 6
        val item6 = HomeIcons(
            "Maths",
            R.drawable.ic_maths,
        )

        list.add(item6)

        // 7
        val item7 = HomeIcons(
            "Live Class",
            R.drawable.ic_online_class,
        )

        list.add(item7)

        // 8
        val item8 = HomeIcons(
            "Topics",
            R.drawable.ic_document,
        )

        list.add(item8)

        return list
    }
}