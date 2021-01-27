package com.june.comp_pack_name

import android.content.pm.PackageInfo
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.june.R
import com.june.comp_pack_name.adapter.MyAdapter
import kotlinx.android.synthetic.main.activity_print_pack_name2.*
import java.util.*

//adb命令
//1.adb shell
//2.pm uninstall --user 0 com.XX.XX(包名)
class PrintPackNameActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private val mAllList by lazy { getInitData() }
    private val myAdapter by lazy { MyAdapter(this, mAllList) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_print_pack_name2)
        mSearchView.setOnQueryTextListener(this)
//        mSearchView.isSubmitButtonEnabled = false

        mPackNameList.adapter = myAdapter
    }

    private fun getInitData(): ArrayList<String?> {
        val dataList = ArrayList<String?>()
        var packLists: List<PackageInfo?> = ArrayList()
        try {
            packLists = packageManager.getInstalledPackages(0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        for ((index, info) in packLists.withIndex()) {
            if (info == null) continue
            val appName: String? = info.applicationInfo.loadLabel(packageManager).toString()
            if (appName != null && appName.length != 0) {
                dataList.add("$index.<${appName}>\n${info.packageName}".trimIndent())
            }
        }
        return dataList
    }

    override fun onQueryTextChange(newText: String): Boolean {
        updateLayout(searchItem(newText))
        return false
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        return false
    }

    private fun searchItem(name: String?): ArrayList<String?> {
        val searchResultList = ArrayList<String?>()
        for (i in mAllList.indices) {
            val index = mAllList[i]?.indexOf(name!!)
            // 存在匹配的数据
            if (index != -1) {
                searchResultList.add(mAllList[i])
            }
        }
        return searchResultList
    }


    //刷新列表数据和展示
    fun updateLayout(dataList: List<String?>?) {
        myAdapter.updataDataList(dataList)
        myAdapter.notifyDataSetChanged()
    }
}