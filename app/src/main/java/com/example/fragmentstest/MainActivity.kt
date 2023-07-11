package com.example.fragmentstest

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/*
Тут реализовано переключения между двумя фрагментами, весь остальной функционал описан в файлах
FirstFragment.kt и SecondFragment.kt
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Установим слушатели нажатия кнопок
        findViewById<Button>(R.id.BTN_setFirstFragment).setOnClickListener {
            //через менеджер фрагментов вызовем смену фрагментов
            val transaction = supportFragmentManager.beginTransaction()
            //установим нужный фрагмент
            transaction.replace(R.id.fragmentContainerView, firstFragment)
            //применим смену фрагмента
            transaction.commit()
        }
        findViewById<Button>(R.id.BTN_setSecondFragment).setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, secondFragment)
            transaction.commit()
        }
    }
    //Создадим экземпляры фрагментов используем модификатор static
    companion object {
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
    }
}