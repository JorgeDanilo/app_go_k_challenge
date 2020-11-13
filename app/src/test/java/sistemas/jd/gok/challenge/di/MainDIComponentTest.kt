package sistemas.jd.gok.challenge.di

fun configureTestAppComponent(baseApi: String)
        = listOf(
    MockWebServerDIPTest,
    configureNetworkModuleForTest(baseApi),
    RepoDependency
)

