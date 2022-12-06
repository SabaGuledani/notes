package com.example.pagerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pagerview.databinding.FragmentPage1Binding


class Page1Fragment : Fragment(R.layout.fragment_page1) {

  private lateinit var binding: FragmentPage1Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPage1Binding.bind(view)
        var recyclerview = binding.recyclerView
        recyclerview.layoutManager = LinearLayoutManager(context)
        var noteText = binding.notetext
        var saveBtn = binding.savebtn

        var noteList = mutableListOf<String>()
        saveBtn.setOnClickListener {
            if( noteText.text.toString() != ""){
                noteList.add(noteText.text.toString())
                recyclerview.adapter = CustomRecyclerAdapter(noteList)
            }

        }








    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


    }
}