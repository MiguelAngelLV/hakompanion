package models

import config.Config

abstract class Switch(config: Config) : Entity(config) {

    override val type: String = "switch"


}
