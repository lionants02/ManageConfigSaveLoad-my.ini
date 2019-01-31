"# ManageConfigSaveLoad-my.ini" 

[![Build Status](https://travis-ci.org/lionants02/ManageConfigSaveLoad-my.ini.svg?branch=master)](https://travis-ci.org/lionants02/ManageConfigSaveLoad-my.ini)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)


[![Release](https://jitpack.io/v/lionants02/ManageConfigSaveLoad-my.ini.svg)](https://jitpack.io/#lionants02/ManageConfigSaveLoad-my.ini)  

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

### License
```
MIT License

Copyright (c) 2019 Max Thanachai Thongkum

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
