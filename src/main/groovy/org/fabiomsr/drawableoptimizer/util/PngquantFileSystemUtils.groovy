package org.fabiomsr.drawableoptimizer.util

import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.Project

/**
 * Created by fabiomsr on 8/5/16.
 */
class PngquantFileSystemUtils {

    static def getPngquantfliDirectory(Project project){
        return new File(getPngquantfliDirectoryPath(project))
    }

    static def getPngquantfliFilename(Project project){
        return Os.isFamily(Os.FAMILY_WINDOWS) ? 'pngquant.exe' : 'zopflipng'
    }

    static def getPngquantfliFilePath(Project project){
        return getPngquantfliDirectoryPath(project) + File.separator + getPngquantfliFilename(project)
    }

    private static def getPngquantfliDirectoryPath(Project project){
        return project.buildDir.absolutePath + File.separator + 'pngquant'
    }

    static def copyPngquantfliToBuildFolder(Project project) {
        def pngquantfliFileDir = getPngquantfliDirectory(project)
        if(!pngquantfliFileDir.exists()) {
            pngquantfliFileDir.mkdirs()

            def pngquantfliFilename = getPngquantfliFilename(project)
            def pngquantfliFile = new File(getPngquantfliFilePath(project))

            new FileOutputStream(pngquantfliFile).withStream {
                def pngquantfliResource = "/pngquant/$pngquantfliFilename"
                def stream = PngquantFileSystemUtils.class.getResourceAsStream(pngquantfliResource)
                it.write(stream.getBytes())
            }

            pngquantfliFile.setExecutable(true)
        }
    }
}
