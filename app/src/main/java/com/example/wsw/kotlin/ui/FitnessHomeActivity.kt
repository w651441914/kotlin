package com.example.wsw.kotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import com.example.wsw.kotlin.R
import com.example.wsw.kotlin.fragment.FitnessCircleFragment
import com.example.wsw.kotlin.fragment.FitnessDrillFragment
import com.example.wsw.kotlin.fragment.FitnessFindFragment
import com.example.wsw.kotlin.fragment.FitnessMeFragment
import kotlinx.android.synthetic.main.activity_fitnesshome.*
import kotlinx.android.synthetic.main.fragment_medical_text_tab.view.*

/**健身首页
 * Created by 028 on 2017/12/5.
 */
class FitnessHomeActivity : AppCompatActivity() {
    private var mTabNames :Array<out String>?=null
    private val MFragmentArray : Array<Class<*>> = arrayOf(FitnessDrillFragment::class.java, FitnessFindFragment::class.java, FitnessCircleFragment::class.java, FitnessMeFragment::class.java)
    private var mIVSrcArray = intArrayOf(R.drawable.main_fitnessdrill_selector, R.drawable.main_fitnessfind_selector, R.drawable.main_fitnesscircle_selector, R.drawable.main_fitnessme_selector)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitnesshome)
        initView()
        initData()
    }

    private fun initData() {
        initTab()
    }

    private fun initView(){

    }

    /***
     * 关联tab和fragment
     */
    private fun initTab() {
        mTabNames = resources.getStringArray(R.array.tab_name)
        //实例化tabHost对象，得到tabHost
        tabHost.setup(this, supportFragmentManager, R.id.fl_realTabContent)
        val fragmentCount = MFragmentArray.size
        for (i in 0 until fragmentCount){
            //为每一个Tab按钮设置图标、文字和内容
            var tabSpec=tabHost.newTabSpec(mTabNames?.get(i)).setIndicator(getTabItemView(i))
            //去除分割线
            tabHost.tabWidget.dividerDrawable = null
            //将Tab按钮添加进Tab选项卡中
            tabHost.addTab(tabSpec,MFragmentArray?.get(i),null)
            //设置Tab按钮的背景
            tabHost.tabWidget.getChildAt(i).setBackgroundResource(R.color.color_FFFFFF)
        }
    }

    private fun getTabItemView(i: Int): View? {
        val inflate = LayoutInflater.from(this).inflate(R.layout.fragment_medical_text_tab, null)
        inflate.tv_tabHost.text= mTabNames?.get(i)
        inflate.iv_tabHost.setImageResource(mIVSrcArray?.get(i))
        return inflate
    }
}