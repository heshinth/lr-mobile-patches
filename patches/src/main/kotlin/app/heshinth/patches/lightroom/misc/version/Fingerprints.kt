package app.heshinth.patches.lightroom.misc.version

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.anyInstruction
import app.morphe.patcher.opcode
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

/**
 * Fingerprint for the refreshRemoteConfiguration method.
 * Matches: public static method containing one of the known config key strings,
 * followed by: INVOKE_STATIC → MOVE_RESULT_OBJECT → IGET
 */
object RefreshRemoteConfigFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    filters = listOf(
        anyInstruction(
            string("com.adobe.lrmobile.denylisted_version_set_key"),
            string("com.adobe.lrmobile.app_min_version_key"),
        ),
        opcode(Opcode.INVOKE_STATIC),
        opcode(Opcode.MOVE_RESULT_OBJECT),
        opcode(Opcode.IGET),
    )
)
