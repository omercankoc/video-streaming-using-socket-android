package com.omercankoc.recyclerview

import java.io.Serializable

// Nesneye ait ozelliklerin tutuldugu sinifin tanimi.
class Languages(
    val language : String,
    val year : Int,
    val logo : Int) : Serializable {
        // Serializable : Olusturdugumuz sinifi butun olarak serilestirerek gonderimini ve
        // alimini saglar. Bknz : MainActivity:Intent -> DetailsActivity:Intent
    }