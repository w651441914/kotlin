package com.example.wsw.kotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.wsw.kotlin.R
import com.example.wsw.kotlin.view.Topbar
import kotlinx.android.synthetic.main.fragment_fitnessdrill.view.*

/**
 *
 * @author wsw on 2017/12/6.
 */
class FitnessDrillFragment : Fragment() {
    var jni_fdf_topbar : Topbar?=null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val vi : View = inflater!!.inflate(R.layout.fragment_fitnessdrill, container, false)
        jni_fdf_topbar=vi.jni_fdf_topbar
        initView()
        return vi
    }

    private fun initView(){
        jni_fdf_topbar!!.setTitle("训练")
        jni_fdf_topbar!!.setRightTVContent("点我一下")
        jni_fdf_topbar!!.setEventInterface(object : Topbar.EventInterface{
            override fun leftOnClick() {
                activity.finish()
            }

            override fun rightOnClick() {
                Log.e("0000","4445564")
                Toast.makeText(activity,"我是右边的按钮",Toast.LENGTH_SHORT).show()
            }

        })
    }
}