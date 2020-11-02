package com.example.assignment.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assignment.R
import com.example.assignment.home.HomeIcons
import com.example.assignment.home.ItemAdapter
import kotlinx.android.synthetic.main.fragment_library.view.*

class LibraryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_library, container, false)
        root.rvClassList.layoutManager = GridLayoutManager(activity, 2)
        val classAdapter = activity?.let { ClassAdapter(it, getItemsList()) }
        root.rvClassList.adapter = classAdapter
        classAdapter?.setOnClickListener(object :
            ClassAdapter.OnClickListener {
            override fun onClick(position: Int, model: Icons) {
                when(position){
                    0,1,2,3,4,5,6 -> view?.let { Navigation.findNavController(it).navigate(R.id.action_libraryFragment_to_notesFragment2) }
                }

            }
        })
        return root
    }


    private fun getItemsList(): ArrayList<Icons> {
        val list = ArrayList<Icons>()
        // 1
        val item1 = Icons(
            R.drawable.six,
        )

        list.add(item1)

        // 2
        val item2 = Icons(
            R.drawable.seven,
        )

        list.add(item2)

        // 3
        val item3 = Icons(
            R.drawable.eight,
        )

        list.add(item3)

        // 4
        val item4 = Icons(
            R.drawable.nine,
        )

        list.add(item4)

        // 5
        val item5 = Icons(
            R.drawable.ten,
        )

        list.add(item5)

        // 6
        val item6 = Icons(
            R.drawable.eleven,
        )

        list.add(item6)

        // 7
        val item7 = Icons(
            R.drawable.twelve,
        )

        list.add(item7)



        return list
    }
}