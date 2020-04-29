package com.github.vacxe.googleplaycli.actions.testers.configuration

import com.github.vacxe.googleplaycli.core.BaseConfiguration
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default

class TestersGetConfiguration(parser: ArgParser) : BaseConfiguration(parser) {
    val track: String by parser
            .storing("--track", "-t")
            .default { "" }
}