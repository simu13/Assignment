package com.example.assignment.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.R
import kotlinx.android.synthetic.main.fragment_add_notes.view.*

class AddNotesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_add_notes, container, false)
        val database = activity?.let { ShoppingDatabase(it) }
        val repository =
            database?.let { ShoppingRepository(it) }
        val factory =
            repository?.let { ShoppingViewModelFactory(it) }
        val viewModel = factory?.let {
            ViewModelProvider(
                this,
                it
            ).get(ShoppingViewModel::class.java)
        }
        root.submit.setOnClickListener {
            val title = root.title.text
            val body = root.body.text
            val item = ShoppingItem(title.toString(),body.toString())
            viewModel?.upsert(item)

        }
        return root
    }
}