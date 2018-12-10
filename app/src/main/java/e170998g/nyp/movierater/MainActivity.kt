package e170998g.nyp.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(tvAdd)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.tvAdd)
        {
            menu?.add(1,100,1,"Add Movie")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(this, AddMovieActivity::class.java)
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK )


        if (item?.itemId == 100) {
            startActivity(intent)
        }

        return super.onContextItemSelected(item)
    }
}
