package app.heshinth.patches.lightroom.misc.version

import app.morphe.patcher.extensions.InstructionExtensions.replaceInstruction
import app.morphe.patcher.patch.bytecodePatch
import app.heshinth.patches.shared.Constants.COMPATIBILITY_LIGHTROOM_MOBILE

@Suppress("unused")
val disableVersionCheckPatch = bytecodePatch(
    name = "Disable version check",
    description = "Disables the server-side version check that prevents the app from starting.",
    default = true,
) {
    compatibleWith(COMPATIBILITY_LIGHTROOM_MOBILE)

    execute {
        val igetIndex = RefreshRemoteConfigFingerprint.instructionMatches.last().index

        // This value represents the server command to clear all version restrictions.
        val statusForceReset = "-0x2"
        RefreshRemoteConfigFingerprint.method.replaceInstruction(
            igetIndex, "const/4 v1, $statusForceReset"
        )
    }
}
