package com.example.assignment.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_notes2.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotesFragment : Fragment() {
    private val personCollectionRef = FirebaseFirestore.getInstance()
    private lateinit var userAdapter: NotesAdapter
    private var mUsers: List<Document>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_notes2, container, false)
        retrieveAllUsers()
        mUsers = ArrayList()
        return root
    }
    private fun retrieveAllUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                //val currentUsersId = FirebaseAuth.getInstance().currentUser!!.uid
                val querySnapshot = personCollectionRef.collection("docs")

                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result)  {
                            val boards = document.toObject(Document::class.java)
                            (mUsers as ArrayList<Document>).add(boards)
                            userAdapter =
                                activity?.let {
                                    NotesAdapter(
                                        it,
                                        mUsers!!
                                    )
                                }!!
                            search.adapter = userAdapter
                            search.layoutManager = LinearLayoutManager(activity)

                        }
                    }


            }

            catch(e: Exception) {
                withContext(Dispatchers.Main) {
                    //oast.makeText(this@Zx, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}