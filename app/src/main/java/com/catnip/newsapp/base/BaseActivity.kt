package com.catnip.newsapp.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.catnip.newsapp.utils.networkchecker.ConnectivityManager
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
abstract class BaseActivity<B : ViewBinding, out VM : KClass<BaseViewModel>>(val bindingFactory: (LayoutInflater) -> B) :
    AppCompatActivity() {
    private lateinit var binding: B
    val viewModel: VM by viewModel()
    val connectivityManager : ConnectivityManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun onStart() {
        super.onStart()
        connectivityManager.registerConnectionObserver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        connectivityManager.unregisterConnectionObserver(this)
    }

    fun getViewBinding(): B = binding
    abstract fun initView()
}