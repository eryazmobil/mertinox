package eryaz.software.mertinox.data.di

import eryaz.software.mertinox.data.repositories.AuthRepo
import eryaz.software.mertinox.data.repositories.BarcodeRepo
import eryaz.software.mertinox.data.repositories.CountingRepo
import eryaz.software.mertinox.data.repositories.OrderRepo
import eryaz.software.mertinox.data.repositories.PlacementRepo
import eryaz.software.mertinox.data.repositories.UserRepo
import eryaz.software.mertinox.data.repositories.WorkActivityRepo
import org.koin.dsl.module

val appModuleRepos = module {

    factory { AuthRepo(get()) }

    factory { UserRepo(get()) }

    factory { WorkActivityRepo(get()) }

    factory { BarcodeRepo(get()) }

    factory { PlacementRepo(get()) }

    factory { OrderRepo(get()) }

    factory { CountingRepo(get()) }

}