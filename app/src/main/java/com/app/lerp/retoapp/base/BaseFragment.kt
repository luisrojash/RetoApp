package com.app.lerp.retoapp.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.fragment.app.Fragment
import com.app.lerp.retoapp.ui.dialog.ProgressDialog

abstract class BaseFragment : Fragment() {

    private var progressDialog: ProgressDialog = ProgressDialog()
    private var progressIniciado = false

    fun showProgressDialog() {
        if (!progressIniciado) {
            progressDialog.isCancelable = false
            progressIniciado = true
            progressDialog.show(parentFragmentManager, "")
        }
    }

    fun hideProgressDialog() {
        if (progressIniciado) {
            progressDialog.dismiss()
            progressIniciado = false
        }
    }

    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        capabilities?.let {
            if (it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                return true
            } else if (it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                return true
            } else if (it.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                return true
            }
        }
        return false
    }

}