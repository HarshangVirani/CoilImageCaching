package com.app.coilimagecaching.ui.theme

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger

class App() : Application(), ImageLoaderFactory {

    override fun newImageLoader(): ImageLoader = ImageLoader(this)
        .newBuilder()
        .diskCachePolicy(CachePolicy.ENABLED)
        .diskCache {
            DiskCache.Builder()
                .maxSizePercent(0.04)
                .directory(cacheDir)
                .build()
        }
        .memoryCachePolicy(CachePolicy.ENABLED)
        .memoryCache {
            MemoryCache.Builder(this)
                .maxSizePercent(0.1)
                .strongReferencesEnabled(true)
                .build()
        }
        .logger(DebugLogger())
        .build()
}