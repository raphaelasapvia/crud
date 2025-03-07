package com.example.crud.di

import com.example.crud.remotedatasource.api.UserApi
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    createApis()
}

private fun Module.createApis() {
    single<UserApi> { get<Retrofit>(named(BaseUrl.BASE)).create(UserApi::class.java) }
}