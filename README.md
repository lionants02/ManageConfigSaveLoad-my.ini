"# ManageConfigSaveLoad-my.ini" 

[![Release](https://jitpack.io/v/lionants02/ManageConfigSaveLoad-my.ini.svg)]
(https://jitpack.io/#lionants02/ManageConfigSaveLoad-my.ini)  

เพิ่ม JitPack repository ที่ build script
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

เพิ่ม dependency
```
dependencies {
    implementation "com.github.lionants02:ManageConfigSaveLoad-my.ini:$latestVersion"
}
```

ใช้

```$kotlin
    val read = ReadOptionMyini(File("my.ini"))
    val myIniConfig = read.read()
```
