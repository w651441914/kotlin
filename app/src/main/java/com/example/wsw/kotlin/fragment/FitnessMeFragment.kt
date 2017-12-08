package com.example.wsw.kotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wsw.kotlin.R

/**
 *
 * @author wsw on 2017/12/6.
 */
class FitnessMeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater!!.inflate(R.layout.fragment_fitnessme, container, false)
        return inflate
    }
}