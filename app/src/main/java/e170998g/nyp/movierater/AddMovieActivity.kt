package e170998g.nyp.movierater

import android.content.ClipDescription
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.addmovie_layout.*
import org.intellij.lang.annotations.Language

class AddMovieActivity : AppCompatActivity() {

    var under13: String = "Yes"
    var mLanguage = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addmovie_layout)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        LLNot.visibility = View.INVISIBLE

        rbtngbLangauge.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkId ->
                val radio :RadioButton = findViewById(checkId)
                mLanguage = radio.text.toString()
            })
    }

    fun onChkbxNotClick(v: View) {

        val checked: Boolean = chkbxNot.isChecked()

        when (checked) {
            true -> {
                under13 = "No"
                LLNot.visibility = View.VISIBLE
            }
            else -> {
                under13 = "Yes"
                chkbxViolence.isChecked = false
                chkbxLangauge.isChecked = false
                LLNot.visibility = View.INVISIBLE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.addmovie_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var check: Boolean = true
        var mName = etName.text.toString()
        var mDescription = etDescription.text.toString()

        var mRelaseDate = etReleaseDate.text.toString()

        if (chkbxViolence.isChecked && chkbxLangauge.isChecked){
            under13 = "No (Violence & Langauge)"
        }
        else if (chkbxLangauge.isChecked) {
            under13 = "No (Langauge)"
        }
        else if (chkbxViolence.isChecked) {
            under13 = "No (Violence)"
        }

        if (item?.itemId == R.id.miAdd) {

            if (mName == "") {
                etName.setError("Movie Name cannot be Blank")
                check = false
            }

            if (mDescription == "") {
                etDescription.setError("Movie Description cannot be Blank")
                check = false
            }

            if (mRelaseDate == "") {
                etReleaseDate.setError("Release Date cannot be Blank")
                check = false
            }

            if (mLanguage.length == 0) {
                check= false
            }


            if (check) {
                Toast.makeText(this, "Name: ${mName}\n" +
                        "Description: ${mDescription}\n" +
                        "Language: ${mLanguage}\n" +
                        "Release Date: ${mRelaseDate}\n" +
                        "Suitable for children below 13: ${under13}"
                    , Toast.LENGTH_SHORT).show()

                submitToNext(mName, mDescription, mLanguage, mRelaseDate, under13)
            }

            else {
                Toast.makeText(this, "TextField not fully completed", Toast.LENGTH_SHORT).show()
            }



        }
        else if (item?.itemId == R.id.miClear){
            etName.text.clear()
            etDescription.text.clear()
            etReleaseDate.text.clear()

        }

        return super.onOptionsItemSelected(item)
    }

    override fun onKeyDown(KeyCode: Int, event: KeyEvent): Boolean {

        if (KeyCode == KeyEvent.KEYCODE_BACK) {


            finish()

            return true
        }
        return super.onKeyDown(KeyCode, event)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()

        return super.onSupportNavigateUp()
    }


    fun submitToNext(mvName: String, mvDescription: String, mvLanguage: String, mvRelease: String, mvUnder13: String) {
        var intent = Intent(this@AddMovieActivity, OverviewActivity::class.java)

        intent.putExtra("mName",mvName)
        intent.putExtra("mDescription",mvDescription)
        intent.putExtra("mLanguage",mvLanguage)
        intent.putExtra("mRelease", mvRelease )
        intent.putExtra("mUnder13", mvUnder13)

        finish()
        startActivity(intent)

    }
}