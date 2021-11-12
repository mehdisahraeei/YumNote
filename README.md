

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
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'com.google.android.material:material:1.3.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'

    //about viewmodel
    implementation 'androidx.activity:activity-ktx:1.2.0-alpha05'
    implementation 'androidx.fragment:fragment-ktx:1.3.0-alpha05'
    implementation "androidx.lifecycle:lifecycle-viewmodel:2.2.0"


    //retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.4.0'
    implementation 'com.squareup.retrofit2:adapter-rxjava:2.4.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
    implementation 'com.google.code.gson:gson:2.8.2'
    implementation 'com.github.bumptech.glide:glide:4.12.0'


    //rxjava and rxandroid
    implementation "com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0"
    implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'
    implementation 'io.reactivex.rxjava3:rxjava:3.0.3'


    //Dagger
    implementation 'org.jetbrains:annotations:15.0'
    implementation 'com.google.dagger:dagger:2.33'
    implementation 'com.google.ar:core:1.23.0'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.33'


    //daimajia slider , picasso library
    implementation "com.android.support:support-v4:+"
    implementation 'com.squareup.picasso:picasso:2.3.2'
    implementation 'com.nineoldandroids:library:2.4.0'
    implementation 'com.daimajia.slider:library:1.1.5@aar'


    //Bottom Navygation
    implementation 'com.github.felixsoares:BottomNavygation:1.8.6'


    //designing responsive
    implementation 'com.github.MrNouri:DynamicSizes:1.0'






    testImplementation 'junit:junit:4.12'

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

