package com.example.walkie_talkie.system.domain.app_design.entities

import android.graphics.Bitmap
import com.example.walkie_talkie.R

data class User(
    val username: String ,
    val about: String? ,
    val password: String ,
    val email: String ,
    val phoneNumber: String ,
    val isMale: Boolean ,
    var defaultProfileImage: Int = if (isMale) R.drawable.male_profile else R.drawable.female_profile ,
    var profile: Bitmap? = null
)