package dev.anilbeesetti.nextplayer.core.common.extensions

import java.io.File

/**
 * Returns true when a media file is hidden by common Android filesystem conventions.
 *
 * A media item is hidden when its own name or any ancestor directory starts with '.', or
 * when any ancestor directory contains a .nomedia marker.
 */
fun File.isHiddenMedia(): Boolean {
    var current: File? = this
    while (current != null) {
        if (current.name.startsWith('.')) return true
        if (current.isDirectory && File(current, ".nomedia").exists()) return true
        current = current.parentFile
    }
    return false
}
