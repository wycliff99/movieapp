package e170998g.nyp.movierater

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class UserRatingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userrating_layout)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.userrating_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.miSubmit) {
            Toast.makeText(this, "Submit Test", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()

        return super.onSupportNavigateUp()
    }

    override fun onKeyDown(KeyCode: Int, event: KeyEvent): Boolean {
        //val intent = Intent(this@OverviewActivity, MainActivity::class.java)

        if (KeyCode == KeyEvent.KEYCODE_BACK) {


            finish()
            ///startActivity(intent)

            return true
        }
        return super.onKeyDown(KeyCode, event)
    }
}
