# Requirements

* Enable Developer mode on phone
* Enable `USB debugging` on phone
* Install jdk11-openjdk (Java 11)
* Install SDK packages: 
    * android-sdk-cmdline-tools-latest (AUR)
    * android-sdk-platform-tools (AUR)
    * android-sdk-build-tools (AUR)
    * android-tools - contains abd
    * android-udev - allow establish connection to device via adb
    * /opt/android-sdk/cmdline-tools/latest/bin/sdkmanager --install "build-tools;30.0.3" tools used in project
    * /opt/android-sdk/cmdline-tools/latest/bin/sdkmanager --install "platforms;android-31" platforms used in project

# Build

* Build `./gradlew build`
* Build and send to phone `./gradlew installDebug`
* Build form command line tutorial https://developer.android.com/studio/build/building-cmdline

# Useful links

* Configure project using Gradle https://developer.android.com/studio/build
* Android Gradle plugin (AGP) https://developer.android.com/studio/releases/gradle-plugin
* Configure device wireless debugging https://developer.android.com/studio/command-line/adb#wireless

# Vim support

https://github.com/marcinrogacki/dotfiles/blob/master/repository/vim/README.md#android-support
