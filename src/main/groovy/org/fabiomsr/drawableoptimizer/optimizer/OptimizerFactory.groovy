package org.fabiomsr.drawableoptimizer.optimizer

import org.fabiomsr.drawableoptimizer.optimizer.impl.PngquantOptimizer
import org.fabiomsr.drawableoptimizer.optimizer.impl.PngtasticOptimizer
import org.fabiomsr.drawableoptimizer.optimizer.impl.ZopfliOptimizer

/**
 * Created by fabiomsr on 19/4/16.
 */
enum OptimizerFactory {
    INSTANCE;

    def optimizers

    private OptimizerFactory() {
        optimizers = [(OptimizerConstants.PNGTASTIC): new PngtasticOptimizer(),
                      (OptimizerConstants.ZOPFLI)   : new ZopfliOptimizer(),
                      (OptimizerConstants.PNGQUANT)   : new PngquantOptimizer()]
    }

    def Optimizer getOptimizer(def optimizerType){
        return optimizers[optimizerType] as Optimizer
    }

}
