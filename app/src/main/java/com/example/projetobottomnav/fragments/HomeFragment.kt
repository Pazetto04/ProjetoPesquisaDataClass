package com.example.projetobottomnav.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetobottomnav.DataAdapter
import com.example.projetobottomnav.DataClass
import com.example.projetobottomnav.R
import androidx.room.Room
import com.example.projetobottomnav.AppDatabase
import com.example.projetobottomnav.DataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var repository: DataRepository
    private lateinit var db: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java,
            "channel_database"
        ).build()

        repository = DataRepository(db.dataDao())
        getData()

        return view

    }

    override fun onStart(){
        super.onStart()
        Toast.makeText(requireContext(), "Home Fragment iniciado (OnStart)", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(requireContext(),"HomeFragment saiu da tela (OnStop)", Toast.LENGTH_SHORT).show()
    }
    private fun getData() {

        CoroutineScope(Dispatchers.IO).launch {

            repository.insertInitialData()

            val dataFromDb = repository.getAllChannels()

            requireActivity().runOnUiThread {
                recyclerView.adapter = DataAdapter(ArrayList(dataFromDb))
            }
        }
    }
}