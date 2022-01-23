package com.techlad.onevalet.domain.model

/**
 * Created by umair.khalid on 16,January,2022
 **/

data class Device(
    val id: String,
    val type: String,
    val price: Int,
    val currency: String,
    val is_favorite: Boolean,
    val image_url: String,
    val title: String,
    val description: String
)