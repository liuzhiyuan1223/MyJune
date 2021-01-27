package com.june.comp_counttimer_card

import android.content.Context
import android.os.CountDownTimer
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.june.R
import kotlinx.android.synthetic.main.view_cancel_remind_card.view.*

private const val TAG = "PsgCancelRemindCard"
class PsgCancelRemindCard : LinearLayout, View.OnClickListener {

    private var mCountTimer: CancelRemindCardCountTimer? = null
    private var mPsgInfoPresenter: PassengerInfoPresenter? = null
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_cancel_remind_card, this)
    }

    fun setPsgInfoPresenter(presenter: PassengerInfoPresenter?) {
        this.mPsgInfoPresenter = presenter
    }

    fun showPsgCancelCard(data: PassengerCancelModel?) {

        data?:return
        mCancelTitle.setText(data.subTitle)
        mCancelContent.setText(data.content)
        mConfirmBtn.setText(context.getString(R.string.i_known_psg_cancel, data.phoneExpired))
        mConfirmBtn.setOnClickListener(this)

        val v = data.phoneExpired * 1000

        mCountTimer = CancelRemindCardCountTimer(v.toLong(), 1000)
        mCountTimer?.start()
    }

    fun removePsgCancelCard() {
        this.onClick(null)
    }

    override fun onClick(v: View?) {
        mCountTimer?.cancel()
//        mPsgInfoPresenter?.removeCancelCardAndShowPsgCard()
        this.visibility = View.GONE
    }

    inner class CancelRemindCardCountTimer : CountDownTimer {
        constructor(millisInFuture: Long, countDownInterval: Long) : super(millisInFuture, countDownInterval)

        override fun onFinish() {
            removePsgCancelCard()
        }

        override fun onTick(millisUntilFinished: Long) {
            Log.d(TAG, "onTick: " + millisUntilFinished)

            val vTest = millisUntilFinished / 1000

//            mConfirmBtn.setText(context.getString(R.string.i_known_psg_cancel, millisUntilFinished.toInt()))
            mConfirmBtn.setText(context.getString(R.string.i_known_psg_cancel, vTest))
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mCountTimer?.cancel()
    }
}