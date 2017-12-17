package com.greenapp.zaba37.tar.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth

import com.greenapp.zaba37.tar.R

class StartAppFragment : Fragment() {

   // private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_start_app, container, false)
    }

    fun onButtonPressed(view: View) {
//        if (mListener != null) {
//
//        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            mListener = context
//        } else {
//            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
      //  mListener = null
    }

//    interface OnFragmentInteractionListener {
//        fun onFragmentInteraction(uri: Uri)
//    }

    companion object {
        fun newInstance(): StartAppFragment {
            return StartAppFragment()
        }
    }
}
