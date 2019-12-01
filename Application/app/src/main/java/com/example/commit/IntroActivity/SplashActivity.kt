package com.example.commit.IntroActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.StrictMode
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.commit.Class.UserInfo
import com.example.commit.MainActivity.MainActivity
import com.example.commit.R

class SplashActivity: AppCompatActivity() {



    val Duration:Long = 2000
    //onCreate : 액티비티가 생성될 때 실행되는 메소드
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView : 액티비티와 연결되는 레이아웃파일을 설정
        setContentView(R.layout.activity_splash)

        //스마트폰 인터넷 사용 권한 허가
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .permitDiskReads()
                .permitDiskWrites()
                .permitNetwork()
                .build())

        //프리퍼런스 검사 있으면 Main으로 startActivity 호출하고 return
        var pref=this.getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        UserInfo.ID=pref.getString("ID","")
        if(UserInfo.ID!="") {
            UserInfo.PW=pref.getString("PW","")
            UserInfo.NAME=pref.getString("NAME","")
            UserInfo.BIRTH=pref.getString("BIRTH","")
            UserInfo.GENDER=pref.getString("GENDER","")
            UserInfo.NICKNAME=pref.getString("NICKNAME","")
            UserInfo.EMAIL=pref.getString("EMAIL","")
            UserInfo.UNIV=pref.getString("UNIV","")
            UserInfo.ENTER=pref.getString("ENTER","")
            UserInfo.DEPT=pref.getString("DEPT","")
            UserInfo.IMG=pref.getString("IMG","")

            Handler().postDelayed({
                var intent:Intent = Intent(this,MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)  //액티비티 전환시 애니메이션을 무시
                startActivity(intent)
                finish()
            },Duration)
        }
        else {
            Handler().postDelayed({
                var intent: Intent = Intent(this, IntroActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)  //액티비티 전환시 애니메이션을 무시
                startActivity(intent)
                finish()
            }, Duration)
        }
    }
}