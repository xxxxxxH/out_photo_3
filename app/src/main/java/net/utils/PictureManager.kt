package net.utils

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import net.basicmodel.CropActivity

class PictureManager {
    companion object {
        private var i: PictureManager? = null
            get() {
                field ?: run {
                    field = PictureManager()
                }
                return field
            }

        @Synchronized
        fun get(): PictureManager {
            return i!!
        }
    }

    private fun next(activity: Activity,type:String,path:String){
        val i = Intent(activity, CropActivity::class.java)
        type.apply {
            i.putExtra(Constant.TYPE, this.substring(this.lastIndexOf('/') + 1))
        }
        i.putExtra(Constant.DATA, path)
        activity.startActivity(i)
    }

    fun takePhoto(activity: AppCompatActivity,type:String) {
        PictureSelector.create(activity)
            .openCamera(PictureMimeType.ofImage())
            .imageEngine(GlideImageEngine())
            .forResult(object :OnResultCallbackListener<LocalMedia>{
                override fun onResult(result: MutableList<LocalMedia>?) {
                    result!!.apply {
                        val path = this[0].path
                        next(activity,type,path)
                    }
                }

                override fun onCancel() {

                }
            })
    }

    fun choosePhoto(activity: AppCompatActivity,type:String) {
        PictureSelector.create(activity)
            .openGallery(PictureMimeType.ofImage())
            .isCamera(false)
            .maxSelectNum(1)
            .imageEngine(GlideImageEngine())
            .forResult(object :OnResultCallbackListener<LocalMedia>{
                override fun onResult(result: MutableList<LocalMedia>?) {
                    result!!.apply {
                        val path = this[0].path
                        next(activity,type,path)
                    }
                }

                override fun onCancel() {

                }
            })
    }
}