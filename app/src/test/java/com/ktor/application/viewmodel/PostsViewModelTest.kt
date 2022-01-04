package com.ktor.application.viewmodel

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.ktor.application.client.FakeServiceImpl
import com.ktor.application.extensions.inverse
import com.ktor.application.utils.MainCoroutineRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class, manifest = Config.NONE, sdk = [Build.VERSION_CODES.O_MR1])
class PostsViewModelTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule(order = 1)
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: PostsViewModel

    @Inject
    lateinit var serviceImpl: FakeServiceImpl

    @Before
    fun setUp() {
        hiltRule.inject()
        viewModel = PostsViewModel(serviceImpl)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun successApiWithActualResponse() = runBlockingTest{
        mainCoroutineRule.pauseDispatcher()
        viewModel.fetchPosts()
        Truth.assertThat(viewModel.postsStateFlow.value.isNullOrEmpty().inverse)

        // Execute pending coroutines actions
        mainCoroutineRule.resumeDispatcher()
    }

    @Test
    fun successApiWithEmptyResponse(){
        serviceImpl.setReturnEmpty(true)

    }

    @After
    fun tearDown() {

    }


}