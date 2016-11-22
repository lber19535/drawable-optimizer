package org.fabiomsr.drawableoptimizer.extension

import org.fabiomsr.drawableoptimizer.optimizer.OptimizerConstants

import java.util.zip.Deflater

/**
*  Created by fabiomsr on 12/3/16.
*/
class DrawableOptimizerExtension {

    /**
     * The optimizer
     */
    def optimizer = OptimizerConstants.PNGQUANT

    /**
     * The compression level; 0-9 allowed. Default is to try them all by brute force (useful for pngtastic compressor)
     */
    def compressionLevel = Deflater.BEST_COMPRESSION

    /**
     *  Number of compression iterations (useful for zopfli)
     */
    def iterations = OptimizerConstants.DEFAULT_ITERATIONS

    /**
     * The level of logging output (none, debug, info, or error)
     */
    def logLevel = OptimizerConstants.DEFAULT_LOG_LEVEL

    /**
     * Execute only on release build
     */
    def onlyOnRelease = false


}
