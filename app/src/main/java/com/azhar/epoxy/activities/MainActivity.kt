package com.azhar.epoxy.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.MonthDisplayHelper
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.azhar.epoxy.R
import com.azhar.epoxy.controller.HomeController
import com.azhar.epoxy.data.Data
import com.azhar.epoxy.model.MessageItemModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = HomeController()
        messagesView.layoutManager = GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false)
        messagesView.setController(controller)

        controller.allMessages = Data.messages
        controller.recentlyActive = Data.recentlyActive

    }
}