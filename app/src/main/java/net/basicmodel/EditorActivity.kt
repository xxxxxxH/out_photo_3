package net.basicmodel

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import kotlinx.android.synthetic.main.layout_activity_editor.*
import net.adapter.EditorAdapter
import net.utils.DialogClickListener
import net.utils.PictureManager
import net.utils.ResourceManager
import net.widget.EditorDialog

class EditorActivity : AppCompatActivity(), OnItemClickListener, DialogClickListener {

    var dialog: EditorDialog? = null
    var type: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_editor)
        initView()
    }

    private fun initView() {
        val editorAdapter =
            EditorAdapter(R.layout.layout_item_editor, ResourceManager.get().getEditorItemRes(this))
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = editorAdapter
        editorAdapter.setOnItemClickListener(this)
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        type = adapter.data[position].toString()
        dialog = EditorDialog(this, this)
        dialog!!.show()
    }

    override fun takePhoto() {
        type?.let { PictureManager.get().takePhoto(this, it) }
    }

    override fun choosePhoto() {
        type?.let { PictureManager.get().choosePhoto(this, it) }
    }
}