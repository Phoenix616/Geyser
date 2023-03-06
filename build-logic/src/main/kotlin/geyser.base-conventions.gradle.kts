plugins {
    `java-library`
    `eclipse`
    id("net.kyori.indra")
}

dependencies {
    compileOnly("org.checkerframework", "checker-qual", "3.19.0")
}

indra {
    github("GeyserMC", "Geyser") {
        ci(true)
        issues(true)
        scm(true)
    }
    mitLicense()

    javaVersions {
        target(16)
    }
}

tasks {
    processResources {
        // Spigot, BungeeCord, Velocity, Sponge, Fabric
        filesMatching(listOf("plugin.yml", "bungee.yml", "velocity-plugin.json", "META-INF/sponge_plugins.json", "fabric.mod.json")) {
            expand(
                "id" to "geyser",
                "name" to "Geyser",
                "version" to project.version,
                "description" to project.description,
                "url" to "https://geysermc.org",
                "author" to "GeyserMC"
            )
        }
    }
}

eclipse {
    classpath.file.whenMerged {
        (this as org.gradle.plugins.ide.eclipse.model.Classpath).entries.forEach { entry ->
            if (entry is org.gradle.plugins.ide.eclipse.model.Library) {
                entry.entryAttributes["module"] = false
            }
        }
    }
}
