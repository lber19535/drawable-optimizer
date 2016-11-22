package org.fabiomsr.drawableoptimizer.optimizer.impl

import org.fabiomsr.drawableoptimizer.optimizer.Optimizer
import org.fabiomsr.drawableoptimizer.util.PngquantFileSystemUtils
import org.gradle.api.Project

/**
 * Created by fabiomsr on 19/4/16.
 */
class PngquantOptimizer implements Optimizer {

    @Override
    void optimize(Project project, int compressionLevel, int iterations, String logLevel, File[] files) {

        PngquantFileSystemUtils.copyPngquantfliToBuildFolder(project)

        print("use Pngquant optimizer")

        files.each {
            def originalFileSize = it.length()

            def quantfliPath = PngquantFileSystemUtils.getPngquantfliFilePath(project)

            Process process = Runtime.getRuntime().exec(quantfliPath + " -f --ext \".png\" -- "+it.absolutePath);

            process.waitFor();

            def optimizedFileSize = new File(it.absolutePath).length()

            def fileSizeDifference = (optimizedFileSize <= originalFileSize) ?
                    (originalFileSize - optimizedFileSize) : -(optimizedFileSize - originalFileSize);

            if (logLevel == "debug" || logLevel == "info") {
                printf("%5.2f%% :%6dB ->%6dB (%5dB saved) -- %s\n",
                        fileSizeDifference / Float.valueOf(originalFileSize) * 100,
                        originalFileSize, optimizedFileSize, fileSizeDifference, it.absolutePath);
            }

        }
    }
}