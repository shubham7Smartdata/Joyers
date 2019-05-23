package com.sdi.joyers.activities

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import com.sdi.joyers.utils.NetworkUtils

/**
 * Created by shubham on 22/05/19.
 */

abstract class BaseActivity<V : AndroidViewModel> : AppCompatActivity() {

    // since its going to be common for all the activities
    var mViewModel: V? = null
    lateinit var mContext: Context

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
//    abstract val bindingVariable: Int

    /**
     * @return layout resource id
     */
    @get:LayoutRes
    abstract val layoutId: Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract val viewModel: V

    /**
     *
     * @return context
     */
    protected abstract val context: Context

    val isNetworkConnected: Boolean
        get() = NetworkUtils.isNetworkConnected(applicationContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        this.mContext = context
        this.mViewModel = if (mViewModel == null) viewModel else mViewModel
        onCreate()
        initListeners()
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    //    fun hideLoading() {
    //        if (mProgressDialog != null && mProgressDialog.isShowing) {
    //            mProgressDialog.cancel()
    //        }
    //    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    //    public void showLoading() {
    //        hideLoading();
    //        mProgressDialog = CommonUtils.showLoadingDialog(this);
    //    }

    abstract fun onCreate()
    abstract fun initListeners()

}

