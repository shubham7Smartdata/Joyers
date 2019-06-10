package com.sdi.joyers.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.sdi.joyers.R
import com.sdi.joyers.data.UserModel
import com.sdi.joyers.viewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : BaseActivity<UserViewModel>(), View.OnClickListener {

    private val RC_SIGN_IN = 1
    lateinit var mGoogleSignInClient: GoogleSignInClient

    override val layoutId: Int
        get() = R.layout.activity_sign_up

    override val viewModel: UserViewModel
        get() = ViewModelProviders.of(this).get(UserViewModel::class.java)

    override val context: Context
        get() = this@SignUpActivity

    override fun onCreate() {
        mViewModel!!.getUser().observe(this, object : Observer<UserModel> {
            override fun onChanged(@Nullable loginUser: UserModel) {
                txtEmail.text = loginUser.data.email
                txtName.text = loginUser.data.password
            }
        })
    }

    override fun initListeners() {
        btnLogin.setOnClickListener(this)
        btnChart.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnLogin -> {
                showProgress()
                mViewModel!!.setLoginData(edEmail.text.toString(), edName.text.toString())
            }
            R.id.btnChart -> {
                val intent = Intent(mContext, ColumnChartActivity::class.java)
                mContext.startActivity(intent)
            }
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                RC_SIGN_IN -> {
                    // The Task returned from this call is always completed, no need to attach
                    // a listener.
                    val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                    handleSignInResult(task)
                }
                Activity.RESULT_CANCELED -> {

                }
            }
        }

    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            Log.w(TAG, "signInResult: code=" + account!!)
            mGoogleSignInClient.signOut()

            updateUI(account = account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
            // updateUI(null);
        }

    }

    private fun signInGmail() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        val account = GoogleSignIn.getLastSignedInAccount(this)
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun updateUI(account: GoogleSignInAccount) {
        //  mViewModel!!.setLoginData(UserModel("1", account.email.toString(),
        //  account.displayName.toString()))
    }
}

