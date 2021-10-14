package net.basicmodel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hjq.permissions.OnPermissionCallback
import kotlinx.android.synthetic.main.activity_main.*
import net.utils.PermissionManager

class MainActivity : AppCompatActivity(), OnPermissionCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PermissionManager.get().requestPermission(this,this)
    }

    override fun onGranted(permissions: MutableList<String>?, all: Boolean) {
        editor.setOnClickListener {
            startActivity(Intent(this, EditorActivity::class.java))
        }
    }
}