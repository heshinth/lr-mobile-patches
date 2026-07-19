package app.heshinth.patches.lightroom.misc.premium

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.opcode
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

/**
 * Fingerprint for the hasPurchased method.
 * Matches: private final boolean method with opcode sequence:
 *   SGET_OBJECT → CONST_4 → CONST_4 → CONST_4
 */
object HasPurchasedFingerprint : Fingerprint(
    accessFlags = listOf(AccessFlags.PRIVATE, AccessFlags.FINAL),
    returnType = "Z",
    filters = listOf(
        opcode(Opcode.SGET_OBJECT),
        opcode(Opcode.CONST_4),
        opcode(Opcode.CONST_4),
        opcode(Opcode.CONST_4),
    )
)
