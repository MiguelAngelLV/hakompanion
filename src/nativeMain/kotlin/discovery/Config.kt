package discovery

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Config {

    @SerialName("action_topic")
    var actionTopic: String? = null
    @SerialName("action_template")
    var actionTemplate: String? = null
    @SerialName("automation_type")
    var automationType: String? = null
    @SerialName("aux_command_topic")
    var auxCommandTopic: String? = null
    @SerialName("aux_state_template")
    var auxStateTemplate: String? = null
    @SerialName("aux_state_topic")
    var auxStateTopic: String? = null
    @SerialName("availability")
    var availability: String? = null
    @SerialName("availability_topic")
    var availabilityTopic: String? = null
    @SerialName("away_mode_command_topic")
    var awayModeCommandTopic: String? = null
    @SerialName("away_mode_state_template")
    var awayModeStateTemplate: String? = null
    @SerialName("away_mode_state_topic")
    var awayModeStateTopic: String? = null
    @SerialName("blue_template")
    var blueTemplate: String? = null
    @SerialName("brightness_command_topic")
    var brightnessCommandTopic: String? = null
    @SerialName("brightness_scale")
    var brightnessScale: String? = null
    @SerialName("brightness_state_topic")
    var brightnessStateTopic: String? = null
    @SerialName("brightness_template")
    var brightnessTemplate: String? = null
    @SerialName("brightness_value_template")
    var brightnessValueTemplate: String? = null
    @SerialName("color_temp_command_template")
    var colorTempCommandTemplate: String? = null
    @SerialName("battery_level_topic")
    var batteryLevelTopic: String? = null
    @SerialName("battery_level_template")
    var batteryLevelTemplate: String? = null
    @SerialName("charging_topic")
    var chargingTopic: String? = null
    @SerialName("charging_template")
    var chargingTemplate: String? = null
    @SerialName("color_temp_command_topic")
    var colorTempCommandTopic: String? = null
    @SerialName("color_temp_state_topic")
    var colorTempStateTopic: String? = null
    @SerialName("color_temp_template")
    var colorTempTemplate: String? = null
    @SerialName("color_temp_value_template")
    var colorTempValueTemplate: String? = null
    @SerialName("cleaning_topic")
    var cleaningTopic: String? = null
    @SerialName("cleaning_template")
    var cleaningTemplate: String? = null
    @SerialName("command_off_template")
    var commandOffTemplate: String? = null
    @SerialName("command_on_template")
    var commandOnTemplate: String? = null
    @SerialName("command_topic")
    var commandTopic: String? = null
    @SerialName("command_template")
    var commandTemplate: String? = null
    @SerialName("code_arm_required")
    var codeArmRequired: String? = null
    @SerialName("code_disarm_required")
    var codeDisarmRequired: String? = null
    @SerialName("current_temperature_topic")
    var currentTemperatureTopic: String? = null
    @SerialName("current_temperature_template")
    var currentTemperatureTemplate: String? = null
    @SerialName("device")
    var device: String? = null
    @SerialName("device_class")
    var deviceClass: String? = null
    @SerialName("docked_topic")
    var dockedTopic: String? = null
    @SerialName("docked_template")
    var dockedTemplate: String? = null
    @SerialName("error_topic")
    var errorTopic: String? = null
    @SerialName("error_template")
    var errorTemplate: String? = null
    @SerialName("fan_speed_topic")
    var fanSpeedTopic: String? = null
    @SerialName("fan_speed_template")
    var fanSpeedTemplate: String? = null
    @SerialName("fan_speed_list")
    var fanSpeedList: String? = null
    @SerialName("flash_time_long")
    var flashTimeLong: String? = null
    @SerialName("flash_time_short")
    var flashTimeShort: String? = null
    @SerialName("effect_command_topic")
    var effectCommandTopic: String? = null
    @SerialName("effect_list")
    var effectList: String? = null
    @SerialName("effect_state_topic")
    var effectStateTopic: String? = null
    @SerialName("effect_template")
    var effectTemplate: String? = null
    @SerialName("effect_value_template")
    var effectValueTemplate: String? = null
    @SerialName("expire_after")
    var expireAfter: String? = null
    @SerialName("fan_mode_command_topic")
    var fanModeCommandTopic: String? = null
    @SerialName("fan_mode_state_template")
    var fanModeStateTemplate: String? = null
    @SerialName("fan_mode_state_topic")
    var fanModeStateTopic: String? = null
    @SerialName("force_update")
    var forceUpdate: String? = null
    @SerialName("green_template")
    var greenTemplate: String? = null
    @SerialName("hold_command_topic")
    var holdCommandTopic: String? = null
    @SerialName("hold_state_template")
    var holdStateTemplate: String? = null
    @SerialName("hold_state_topic")
    var holdStateTopic: String? = null
    @SerialName("hs_command_topic")
    var hsCommandTopic: String? = null
    @SerialName("hs_state_topic")
    var hsStateTopic: String? = null
    @SerialName("hs_value_template")
    var hsValueTemplate: String? = null
    @SerialName("icon")
    var icon: String? = null
    @SerialName("initial")
    var initial: String? = null
    @SerialName("json_attributes")
    var jsonAttributes: String? = null
    @SerialName("json_attributes_topic")
    var jsonAttributesTopic: String? = null
    @SerialName("json_attributes_template")
    var jsonAttributesTemplate: String? = null
    @SerialName("max_mireds")
    var maxMireds: String? = null
    @SerialName("min_mireds")
    var minMireds: String? = null
    @SerialName("max_temp")
    var maxTemp: String? = null
    @SerialName("min_temp")
    var minTemp: String? = null
    @SerialName("mode_command_topic")
    var modeCommandTopic: String? = null
    @SerialName("mode_state_template")
    var modeStateTemplate: String? = null
    @SerialName("mode_state_topic")
    var modeStateTopic: String? = null
    @SerialName("name")
    var name: String? = null
    @SerialName("off_delay")
    var offDelay: String? = null
    @SerialName("on_command_type")
    var onCommandType: String? = null
    @SerialName("optimistic")
    var optimistic: String? = null
    @SerialName("oscillation_command_topic")
    var oscillationCommandTopic: String? = null
    @SerialName("oscillation_state_topic")
    var oscillationStateTopic: String? = null
    @SerialName("oscillation_value_template")
    var oscillationValueTemplate: String? = null
    @SerialName("payload")
    var payload: String? = null
    @SerialName("payload_arm_away")
    var payloadArmAway: String? = null
    @SerialName("payload_arm_home")
    var payloadArmHome: String? = null
    @SerialName("payload_arm_custom_bypass")
    var payloadArmCustomBypass: String? = null
    @SerialName("payload_arm_night")
    var payloadArmNight: String? = null
    @SerialName("payload_available")
    var payloadAvailable: String? = null
    @SerialName("payload_clean_spot")
    var payloadCleanSpot: String? = null
    @SerialName("payload_close")
    var payloadClose: String? = null
    @SerialName("payload_disarm")
    var payloadDisarm: String? = null
    @SerialName("payload_high_speed")
    var payloadHighSpeed: String? = null
    @SerialName("payload_home")
    var payloadHome: String? = null
    @SerialName("payload_lock")
    var payloadLock: String? = null
    @SerialName("payload_locate")
    var payloadLocate: String? = null
    @SerialName("payload_low_speed")
    var payloadLowSpeed: String? = null
    @SerialName("payload_medium_speed")
    var payloadMediumSpeed: String? = null
    @SerialName("payload_not_available")
    var payloadNotAvailable: String? = null
    @SerialName("payload_not_home")
    var payloadNotHome: String? = null
    @SerialName("payload_off")
    var payloadOff: String? = null
    @SerialName("payload_off_speed")
    var payloadOffSpeed: String? = null
    @SerialName("payload_on")
    var payloadOn: String? = null
    @SerialName("payload_open")
    var payloadOpen: String? = null
    @SerialName("payload_oscillation_off")
    var payloadOscillationOff: String? = null
    @SerialName("payload_oscillation_on")
    var payloadOscillationOn: String? = null
    @SerialName("payload_pause")
    var payloadPause: String? = null
    @SerialName("payload_stop")
    var payloadStop: String? = null
    @SerialName("payload_start")
    var payloadStart: String? = null
    @SerialName("payload_start_pause")
    var payloadStartPause: String? = null
    @SerialName("payload_return_to_base")
    var payloadReturnToBase: String? = null
    @SerialName("payload_turn_off")
    var payloadTurnOff: String? = null
    @SerialName("payload_turn_on")
    var payloadTurnOn: String? = null
    @SerialName("payload_unlock")
    var payloadUnlock: String? = null
    @SerialName("position_closed")
    var positionClosed: String? = null
    @SerialName("position_open")
    var positionOpen: String? = null
    @SerialName("power_command_topic")
    var powerCommandTopic: String? = null
    @SerialName("power_state_topic")
    var powerStateTopic: String? = null
    @SerialName("power_state_template")
    var powerStateTemplate: String? = null
    @SerialName("red_template")
    var redTemplate: String? = null
    @SerialName("retain")
    var retain: String? = null
    @SerialName("rgb_command_template")
    var rgbCommandTemplate: String? = null
    @SerialName("rgb_command_topic")
    var rgbCommandTopic: String? = null
    @SerialName("rgb_state_topic")
    var rgbStateTopic: String? = null
    @SerialName("rgb_value_template")
    var rgbValueTemplate: String? = null
    @SerialName("send_command_topic")
    var sendCommandTopic: String? = null
    @SerialName("send_if_off")
    var sendIfOff: String? = null
    @SerialName("set_fan_speed_topic")
    var setFanSpeedTopic: String? = null
    @SerialName("set_position_template")
    var setPositionTemplate: String? = null
    @SerialName("set_position_topic")
    var setPositionTopic: String? = null
    @SerialName("position_topic")
    var positionTopic: String? = null
    @SerialName("speed_command_topic")
    var speedCommandTopic: String? = null
    @SerialName("speed_state_topic")
    var speedStateTopic: String? = null
    @SerialName("speed_value_template")
    var speedValueTemplate: String? = null
    @SerialName("speeds")
    var speeds: String? = null
    @SerialName("source_type")
    var sourceType: String? = null
    @SerialName("state_closed")
    var stateClosed: String? = null
    @SerialName("state_closing")
    var stateClosing: String? = null
    @SerialName("state_off")
    var stateOff: String? = null
    @SerialName("state_on")
    var stateOn: String? = null
    @SerialName("state_open")
    var stateOpen: String? = null
    @SerialName("state_opening")
    var stateOpening: String? = null
    @SerialName("state_locked")
    var stateLocked: String? = null
    @SerialName("state_unlocked")
    var stateUnlocked: String? = null
    @SerialName("state_topic")
    var stateTopic: String? = null
    @SerialName("state_template")
    var stateTemplate: String? = null
    @SerialName("state_value_template")
    var stateValueTemplate: String? = null
    @SerialName("subtype")
    var subtype: String? = null
    @SerialName("supported_features")
    var supportedFeatures: String? = null
    @SerialName("swing_mode_command_topic")
    var swingModeCommandTopic: String? = null
    @SerialName("swing_mode_state_topic")
    var swingModeStateTopic: String? = null
    @SerialName("temperature_command_topic")
    var temperatureCommandTopic: String? = null
    @SerialName("temperature_high_command_topic")
    var temperatureHighCommandTopic: String? = null
    @SerialName("temperature_high_state_template")
    var temperatureHighStateTemplate: String? = null
    @SerialName("temperature_high_state_topic")
    var temperatureHighStateTopic: String? = null
    @SerialName("temperature_low_command_topic")
    var temperatureLowCommandTopic: String? = null
    @SerialName("temperature_low_state_template")
    var temperatureLowStateTemplate: String? = null
    @SerialName("temperature_low_state_topic")
    var temperatureLowStateTopic: String? = null
    @SerialName("temperature_state_template")
    var temperatureStateTemplate: String? = null
    @SerialName("temperature_state_topic")
    var temperatureStateTopic: String? = null
    @SerialName("temperature_unit")
    var temperatureUnit: String? = null
    @SerialName("tilt_closed_value")
    var tiltClosedValue: String? = null
    @SerialName("tilt_command_topic")
    var tiltCommandTopic: String? = null
    @SerialName("tilt_invert_state")
    var tiltInvertState: String? = null
    @SerialName("tilt_max")
    var tiltMax: String? = null
    @SerialName("tilt_min")
    var tiltMin: String? = null
    @SerialName("tilt_opened_value")
    var tiltOpenedValue: String? = null
    @SerialName("tilt_optimistic")
    var tiltOptimistic: String? = null
    @SerialName("tilt_status_topic")
    var tiltStatusTopic: String? = null
    @SerialName("tilt_status_template")
    var tiltStatusTemplate: String? = null
    @SerialName("topic")
    var topic: String? = null
    @SerialName("unique_id")
    var uniqueId: String? = null
    @SerialName("unit_of_measurement")
    var unitOfMeasurement: String? = null
    @SerialName("value_template")
    var valueTemplate: String? = null
    @SerialName("white_value_command_topic")
    var whiteValueCommandTopic: String? = null
    @SerialName("white_value_scale")
    var whiteValueScale: String? = null
    @SerialName("white_value_state_topic")
    var whiteValueStateTopic: String? = null
    @SerialName("white_value_template")
    var whiteValueTemplate: String? = null
    @SerialName("xy_command_topic")
    var xyCommandTopic: String? = null
    @SerialName("xy_state_topic")
    var xyStateTopic: String? = null
    @SerialName("xy_value_template")
    var xyValueTemplate: String? = null
}
