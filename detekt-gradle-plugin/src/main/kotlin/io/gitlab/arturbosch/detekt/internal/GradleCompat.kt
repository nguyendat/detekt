package io.gitlab.arturbosch.detekt.internal

import org.gradle.api.Project
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.util.GradleVersion

fun Project.fileProperty(): RegularFileProperty {
    return if (GradleVersion.current() < GradleVersion.version("5.0")) {
        layout.fileProperty()
    } else {
        objects.fileProperty()
    }
}

fun Project.configurableFileCollection(): ConfigurableFileCollection {
    return if (GradleVersion.current() < GradleVersion.version("5.3")) {
        layout.configurableFiles()
    } else {
        objects.fileCollection()
    }
}
