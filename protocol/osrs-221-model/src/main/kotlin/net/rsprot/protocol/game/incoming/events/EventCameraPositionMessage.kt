package net.rsprot.protocol.game.incoming.events

import net.rsprot.protocol.message.IncomingMessage

/**
 * Camera position events are sent whenever the client's camera changes position,
 * at a maximum frequency of 20 client cycles (20ms/cc).
 * @property angleX the x angle of the camera, in range of 128 to 383 (inclusive)
 * @property angleY the y angle of the camera, in range of 0 to 2047 (inclusive)
 */
@Suppress("MemberVisibilityCanBePrivate")
public class EventCameraPositionMessage private constructor(
    private val _angleX: UShort,
    private val _angleY: UShort,
) : IncomingMessage {
    public constructor(
        angleX: Int,
        angleY: Int,
    ) : this(
        angleX.toUShort(),
        angleY.toUShort(),
    )

    public val angleX: Int
        get() = _angleX.toInt()
    public val angleY: Int
        get() = _angleY.toInt()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EventCameraPositionMessage

        if (_angleX != other._angleX) return false
        if (_angleY != other._angleY) return false

        return true
    }

    override fun hashCode(): Int {
        var result = _angleX.hashCode()
        result = 31 * result + _angleY.hashCode()
        return result
    }

    override fun toString(): String {
        return "EventCameraPositionMessage(" +
            "angleX=$angleX, " +
            "angleY=$angleY" +
            ")"
    }
}
