package com.example.wsw.kotlin.view

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.wsw.kotlin.R
import kotlinx.android.synthetic.main.layout_jin_top_bar.view.*
import java.util.jar.Attributes


/**
 *
 * @author wsw on 2017/12/6.
 */
class Topbar: RelativeLayout {
    /**
     * 上下文
     */
    private var mContext :Context? =null
    /**
     * topbar整体view
     */
    private var inflate : View?=null
    /**
     *
     * 布局左侧图标控件
    */
    private var iv_ljtb_left_back :ImageView?=null
    /**
     * 父容器
     */
    private var rl_ljtb_layout :RelativeLayout?=null
    /**
     * 布局左侧按钮容器
     */
    private var rl_ljtb_left_layout :LinearLayout?=null
    /**
     * 布局中间标题文本控件
     */
    private var tv_ljtb_title :TextView?=null
    /**
     * 布局左侧文本控件
     */
    private var tv_ljtb_left_back :TextView?=null
    /**
     * 布局右侧按钮容器
     */
    private var rl_ljtb_right_layout :LinearLayout?=null
    /**
     * 布局右侧图标控件
     */
    private var iv_ljtb_right_back :ImageView?=null
    /**
     * 布局底部分割线控件
     */
    private var view_ljtb_divider :View?=null
    /**
     *
     * 布局右侧文本控件
    */
    private var tv_ljtb_right_back :TextView?=null
    /**
     * 布局控件事件接口对象
     */
    private var eventInterface : EventInterface?=null
    constructor(context: Context):super (context){
        mContext=context
        iniView()
        initViewEvent()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        mContext=context
        iniView()
        initViewEvent()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext=context
        iniView()
        initViewEvent()
    }

    private fun initViewEvent() {
        if(mContext==null){
            return
        }
            if(rl_ljtb_left_layout!=null){
                if(iv_ljtb_left_back!!.visibility== View.VISIBLE||tv_ljtb_left_back!!.visibility== View.VISIBLE){
                    rl_ljtb_left_layout!!.setOnClickListener {
                        eventInterface?.leftOnClick()
                    }
                }
            }
            if(rl_ljtb_right_layout!=null){
                if(iv_ljtb_right_back!!.visibility== View.VISIBLE||tv_ljtb_right_back!!.visibility== View.VISIBLE){
                    rl_ljtb_right_layout!!.setOnClickListener {
                        eventInterface?.rightOnClick()
                    }
                }
            }

    }

