package com.june.comp_download

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.june.R
import kotlinx.android.synthetic.main.activity_down_load.*
import java.io.*
import java.net.MalformedURLException
import java.net.URL

class DownLoadActivity : AppCompatActivity(), View.OnClickListener {

    //下载路径
//    val FILE_PATH = this.getApplicationContext().getExternalFilesDir("")?.getAbsolutePath() ?: ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_down_load)

        mTvStartDownLoad.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val strContent = mEditTextUrl.text.toString()

        if (strContent == null || strContent.length == 0) {
            Toast.makeText(this, "下载失败,链接异常", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "开始下载...", Toast.LENGTH_SHORT).show()

            Thread(Runnable {
                download(strContent)
            }).start()
        }
    }

    @Throws(Exception::class)
    fun download(docUrl: String): String? {
        /***加载正文 */
        //获取存储卡路径、构成保存文件的目标路径
        var dirName = ""

        //SD卡具有读写权限、指定附件存储路径为SD卡上指定的文件夹
//        dirName = Environment.getExternalStorageDirectory().toString() + "/Signature/"
        dirName = this.getApplicationContext().getExternalFilesDir("")?.getAbsolutePath() ?: ""

        val f = File(dirName)
        if (!f.exists()) {      //判断文件夹是否存在
            f.mkdir() //如果不存在、则创建一个新的文件夹
        }
        //准备拼接新的文件名
        val list = docUrl.split("/".toRegex()).toTypedArray()
        var fileName: String? = list[list.size - 1]
        fileName = dirName + fileName
        val file = File(fileName)
        if (file.exists()) {    //如果目标文件已经存在
            file.delete() //则删除旧文件
        }
        //1K的数据缓冲
        val bs = ByteArray(1024)
        //读取到的数据长度
        var len: Int
        try {
            //通过文件地址构建url对象
            val url = URL(docUrl)
            //获取链接
            //URLConnection conn = url.openConnection();
            //创建输入流
            val inputStream: InputStream = url.openStream()
            //获取文件的长度
            //int contextLength = conn.getContentLength();
            //输出的文件流
            val os: OutputStream = FileOutputStream(file)
            //开始读取
            while (inputStream.read(bs).also { len = it } != -1) {
                os.write(bs, 0, len)
            }

            Log.d("july", "download:下载成功! ")

            //完毕关闭所有连接
            os.close()
            inputStream.close()
        } catch (e: MalformedURLException) {
            fileName = null
            println("创建URL对象失败")
            throw e
        } catch (e: FileNotFoundException) {
            fileName = null
            println("无法加载文件")
            throw e
        } catch (e: IOException) {
            fileName = null
            println("获取连接失败")
            throw e
        }
        return fileName
    }
}