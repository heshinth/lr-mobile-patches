package app.heshinth.patches.lightroom.misc.login

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.opcode
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

/**
 * Fingerprint for the isLoggedIn method.
 * Matches: public static final boolean method containing these opcodes in order:
 *   INVOKE_STATIC → MOVE_RESULT_OBJECT → SGET_OBJECT → IF_NE → CONST_4 → GOTO
 */
object IsLoggedInFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC, AccessFlags.FINAL),
    returnType = "Z",
    filters = listOf(
        opcode(Opcode.INVOKE_STATIC),
        opcode(Opcode.MOVE_RESULT_OBJECT),
        opcode(Opcode.SGET_OBJECT),
        opcode(Opcode.IF_NE),
        opcode(Opcode.CONST_4),
        opcode(Opcode.GOTO),
    )
)
