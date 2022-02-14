# Troubleshooting

List of solutions for common problems.

## Could not determine java version from '15.0.2'

Downgrade Java version to OpenJDK 11.

## Exception while marshalling /opt/android-sdk/build-tools/30.0.3/package.xml. Probably the SDK is read-only

https://wiki.archlinux.org/title/Android#Making_/opt/android-sdk_group-writeable

```
# groupadd android-sdk
# gpasswd -a <user> android-sdk
# setfacl -R -m g:android-sdk:rwx /opt/android-sdk
# setfacl -d -m g:android-sdk:rwX /opt/android-sdk
relog
```

## Warning: License for package SDK Patch Applier v4 not accepted

Accept licenses via command line

```
/opt/android-sdk/cmdline-tools/latest/bin/sdkmanager --licenses
```

## adb devices doesn't show phone or has no permissions


```
$ adb devices
List of devices attached
72u43t79        no permissions; see [http://developer.android.com/tools/device.html]
```

* Setup adb to recognize Android phone https://wiki.archlinux.org/title/Android_Debug_Bridge#Usage 
    * Install `android-udev` (Arch Linux package)
    * Add /etc/udev/rules.d/51-android.rules
    * _Revoke USB debugging authorizations_ on phone, kill adb server, start it 
      again, accept authorization prompt on phone
    * Works only when adb is started as root (adding user to _adbusers_ group 
      doesn't help)
    * USB cable might be not compatible with _debugging mode_ (lack of pin)
    * Restart configuration
        * Kill server `adb kill-server`
        * Revoke USB debugging authorizations on device
        * Turn off/on USB debugging on phone
        * Run again `adb devices`

## App crashes on startup

Check logs. Command `adb logcat AndroidRuntime:V *:S` will show all apps which
crashed at runtime. More about logs https://developer.android.com/studio/command-line/logcat

Ensure kotlin-android plugin is loaded

```
// build.gradle
dependencies {
    classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10"
}
// app/build.gradle
apply plugin: 'kotlin-android'
```
