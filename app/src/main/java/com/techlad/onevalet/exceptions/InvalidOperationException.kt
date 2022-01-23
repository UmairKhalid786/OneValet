package com.techlad.onevalet.exceptions

/**
 * Created by umair.khalid on 15,January,2022
 **/

data class InvalidOperationException(override val message: String) : Exception(message)