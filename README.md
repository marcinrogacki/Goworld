# Requirements

* OpenJDK 8
* Enable Developer mode on phone
* Enable `USB debugging` on phone

# Build

Build `./gradlew build`\
Build and send to phone `./gradlew installDebug`

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
