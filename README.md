# Requirements

* OpenJDK 11
* Linux package (Arch) `android-udev` which allow establish connection to device via _adb_
* Enable Developer mode on phone
* Enable `USB debugging` on phone

# Build

* Build `./gradlew build`
* Build and send to phone `./gradlew installDebug`
* Build form command line tutorial https://developer.android.com/studio/build/building-cmdline

# Useful links

* Configure project using Gradle https://developer.android.com/studio/build
* Android Gradle plugin (AGP) https://developer.android.com/studio/releases/gradle-plugin

# Troubleshooting

**Could not determine java version from '15.0.2'.**

Downgrade Java version to OpenJDK 11.

**Exception while marshalling /opt/android-sdk/build-tools/30.0.3/package.xml. Probably the SDK is read-only**

https://wiki.archlinux.org/title/Android#Making_/opt/android-sdk_group-writeable

```
# groupadd android-sdk
# gpasswd -a <user> android-sdk
# setfacl -R -m g:android-sdk:rwx /opt/android-sdk
# setfacl -d -m g:android-sdk:rwX /opt/android-sdk
relog
```

**Warning: License for package SDK Patch Applier v4 not accepted.**

Accept licenses via command line

```
/opt/android-sdk/cmdline-tools/latest/bin/sdkmanager --licenses
```

**adb devices no permissions**

```
$ adb devices
List of devices attached
72u43t79        no permissions; see [http://developer.android.com/tools/device.html]
```

Install `android-udev` (Arch Linux package)

# Vim support

* Option 1
    * Install Syntastic https://github.com/vim-syntastic/syntastic
        * Plugin will provide syntax checker
        * Enable javac support in _.vimrc_: `let g:syntastic_java_checkers=['javac']`
    * Install vim-android https://github.com/hsanson/vim-android.git
        * Plugin will export CLASSPATH variable for Syntastic which will allow inspect imports from Android, 3rd party libs and project itself
        * Set in _.vimrc_ a path to Android SDK: `let g:android_sdk_path = "/opt/android-sdk"`
* Option 2
    * Install YCM https://github.com/ycm-core/YouCompleteMe (Arch Linux: https://wiki.archlinux.org/title/Vim/YouCompleteMe)
    * Install jdtls https://github.com/eclipse/eclipse.jdt.ls (Arch Linux: https://aur.archlinux.org/packages/jdtls/)
