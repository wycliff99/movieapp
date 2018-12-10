package e170998g.nyp.movierater

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.overview_layout.*

class OverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.overview_layout)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        registerForContextMenu(tvReview)

        var mName: String = intent.getStringExtra("mName")
        var mDescription: String = intent.getStringExtra("mDescription")
        var mLanguage: String = intent.getStringExtra("mLanguage")
        var mRelease:String = intent.getStringExtra("mRelease")
        var mvUnder13:String = intent.getStringExtra("mUnder13")

        tvTitle.text = mName
        tvOverviewDescription.text = mDescription
        tvLangauge.text = mLanguage
        tvOverviewReleaseDate.text = mRelease
        tvUnder13.text = mvUnder13
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.tvReview)
        {
            menu?.add(1,200,1,"Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(this@OverviewActivity, UserRatingActivity::class.java)

        intent.putExtra("mName",tvTitle.text)
        intent.putExtra("mDescription",tvOverviewDescription.text)
        intent.putExtra("mLanguage",tvLangauge.text)
        intent.putExtra("mRelease", tvOverviewReleaseDate.text)
        intent.putExtra("mUnder13", tvUnder13.text)

        if (item?.itemId == 200) {



            startActivity(intent)
        }

        return super.onContextItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()

        return super.onSupportNavigateUp()
    }

    override fun onKeyDown(KeyCode: Int, event: KeyEvent): Boolean {

        if (KeyCode == KeyEvent.KEYCODE_BACK) {

            finish()

            return true
        }
        return super.onKeyDown(KeyCode, event)
    }
}