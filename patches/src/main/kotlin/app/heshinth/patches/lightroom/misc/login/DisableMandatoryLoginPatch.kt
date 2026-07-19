package app.heshinth.patches.lightroom.misc.login

import app.morphe.patcher.extensions.InstructionExtensions.replaceInstruction
import app.morphe.patcher.patch.bytecodePatch
import app.heshinth.patches.shared.Constants.COMPATIBILITY_LIGHTROOM_MOBILE

@Suppress("unused")
val disableMandatoryLoginPatch = bytecodePatch(
    name = "Disable mandatory login",
    description = "Disables mandatory login by always returning true from isLoggedIn.",
    default = true,
) {
    compatibleWith(COMPATIBILITY_LIGHTROOM_MOBILE)

    execute {
        val lastIndex = IsLoggedInFingerprint.method.implementation!!.instructions.lastIndex
        IsLoggedInFingerprint.method.replaceInstruction(lastIndex - 1, "const/4 v0, 0x1")
    }
}
