package com.app.lerp.retoapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import com.app.lerp.retoapp.base.BaseActivity
import com.app.lerp.retoapp.databinding.ActivityLoginBinding
import com.app.lerp.retoapp.ui.movie.MovieActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by (this as FragmentActivity).viewModels()

    override fun startCreateViewBinding(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getDataActivityForResult(data: Intent?) {

    }

    override fun initView() {
        binding.buttonLogin.setOnClickListener {
            val usuario = binding.editTextNameUsuario.text.toString()
            val clave = binding.editTextClaveUsuario.text.toString()
            validateUser(usuario, clave)

        }
    }

    private fun validateUser(usuario: String, clave: String) {
        if (usuario.isEmpty()) {
            hideProgressDialog()
            showMessageToast("Ingrese el usuario")
            return
        }
        if (clave.isEmpty()) {
            hideProgressDialog()
            showMessageToast("Ingrese la clave usuario")
            return
        }
        viewModel.initUserSesion(usuario, clave)
    }

    override fun initViewModel() {
        viewModel.signInLiveData.observe(this) {
            when (it) {
                is LoginEventResult.Success -> {
                    hideProgressDialog()
                    showMessageSnack("Inicio Sesion")
                    startActivity(Intent(this, MovieActivity::class.java))
                    finish()
                }
                is LoginEventResult.Error -> {
                    hideProgressDialog()
                    showMessageSnack(it.ex.message.toString())
                }
                else -> {
                    hideProgressDialog()
                }
            }
        }
    }

    override fun initViewObserver() {

    }
}