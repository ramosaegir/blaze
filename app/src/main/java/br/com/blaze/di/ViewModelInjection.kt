package br.com.blaze.di

import br.com.blaze.di.InjectionTags.SPLASH_VIEW_MODEL
import br.com.blaze.viewmodel.SplashViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class ViewModelInjection {

    val module = Kodein.Module {
        import(ModelInjection().module)

        bind<SplashViewModel>(SPLASH_VIEW_MODEL) with singleton {
            SplashViewModel()
        }
    }

}