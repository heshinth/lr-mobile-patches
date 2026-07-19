package app.heshinth.patches.lightroom.misc.premium

import app.morphe.patcher.extensions.InstructionExtensions.replaceInstruction
import app.morphe.patcher.patch.bytecodePatch
import app.heshinth.patches.shared.Constants.COMPATIBILITY_LIGHTROOM_MOBILE

@Suppress("unused")
val unlockPremiumPatch = bytecodePatch(
    name = "Unlock Premium",
    description = "Unlocks premium features by forcing hasPurchased to return true.",
    default = true,
) {
    compatibleWith(COMPATIBILITY_LIGHTROOM_MOBILE)

    execute {
        // Set hasPremium = true.
        HasPurchasedFingerprint.method.replaceInstruction(2, "const/4 v2, 0x1")
    }
}
