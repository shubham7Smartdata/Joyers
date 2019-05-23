package com.sdi.joyers.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sdi.joyers.data.UserModel
import com.sdi.joyers.repositories.UserRepository


class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: UserRepository = UserRepository(application)

    private var mUserModel: MutableLiveData<UserModel>? = null


    fun getUser(): MutableLiveData<UserModel> {
        if (mUserModel == null) {
            mUserModel = MutableLiveData()
        }
        return mUserModel as MutableLiveData<UserModel>
    }

//    fun onClick(view: View) {
//        when (view.id) {
//            R.id.btnLogin -> {
////                val loginUser =
////
//            }
//
//            R.id.btn_fb_login -> {
//
//            }
//
//            R.id.btn_google_login -> {
//
//            }
//        }
//    }

    fun setLoginData(mModel: UserModel) {
        mUserModel!!.value = mModel
    }

//    //Called from Activity receving result
//    fun onResultFromActivity(requestCode: Int, resultCode: Int, data: Intent?) {
//        when (requestCode) {
//            RC_SIGN_IN -> {
//                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//                handleSignInResult(task)
//            }
//        }
//    }
//
//    private fun signInGmail(activity: Activity) {
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestEmail()
//            .build()
//        mGoogleSignInClient = GoogleSignIn.getClient(activity, gso)
//        val signInIntent = mGoogleSignInClient.signInIntent
//        activity.startActivityForResult(signInIntent, RC_SIGN_IN)
//    }
//
//    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
//        try {
//            val account = completedTask.getResult(ApiException::class.java)
//
//            // Signed in successfully, show authenticated UI.
////            Log.w(TAG, "signInResult: code=$account")
//            mGoogleSignInClient.signOut()
//
////            updateUI(account)
//        } catch (e: ApiException) {
//            // The ApiException status code indicates the detailed failure reason.
//            // Please refer to the GoogleSignInStatusCodes class reference for more information.
////            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
//            //            updateUI(null);
//        }
//
//    }


//    fun facebookClicked(){
//        callbackManager = CallbackManager.Factory.create()
//        login_button.setReadPermissions(Arrays.asList("email"))
//
//        LoginManager.getInstance().registerCallback(callbackManager,
//            object : FacebookCallback<LoginResult> {
//                override fun onSuccess(loginResult: LoginResult) {
//                    var mAccessToken = loginResult.getAccessToken()
////                    loginPresenter.getUserProfile(mAccessToken)
//                }
//
//                override fun onCancel() {
//                    // App code
//                }
//
//                override fun onError(exception: FacebookException) {
//                    // App code
//                }
//            })
//    }


}