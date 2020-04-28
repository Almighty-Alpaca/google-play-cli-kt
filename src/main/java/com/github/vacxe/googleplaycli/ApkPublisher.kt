@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.github.vacxe.googleplaycli

import com.xenomachina.argparser.mainBody
import java.util.*

fun main(args: Array<String>): Unit = mainBody {
    val command = ArrayDeque<String>().apply { addAll(args) }
    val result = when (command.pollFirst()) {
        "apks" -> {
            when (command.pollFirst()) {
                "list" -> Commands.Apks.list(command.toTypedArray())
                "upload" -> Commands.Apks.upload(command.toTypedArray())
                else -> "Command not found. Available: list, upload"
            }
        }
        "bundles" -> {
            when (command.pollFirst()) {
                "list" -> Commands.Bundles.list(command.toTypedArray())
                "upload" -> Commands.Bundles.upload(command.toTypedArray())
                else -> "Command not found. Available: list, upload"
            }
        }
        "deobfuscationfiles" -> {
            when (command.pollFirst()) {
                "upload" -> Commands.Deobfuscationfiles.upload(command.toTypedArray())
                else -> "Command not found. Available: upload"
            }
        }
        "tracks" -> {
            when (command.pollFirst()) {
                "get" -> Commands.Tracks.get(command.toTypedArray())
                "list" -> Commands.Tracks.list(command.toTypedArray())
                "patch" -> Commands.Tracks.patch(command.toTypedArray())
                "update" -> Commands.Tracks.update(command.toTypedArray())
                else -> "Command not found. Available: get, list, patch. update"
            }
        }
        else -> "Command not found. Available: apks, bundles, deobfuscationfiles, tracks"
    }

    println(result)
}