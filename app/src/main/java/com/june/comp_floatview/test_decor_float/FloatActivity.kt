package com.june.comp_floatview.test_decor_float

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.edit
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.june.R
import kotlinx.android.synthetic.main.float_window.view.*

/**
 * * 带悬浮窗操作的Activity
 * */
open class FloatActivity : AppCompatActivity() {
    private var offX = 0
    private var offY = 0
    private var isPressing = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 根据Activity的生命周期显示或移除悬浮窗
        this.lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            fun onResume() {
                // 在Activity可见时加载悬浮窗
                showFloatWindow(isShowing(applicationContext))
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop() {
                // 由于悬浮窗是每个Activity都有的，所以在暂停时移除以释放资源
                removeFloatWindow()
            }
        })
    }

    /**
     * * 定义一个悬浮窗，这个悬浮窗只是一个普通的View对象
     * * 可以根据需求定义不同的窗体
     * */
    @SuppressLint("ClickableViewAccessibility")
    private fun buildFloatWindow(): View {
        val view = LayoutInflater.from(this).inflate(
            R.layout.float_window,
            null,
            false
        )
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.btnClose.setOnClickListener {
            showFloatWindow(false)
        }
        view.ivIcon.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    offX =
                        event.rawX.toInt() - view.x.toInt()
                    offY =
                        event.rawY.toInt() - view.y.toInt()
                    isPressing = true
                    return@setOnTouchListener true
                }
                MotionEvent.ACTION_UP -> {
                    isPressing = false
                    saveLocation(this, view.x.toInt(), view.y.toInt())
                    return@setOnTouchListener true
                }
                MotionEvent.ACTION_MOVE -> {
                    if (isPressing) {
                        view.x = event.rawX - offX
                        view.y = event.rawY - offY
                    }
                    return@setOnTouchListener true
                }
            }
            false
        }
        return view
    }

    /**
     * * 设置悬浮窗的显示或隐藏
     * */
    protected fun showFloatWindow(isShow: Boolean) {
        val vgContent = findViewById<FrameLayout>(android.R.id.content)
        if (vgContent.childCount == 1) {
            vgContent.addView(FrameLayout(this))
        }
        val vgFloatContainer = vgContent.getChildAt(1) as ViewGroup
        if (isShow) {
            if (vgFloatContainer.childCount == 0) {

                val viewFloat = buildFloatWindow()

                viewFloat.x = loadLocationX(this).toFloat()
                viewFloat.y = loadLocationY(this).toFloat()

                vgFloatContainer.addView(viewFloat)
            }
        } else {
            vgFloatContainer.removeAllViews()
        }
        setShowing(this, isShow)
    }

    /**
     * * 删除悬浮窗
     * */
    protected fun removeFloatWindow() {
        val vgContent = findViewById<FrameLayout>(android.R.id.content)
        if (vgContent.childCount == 2)
            vgContent.removeViewAt(1)
    }

    /**
     * * 保存和读取悬浮窗的参数到配置文件
     * */
    companion object {
        private const val FILE = "floatWindow"
        fun isShowing(ctx: Context): Boolean {
            return ctx.getSharedPreferences(FILE, Context.MODE_PRIVATE).getBoolean("show", false)
        }

        private fun setShowing(ctx: Context, isShowing: Boolean) {
//            ctx.getSharedPreferences(FILE, Context.MODE_PRIVATE)
//                .edit { putBoolean("show", isShowing) }

            ctx.getSharedPreferences(FILE, Context.MODE_PRIVATE).edit()
                .putBoolean("show", isShowing)
                .commit()
            //    }
        }

        private fun loadLocationX(ctx: Context): Int {
            return ctx.getSharedPreferences(FILE, Context.MODE_PRIVATE).getInt("x", 0)
        }

        private fun loadLocationY(ctx: Context): Int {
            return ctx.getSharedPreferences(FILE, Context.MODE_PRIVATE).getInt("y", 0)
        }

        private fun saveLocation(ctx: Context, x: Int, y: Int) {
//            ctx.getSharedPreferences(
//                FILE,
//                Context.MODE_PRIVATE
//            ).edit {
//                putInt("x", x)
//                putInt("y", y)
//            }

            ctx.getSharedPreferences(FILE, Context.MODE_PRIVATE).edit()
                .putInt("x", x)
                .putInt("y", y)
                .commit()
        }
    }
}