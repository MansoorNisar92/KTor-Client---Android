package com.ktor.application.di

import com.ktor.application.client.FakeServiceImpl
import com.ktor.application.client.Services
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepoModule::class]
)
abstract class TestRepoModule {

    @Binds
    abstract fun bindServiceImpl(servicesImpl: FakeServiceImpl): Services
}