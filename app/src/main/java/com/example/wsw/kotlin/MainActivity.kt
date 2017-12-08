package com.example.wsw.kotlin

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wsw.kotlin.ui.FitnessHomeActivity
import kotlinx.android.synthetic.main.activity_register_login.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_login)
        tv_login.text="我是登录按钮"
        tv_register.text="我是注册按钮"
        tv_login.setOnClickListener {
            startActivity(Intent(this, FitnessHomeActivity::class.java))
        }
        tv_register.setOnClickListener {
            toast(tv_register.text as String)
            var intent =Intent()
            intent.setClass(this,MapActivity::class.java)
            startActivity(intent)
        }
    }

    private var makeText: Toast? = null

    fun Context.toast(text : String){
        makeText = Toast.makeText(this, text, Toast.LENGTH_SHORT)
        makeText!!.show()
    }

}
