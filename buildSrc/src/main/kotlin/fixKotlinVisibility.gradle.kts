// File: fixKotlinVisibility.gradle.kts
// Add this task to your project to fix Kotlin visibility issues for explicit API mode

tasks.register("fixKotlinVisibility") {
    group = "build"
    description = "Fixes Kotlin visibility issues for explicit API mode"
    
    doLast {
        val scriptPath = "${rootProject.projectDir}/fix-kotlin-visibility.sh"
        
        // Make sure the script is executable
        exec {
            commandLine("chmod", "+x", scriptPath)
        }
        
        // Run the script
        exec {
            commandLine(scriptPath)
        }
        
        println("Kotlin visibility fixing completed")
    }
}
