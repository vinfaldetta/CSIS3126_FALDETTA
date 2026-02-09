package com.example.budgetandfinanceingapplication

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.budgetandfinanceingapplication.network.RetrofitClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 🔌 Test Spring Boot connection
        RetrofitClient.api.testConnection()
            .enqueue(object : Callback<String> {

                override fun onResponse(
                    call: Call<String>,
                    response: Response<String>
                ) {
                    Log.d("API", "SUCCESS: ${response.body()}")
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.e("API", "FAILED", t)
                }
            })
    }
}