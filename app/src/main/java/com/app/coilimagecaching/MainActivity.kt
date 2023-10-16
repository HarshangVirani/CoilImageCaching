package com.app.coilimagecaching

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.imageLoader
import coil.memory.MemoryCache
import com.app.coilimagecaching.ui.theme.CoilImageCachingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilImageCachingTheme {
                val imageUrl = "https://images.freeimages.com/images/large-previews/9c0/forest-1400475.jpg"
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "ImageLoaded",
                    modifier = Modifier.fillMaxSize(1f)
                )
                /*

                //Cache clear image
                Button(onClick = {
                    //Single image clear
                    imageLoader.diskCache?.remove(imageUrl)
                    imageLoader.memoryCache?.remove(MemoryCache.Key(imageUrl))

                    //Clear all cache
                    imageLoader.diskCache?.clear()
                    imageLoader.memoryCache?.clear()
                }) {
                    Text(text = "Clear cache")
                }

                */
            }
        }
    }
}