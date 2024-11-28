package com.example.walkie_talkie.system.data.app_design.feature_message.remote

import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseInstanceIDService() : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Save the token to the Firebase Realtime Database or other backend service
        // You can use the token to send notifications or perform other actions
    }
}