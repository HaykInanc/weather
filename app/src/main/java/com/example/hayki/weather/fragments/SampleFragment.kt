package com.example.hayki.weather.fragments

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.hayki.weather.R
import com.example.hayki.weather.SampleApplication
import com.example.hayki.weather.presenters.SamplePresenter
import com.example.hayki.weather.views.SampleView
import ru.terrakok.cicerone.Router

class SampleFragment : MvpAppCompatFragment(), SampleView{

    private var toolbar: Toolbar? = null
    private var backCommandBt: View? = null
    private var forwardCommandBt: View? = null
    private var replaceCommandBt: View? = null
    private var newChainCommandBt: View? = null
    private var newRootCommandBt: View? = null
    private var forwardWithDelayCommandBt: View? = null
    private var backToCommandBt: View? = null
    private var finishChainCommandBt: View? = null

    internal lateinit var router: Router

    @InjectPresenter
    internal lateinit var  presenter: SamplePresenter

    val number: Int
        get() = arguments!!.getInt(EXTRA_NUMBER)

    val creationTime: Long
        get() = arguments!!.getLong(EXTRA_TIME, 0L)

    @ProvidePresenter
    fun createSamplePresenter(): SamplePresenter {
        return SamplePresenter(router, arguments!!.getInt(EXTRA_NUMBER))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router = SampleApplication.INSTANCE.router
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar) as Toolbar
        backCommandBt = view.findViewById(R.id.back_command)
        forwardCommandBt = view.findViewById(R.id.forward_command)
        replaceCommandBt = view.findViewById(R.id.replace_command)
        newChainCommandBt = view.findViewById(R.id.new_chain_command)
        newRootCommandBt = view.findViewById(R.id.new_root_command)
        forwardWithDelayCommandBt = view.findViewById(R.id.forward_delay_command)
        backToCommandBt = view.findViewById(R.id.back_to_command)
        finishChainCommandBt = view.findViewById(R.id.finish_chain_command)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        toolbar!!.setNavigationOnClickListener { presenter!!.onBackCommandClick() }
        backCommandBt!!.setOnClickListener { presenter!!.onBackCommandClick() }
        forwardCommandBt!!.setOnClickListener { presenter!!.onForwardCommandClick() }
        replaceCommandBt!!.setOnClickListener { presenter!!.onReplaceCommandClick() }
        newChainCommandBt!!.setOnClickListener { presenter!!.onNewChainCommandClick() }
        newRootCommandBt!!.setOnClickListener { presenter!!.onNewRootCommandClick() }
        forwardWithDelayCommandBt!!.setOnClickListener { presenter!!.onForwardWithDelayCommandClick() }
        backToCommandBt!!.setOnClickListener { presenter!!.onBackToCommandClick() }
        finishChainCommandBt!!.setOnClickListener { presenter!!.onFinishChainCommandClick() }
    }

    fun setTitle(title: String) {
        toolbar!!.title = title
    }

    fun onBackPressed(): Boolean {
        presenter!!.onBackCommandClick()
        return true
    }

    companion object {
        private val EXTRA_NUMBER = "extra_number"
        private val EXTRA_TIME = "extra_time"

        fun getNewInstance(number: Int): SampleFragment {
            val fragment = SampleFragment()

            val args = Bundle()
            args.putInt(EXTRA_NUMBER, number)
            args.putLong(EXTRA_TIME, System.currentTimeMillis())
            fragment.arguments = args

            return fragment
        }
    }
}
