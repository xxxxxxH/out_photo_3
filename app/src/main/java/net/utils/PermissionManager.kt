package net.utils

import android.content.Context
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.XXPermissions

class PermissionManager {
    companion object {
        private var i: PermissionManager? = null
            get() {
                field ?: run {
                    field = PermissionManager()
                }
                return field
            }

        @Synchronized
        fun get(): PermissionManager {
            return i!!
        }
    }

    fun requestPermission(context: Context, callback: OnPermissionCallback) {
        XXPermissions.with(context)
            .permission(Constant.permissions)
            .request(callback)
    }
}