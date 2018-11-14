package e170998g.nyp.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun Add_Movie(v: View){

        Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show()
    }
}
