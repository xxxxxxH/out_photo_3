package net.widget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.flyco.animation.Attention.Swing
import com.flyco.dialog.widget.base.BaseDialog
import net.basicmodel.R
import net.utils.DialogClickListener

class EditorDialog(context: Context, val listener: DialogClickListener) :
    BaseDialog<EditorDialog>(context) {

    private var takePhoto: TextView? = null
    private var choosePhoto: TextView? = null
    private var cancel: TextView? = null

    override fun onCreateView(): View {
        widthScale(0.85f)
        showAnim(Swing())
        val view = LayoutInflater.from(context).inflate(R.layout.layout_dialog_select, null)
        takePhoto = view.findViewById(R.id.take)
        choosePhoto = view.findViewById(R.id.choose)
        cancel = view.findViewById(R.id.cancel)
        return view
    }

    override fun setUiBeforShow() {
        takePhoto?.let {
            it.setOnClickListener {
                listener.takePhoto()
                this.dismiss()
            }
        }
        choosePhoto?.let {
            it.setOnClickListener {
                listener.choosePhoto()
                this.dismiss()
            }
        }
        cancel?.let {
            it.setOnClickListener {
                this.dismiss()
            }
        }

    }
}