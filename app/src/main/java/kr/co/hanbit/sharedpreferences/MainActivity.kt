package kr.co.hanbit.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.co.hanbit.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val shared = getSharedPreferences("파일명", Context.MODE_PRIVATE)  //"파일명"으로 저장된 sharedPreference 가져오기

        //val first_open = shared.getBoolean("key_first_open", false) //"파일명"에 있는 "key_first_open"키를 가진 어떤 값을 불렀을 때 없으면 default로 false
        val first_open = shared.getString("key_first_open", "처음") //"파일명"에 있는 "key_first_open"키를 가진 어떤 값을 불렀을 때 없으면 default로 false

        /* if (first_open) {
            binding.hello.visibility = View.GONE //첫 번째 오픈이 아니라면 없애기
        } */
        if (first_open != "처음") {
           binding.hello.visibility = View.GONE //첫 번째 오픈이 아니라면 없애기
        }

        val editor = shared.edit() //수정을 위한 에디터를 꺼낸다
        //editor.putBoolean("key_first_open", true) //오픈하고 나면 true로 변경
        editor.putString("key_first_open", "두번째") //오픈하고 나면 "두번째"로 변경
        editor.commit()
    }
}