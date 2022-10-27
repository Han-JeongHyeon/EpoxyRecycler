package com.azhar.epoxy.controller

import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.carousel
import com.azhar.epoxy.data.Message
import com.azhar.epoxy.data.Profile
import com.azhar.epoxy.model.*

/**
 * Created by Azhar Rivaldi on 07-03-2022
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 */

class HomeController : AsyncEpoxyController() {

    var recentlyActive: List<Profile> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var allMessages: List<Message> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
//        headerItem {
//            id("recently_active")
//            title("Recently Active")
//            spanSizeOverride(NumItemsInGridRow.setItemCountInRow(1))
//        }
//        val models = recentlyActive.map {
//            RecentlyActiveItemModel_()
//                .id(it.id)
//                .profile(it)
//        }
//        carousel {
//            id("recent")
//            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
//            models(models)
//        }

        headerItem {
            id("all_messages")
            title("All Messages")
            spanSizeOverride(NumItemsInGridRow.setItemCountInRow(1))
        }

        allMessages.forEachIndexed { index, message ->
            messageItem {
                id("message$index")
                message(message)
                if(index % 9 == 0) spanSizeOverride(NumItemsInGridRow.setItemCountInRow(1))
            }
        }

//        val models = allMessages.map {
//            MessageItemModel_()
//                .id(it.id)
//                .message(it)
//        }
//        carousel {
//            id("recent")
//            spanSizeOverride(NumItemsInGridRow.setItemCountInRow(2))
//            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
//            models(models)
//        }
    }

}