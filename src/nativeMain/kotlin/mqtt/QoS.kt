package mqtt

@Suppress("EXPERIMENTAL_FEATURE_WARNING")
inline class QoS(val value: Int)

val QoS0 = QoS(0) // Fire and forget - the message may not be delivered
val QoS1 = QoS(1) // At least once - the message will be delivered, but may be delivered more than once in some circumstances.
val QoS2 = QoS(2) // Once and one only - the message will be delivered exactly once.
