package com.example.fragmentstest

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class FirstFragment : Fragment() {
    var data = ""
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    //Переопределим метод при создании фрагмента
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //запишем создаваемый view в переменную и вернём её через return
        val fragmentView: View = inflater.inflate(R.layout.fragment_first, container, false)
        //Определим поле ввода
        val outputData: EditText = fragmentView.findViewById(R.id.ET_outputData)
        //Установим слушатель для кнопки отправки
        fragmentView.findViewById<Button>(R.id.BTN_send).setOnClickListener{
            data = outputData.text.toString() //запишем данные из текстового поля в переменную
        }
        return fragmentView
    }

    companion object {
        /*метод для создания нового экземпляра с заданными параметрами, при помощи этого метода
        можно передать нужные значения из любого места при создании фрагмента
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}