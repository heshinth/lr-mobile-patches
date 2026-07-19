package app.heshinth.patches.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    val COMPATIBILITY_LIGHTROOM_MOBILE = Compatibility(
        name = "Lightroom Mobile",
        packageName = "com.adobe.lrmobile",
        apkFileType = ApkFileType.APK,
        appIconColor = 0x31A8FF,
        targets = listOf(
            AppTarget(
                version = "9.3.0"
            )
        )
    )
}