    fun iniView(){
        if (mContext==null){
            return
        }
        inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_jin_top_bar, null)
        iv_ljtb_left_back = inflate!!.iv_ljtb_left_back
        rl_ljtb_layout = inflate!!.rl_ljtb_layout
        rl_ljtb_left_layout=inflate!!.rl_ljtb_left_layout
        tv_ljtb_title=inflate!!.tv_ljtb_title
        tv_ljtb_left_back=inflate!!.tv_ljtb_left_back
        rl_ljtb_right_layout=inflate!!.rl_ljtb_right_layout
        iv_ljtb_right_back=inflate!!.iv_ljtb_right_back
        view_ljtb_divider=inflate!!.view_ljtb_divider
        tv_ljtb_right_back=inflate!!.tv_ljtb_right_back
        addView(inflate)
    }
    /**
     * 设置父容器背景颜色
     *
     * @param color 颜色的资源ID
     */
    fun setLayoutBGColor(color:Int){
        if (rl_ljtb_layout==null){
            return
        }
        rl_ljtb_layout!!.setBackgroundColor(color)
    }
    /**
     * 设置标题内容
     *
     * @param title 标题文字内容
     */
    fun setTitle(text :String){
        if(tv_ljtb_title==null){
            return
        }
        if(TextUtils.isEmpty(text)){
            tv_ljtb_title!!.visibility= View.GONE
        }else{
            tv_ljtb_title!!.text=text
            tv_ljtb_title!!.visibility= View.VISIBLE
        }
    }

    /**
     * 设置标题文字大小
     *
     * @param size 标题文字大小，默认转成sp
     */
    fun setTitleFontSize(size : Int){
        if(tv_ljtb_title==null){
            return
        }
        if(size>0){
            tv_ljtb_title!!.textSize= size.toFloat()
        }
    }
    /**
     * 设置标题字体颜色
     *
     * @param color 颜色的资源ID
     */
    fun setTitleColor(color: Int){
        if(tv_ljtb_title==null){
            return
        }
        tv_ljtb_title!!.setTextColor(color)
    }
    /**
     * 设置标题字体是否加粗
     */
    fun setTitleContentBold(){
        if(tv_ljtb_title==null){
                return
        }
        tv_ljtb_title!!.paint.isFakeBoldText=true
    }
    /**
     * 设置左侧按钮图标
     *
     * @param res 图片的资源ID
     */
    fun setLeftBtnImage(res:Int){
        if(iv_ljtb_left_back==null){
            return
        }
        iv_ljtb_left_back!!.setBackgroundResource(res)
        setLeftBtnImageShow(true)
    }
    /**
     * 设置左侧按钮图标显示状态
     *
     * @param show 图片控件显示状态
     */
    fun setLeftBtnImageShow(show: Boolean){
        if(iv_ljtb_left_back==null){
            return
        }
        if(show){
            iv_ljtb_left_back!!.visibility=View.VISIBLE
        }else{
            iv_ljtb_left_back!!.visibility= View.GONE
        }
    }

    /**
     * 设置左侧按钮文本内容
     *
     * @param content 文本文字内容
     */
    fun setLeftTVContent(text: String){
        if(tv_ljtb_left_back==null){
            return
        }
        if(TextUtils.isEmpty(text)){
            tv_ljtb_left_back!!.visibility= View.GONE
        }else{
            tv_ljtb_left_back!!.text=text
            tv_ljtb_left_back!!.visibility= View.VISIBLE
        }

    }
    /**
     * 设置左侧按钮文本字体大小
     *
     * @param size 标题文字大小，默认转成sp
     */
    fun setLeftTVFontSize(size: Int){
        if(tv_ljtb_left_back == null){
            return
        }
        if(size>0){
            tv_ljtb_left_back!!.textSize=size.toFloat()
        }
    }
    /**
     * 设置左侧按钮文本字体颜色
     *
     * @param color 颜色的资源ID
     */
    fun setLeftTVColor(color: Int){
        if(tv_ljtb_left_back == null){
            return
        }
        tv_ljtb_left_back!!.setTextColor(color)
    }
    /**
     * 设置左侧侧文本控件字体加粗
     */
    fun setLeftTVContentBold(){
        if(tv_ljtb_left_back==null){
            return
        }
        tv_ljtb_left_back!!.paint.isFakeBoldText=true
    }
    /**
     * 设置右侧按钮图标
     *
     * @param res 图片的资源ID
     */
    fun setRightBtnImage(res: Int){
        if(iv_ljtb_right_back==null){
            return
        }
        iv_ljtb_right_back!!.setBackgroundResource(res)
        setRightBtnImageShow(true)
    }
    /**
     * 设置右侧按钮图标显示状态
     *
     * @param show 图片控件显示状态
     */
    fun setRightBtnImageShow(show:Boolean){
        if(iv_ljtb_right_back==null){
            return
        }
        if(show){
            iv_ljtb_right_back!!.visibility= View.VISIBLE
        }else{
            iv_ljtb_right_back!!.visibility= View.GONE
        }
    }
    /**
     * 设置右侧按钮文本内容
     *
     * @param content 文本文字内容
     */
    fun setRightTVContent(content:String){
        if(tv_ljtb_right_back==null){
            return
        }
        if (TextUtils.isEmpty(content)){
            tv_ljtb_right_back!!.visibility= View.GONE
        }else{
            tv_ljtb_right_back!!.text=content
            tv_ljtb_right_back!!.visibility= View.VISIBLE
        }
    }
    /**
     * 设置右侧按钮文本字体大小
     *
     * @param size 标题文字大小，默认转成sp
     */
    fun setRightTVFontSize(size: Int){
        if(tv_ljtb_right_back==null){
            return
        }
        if (size>0){
            tv_ljtb_right_back!!.textSize=size.toFloat()
        }

    }
    /**
     * 设置右侧按钮文本字体颜色
     *
     * @param color 颜色的资源ID
     */
    fun setRightTVColor(color: Int){
        if (tv_ljtb_right_back==null) {
            return
        }
        tv_ljtb_right_back!!.setTextColor(color)
    }
    /**
     * 设置右侧文本控件字体加粗
     */
    fun setRightTVContentBold(){
        if (tv_ljtb_right_back==null){
            return
        }
        tv_ljtb_right_back!!.paint.isFakeBoldText=true
    }
    /**
     * 获取右侧textview控件
     */
    fun getRightTV() : TextView? {
        return tv_ljtb_right_back
    }
    /**
     * 设置是否显示底部分割线控件
     *
     * @param whetherShow 是否显示
     */
    fun setWhetherShowDividerView(show: Boolean){
        if(view_ljtb_divider==null){
            return
        }
        if(show){
            view_ljtb_divider!!.visibility= View.VISIBLE
        }else{
            view_ljtb_divider!!.visibility= View.GONE
        }
    }
    /** 获取父容器控件*/
    fun getRl_ljtb_layout():RelativeLayout?{
        return rl_ljtb_layout
    }
    /** 获取布局左侧按钮容器控件*/
    fun getRl_ljtb_left_layout():LinearLayout?{
        return rl_ljtb_left_layout
    }

    fun setEventInterface(eventInterface: EventInterface){
        this.eventInterface=eventInterface
        initViewEvent()
    }
    interface EventInterface{
        /**
         * 左侧按钮点击
         */
        fun leftOnClick()
        /**
         * 右侧按钮点击
         */
        fun rightOnClick()
    }
}