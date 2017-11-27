package mchehab.com.fragmentlifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val lifecycleFragment = LifecycleFragment()
    private val TAG = "ACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setButtonAttachFragmentOnClick()
        setButtonDetachFragmentOnClick()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    private fun setButtonAttachFragmentOnClick() {
        findViewById<Button>(R.id.buttonAttachFragment).setOnClickListener({ addFragment() })
    }

    private fun setButtonDetachFragmentOnClick() {
        findViewById<Button>(R.id.buttonDetachFragment).setOnClickListener({ removeFragment() })
    }

    private fun addFragment() {
        fragmentManager.beginTransaction().add(R.id.frameLayout, lifecycleFragment).commit()
    }

    private fun removeFragment() {
        fragmentManager.beginTransaction().remove(lifecycleFragment).commit()
    }
}