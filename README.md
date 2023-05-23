

## Gradle


### step1
add the dependency in your build.gradle.



```

    //adding--for--binding
    dataBinding
            {
                enabled = true
            }

```




```
//default
implementation 'androidx.appcompat:appcompat:1.4.0'
implementation 'com.google.android.material:material:1.5.0-alpha02'
implementation 'androidx.constraintlayout:constraintlayout:2.1.2'
implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'

//about viewmodel
implementation 'androidx.activity:activity-ktx:1.4.0'
implementation 'androidx.fragment:fragment-ktx:1.4.0'
implementation "androidx.lifecycle:lifecycle-viewmodel:2.4.0"


//retrofit
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:adapter-rxjava3:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.google.code.gson:gson:2.8.9'
implementation 'com.github.bumptech.glide:glide:4.12.0'


//rxjava and rxandroid
implementation "com.github.akarnokd:rxjava3-retrofit-adapter:3.0.1"
implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'
implementation 'io.reactivex.rxjava3:rxjava:3.1.3'


//Dagger
implementation 'org.jetbrains:annotations:22.0.0'
implementation 'com.google.dagger:dagger:2.40.5'
implementation 'com.google.ar:core:1.27.0'
implementation 'androidx.legacy:legacy-support-v4:1.0.0'
annotationProcessor 'com.google.dagger:dagger-compiler:2.40.5'


//daimajia slider , picasso library
implementation "com.android.support:support-v4:+"
implementation 'com.squareup.picasso:picasso:2.8'
implementation 'com.nineoldandroids:library:2.4.+'
implementation 'com.daimajia.slider:library:+@aar'


//Bottom Navygation
implementation 'com.github.felixsoares:BottomNavygation:+'


//designing responsive
implementation 'com.github.MrNouri:DynamicSizes:+'



testImplementation 'junit:junit:+'

```



### step2
add the these in your build.gradle


```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
        maven { url "https://oss.jfrog.org/libs-snapshot" }
        google()
        mavenCentral()
    }
}

```

## Demo:

![banner](https://raw.githubusercontent.com/mehdisahraeei/YumNote/master/preview/demo.png)
