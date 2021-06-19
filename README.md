# Requirements

* OpenJDK 8
* Linux package (Arch) `android-udev` which allow establish connection to device via _adb_
* Enable Developer mode on phone
* Enable `USB debugging` on phone

# Build

Build `./gradlew build`\
Build and send to phone `./gradlew installDebug`

# Vim support

* Install Syntastic https://github.com/vim-syntastic/syntastic
* Set class path
    * `export CLASSPATH=/opt/android-sdk/platforms/android-26/android.jar` version must fit to _compileSdkVersion_ from _app/build.gradle_
    * `export CLASSPATH=$CLASSPATH:./app/src/main/java/` classes created for project
    * Example export of dependencies where version must fit to versions imported in _gradle.build_
        * `export CLASSPATH=$CLASSPATH:/opt/android-sdk/extras/android/m2repository/com/android/support/appcompat-v7/26.0.0-alpha1/appcompat-v7-26.0.0-alpha1-sources.jar`

# Troubleshooting

**Could not determine java version from '15.0.2'.**

Downgrade Java version to OpenJDK 8.

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
