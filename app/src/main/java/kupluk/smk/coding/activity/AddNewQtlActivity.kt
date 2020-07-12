package kupluk.smk.coding.activity

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_new_qtl.*
import kupluk.smk.coding.R
import kupluk.smk.coding.model.QtlModel
import java.util.*

class AddNewQtlActivity : AppCompatActivity() {
    private var Surat: EditText? = null
    private var Ayat: EditText? = null
    private var Halaman: EditText? = null
    private var Waktu: TextView? = null
    lateinit var ref : DatabaseReference
    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_qtl)

        Surat = findViewById<EditText>(R.id.edt_surat)
        Ayat = findViewById<EditText>(R.id.edt_ayat)
        Halaman = findViewById<EditText>(R.id.edt_halaman)
        Waktu = findViewById<EditText>(R.id.dateTv)
        ref = FirebaseDatabase.getInstance().getReference()
        auth = FirebaseAuth.getInstance()
        btn_submit.setOnClickListener{
            prosesSave()
        }


        val mPickTimeBtn = findViewById<Button>(R.id.pickDateBtn)
        val textView     = findViewById<TextView>(R.id.dateTv)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        mPickTimeBtn.setOnClickListener {

            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                textView.setText("" + dayOfMonth + ", " + month + ", " + year)
            }, year, month, day)
            dpd.show()

        }

    }

    private fun prosesSave() {
        val getSurat: String = Surat?.getText().toString()
        val getAyat: String = Ayat?.getText().toString()
        val getHalaman: String = Halaman?.getText().toString()
        val getWaktu: String = Waktu?.getText().toString()
        val getUserID: String = auth?.getCurrentUser()?.getUid().toString()
        if (getSurat.isEmpty() && getAyat.isEmpty() && getHalaman.isEmpty() &&
            getWaktu.isEmpty()) {

            Toast.makeText(this@AddNewQtlActivity,"Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show()
        } else {
            val qtl = QtlModel(getSurat, getAyat, getHalaman, getWaktu,"")
            ref.child(getUserID).child("Kupluk").push().setValue(qtl).addOnCompleteListener {
                Toast.makeText(this, "Data Berhasil Disimpan",
                    Toast.LENGTH_SHORT).show()
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}