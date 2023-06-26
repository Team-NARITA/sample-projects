package com.teamnarita.sample.sampleserver

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.File
import java.io.InputStream
import java.nio.file.Paths
import javax.annotation.PostConstruct
import kotlin.io.path.Path
import kotlin.io.path.inputStream

@Service
class FirebaseInitializer {
    companion object {
        private val logger = LoggerFactory.getLogger(FirebaseInitializer::class.java)
    }

    @PostConstruct
    fun onStart() {
        logger.info("Initializing FirebaseApp...")
        try {
            initializeApp()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun initializeApp() {
        if (FirebaseApp.getApps() == null || FirebaseApp.getApps().isEmpty()) {
            val file = Paths.get("serviceAccountKey.json")
            val options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(file.inputStream()))
                .build()

            FirebaseApp.initializeApp(options)
        }
    }
}