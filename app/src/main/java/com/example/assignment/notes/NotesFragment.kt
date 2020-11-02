package com.example.assignment.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.R
import kotlinx.android.synthetic.main.fragment_notes.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_notes, container, false)
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

        val adapter = viewModel?.let {
            ShoppingItemAdapter(
                listOf(),
                it
            )
        }

        root.rvShoppingItems.layoutManager = LinearLayoutManager(activity)
        root.rvShoppingItems.adapter = adapter

        viewModel?.getAllShoppingItems()?.observe(viewLifecycleOwner, Observer{
            adapter?.items = it
            adapter?.notifyDataSetChanged()
        })

        root.fab.setOnClickListener{
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_notesFragment_to_addNotesFragment) }
        }
        return root
    }
}