pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AOC2024"
include(":app")
include(":day1")
include(":day2")
include(":day3")
include(":day4")
include(":day5")
include(":day6")
include(":day7")
include(":day8")
include(":day9")
include(":day10")
include(":day12")
include(":day11")
