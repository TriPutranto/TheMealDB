object ApplicationId {
    const val appId = "com.triputranto.themealdb"
}

object Dependencies {
    const val buildGradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val daggetHiltGradle =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}"
}

object TestInstrumentation {
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    //Android
    const val kotlin = "1.4.21"
    const val gradle = "4.1.1"
    const val minSdk = 22
    const val compiledSdk = 30
    const val buildTools = "30.0.3"
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0"

    const val appCompat = "1.2.0"
    const val coreKtx = "1.3.2"
    const val contraintLayout = "2.0.4"
    const val legacy = "1.0.0"
    const val materialDesign = "1.2.1"

    //Testing
    const val jUnit = "4.12"
    const val extJUnit = "1.1.2"
    const val espressoCore = "3.3.0"

    //Network
    const val retrofit = "2.9.0"
    const val gson = "2.8.6"
    const val okHttp = "4.5.0"

    //View
    const val glide = "4.11.0"
    const val preference = "1.1.0"

    //Lifecycle
    const val lifecycle = "2.2.0"

    //Room
    const val room = "2.2.6"

    //Timber
    const val timber = "4.7.1"

    //Navigation
    const val navigation = "2.3.2"
    const val fragment = "1.2.5"

    //Hilt
    const val daggerHilt = "2.28.1-alpha"
    const val androidXHilt = "1.0.0-alpha02"

    //Coroutines
    const val coroutines = "1.4.2"
}

object AndroidLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.contraintLayout}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
    const val preference = "androidx.preference:preference-ktx:${Versions.preference}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
}

object Testing {
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val extJUnit = "androidx.test.ext:junit:${Versions.extJUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object Network {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitMock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val okHttp = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object Lifecycle {
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifeCycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
}

object Room {
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRxJava = "androidx.room:room-rxjava2:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
}

object Timber {
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object Navigation {
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
}

object Hilt {
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    const val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.androidXHilt}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.androidXHilt}"
}

object Coroutines {
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}
