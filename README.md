[![](https://jitpack.io/v/lber19535/drawable-optimizer.svg)](https://jitpack.io/#lber19535/drawable-optimizer)

Add [Pngquant](https://pngquant.org/)

```groovy
drawableOptimizer {
    optimizer = 'pngquant'
    compressionLevel = 9   // in pngquant mode, I dont't release this parameter
    iterations = 15        // in pngquant mode, I dont't release this parameter
    onlyOnRelease = false
    logLevel = 'info'
}
```


[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-drawable--optimizer-green.svg?style=true)](https://android-arsenal.com/details/1/3586)

Drawable Optimizer
==================

Gradle plugin to optimize png files and reduce resultant apk size within an Android project.

## How it works ?

With this plugin you will be able to optimize the png files size inside your AndroidStudio project.
It works over the folder in which the resource merging was executed, by default in a Mac OSX system is `app\build\intermediates\res\merged`.

By doing this, all original png files are kept under /res folder and this optimization could be undone just cleaning the project.

In order to perform an optimization task, this plugin offers 2 different ways of file compression:

  * [Pngtastic] library, which brings its own compressor.
  * [Zopfli], which offers ridiculously good compression ratios in exchange of low compression speed.

## Why should I use this plugin ?

You can find an explanation from [Colt McAnlis] about why you should optimize your pngs [Reducing PNG file Size] and [Smaller PNGs, and Android’s AAPT tool]

## Taste

| Original                                   | Optimized                                    |
|--------------------------------------------|----------------------------------------------|
|                   525.51k                  |                    473.20k                   |
| ![Original Image](/art/lenna_original.png) | ![Optimized Image](/art/lenna_optimized.png) |




## Usage

Just click on __Sync project with gradle files__ button

## Download & Installation

In `build.gradle`
```groovy
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'org.fabiomsr:drawable-optimizer-gradle-plugin:1.0.4'
    }
}
```
And in `app\build.gradle`
```groovy
// Make sure this line comes *after* you apply the Android plugin (apply plugin: 'com.android.application')
apply plugin: 'org.fabiomsr.drawableoptimizer'
```
## Configuration
No configuration is needed by default, but if you want you can configure the following parameters.
Every time the configuration changes the project must be cleaned.

In `app\build.gradle`

```groovy
drawableOptimizer {
    optimizer = 'zopfli'
    compressionLevel = 9
    iterations = 15
    onlyOnRelease = true
    logLevel = 'info'
}
```
|     Parameter    |                       Description                       |            Values            |               Default Value               |
|:----------------:|:-------------------------------------------------------:|:----------------------------:|:-----------------------------------------:|
| optimizer        | Compressor to use                                       |      zopfli or pngtastic     | zopfli                                    |
| compressionLevel | Compression level (useful for pngtastic compressor)     |         0-9 allowed          | Brute forces with every allowed value     |
| iterations       | Compression iterations number (useful for zopfli)       |             > 0              | 15                                        |
| onlyOnRelease    | Only release signed optimization                        |         true or false        | false                                     |
| logLevel         | Output Logging level                                   | none, debug, info or error   | info                                      |


License
-------

    Copyright 2016 Fabio Santana (fabiomsr)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



[Pngtastic]: https://github.com/depsypher/pngtastic
[Zopfli]: https://github.com/google/zopfli
[Colt McAnlis]: https://medium.com/@duhroach
[Reducing PNG file Size]: https://medium.com/@duhroach/reducing-png-file-size-8473480d0476#.vq7mjuvxx
[Smaller PNGs, and Android’s AAPT tool]: https://medium.com/@duhroach/smaller-pngs-and-android-s-aapt-tool-4ce38a24019d#.4hcjre4yi
