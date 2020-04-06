package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.service.CleanAceService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val TAG = javaClass.simpleName
        val cleanAceService = CleanAceService.instance
        val signInCall = cleanAceService.signIn()
        signInCall.enqueue(object : Callback<SignInResponse> {
            override fun onFailure(call: Call<SignInResponse>?,
                                   t: Throwable?) {
                Log.i(TAG, "Call to ${call?.request()?.url()} " +
                        "failed with ${t.toString()}")
            }
            override fun onResponse(call: Call<SignInResponse>?, response: Response<SignInResponse>?) {
                Log.i(TAG, "Got response with status code " +
                        "${response?.code()} and message " +
                        "${response?.message()}")
                val body = response?.body()
                Log.i(TAG, "Response body = $body")
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}