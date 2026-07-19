package app.heshinth.patches.lightroom.misc.version

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.opcode
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

/**
 * Fingerprint for the refreshRemoteConfiguration method.
 * Matches: public static method containing one of the known config key strings,
 * then the opcode sequence: INVOKE_STATIC → MOVE_RESULT_OBJECT → IGET
 */
object RefreshRemoteConfigFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    strings = listOf(
        "com.adobe.lrmobile.denylisted_version_set_key",
        "com.adobe.lrmobile.app_min_version_key",
    ),
    filters = listOf(
        opcode(Opcode.INVOKE_STATIC),
        opcode(Opcode.MOVE_RESULT_OBJECT),
        opcode(Opcode.IGET),
    )
)
