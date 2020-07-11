package kupluk.smk.coding.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_qtl.*
import kupluk.smk.coding.R
import kupluk.smk.coding.activity.AddNewQtlActivity
import kupluk.smk.coding.adapter.QtlAdapter
import kupluk.smk.coding.data.Qtl
import kupluk.smk.coding.model.QtlModel
import java.security.AccessController.getContext

class QtlActivity : AppCompatActivity(){
    lateinit var ref : DatabaseReference
    lateinit var auth: FirebaseAuth
    lateinit var dataQtl: ArrayList<QtlModel>
    lateinit var listQtl : ArrayList<Qtl>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qtl)
        fab_add_qtl.setOnClickListener {
            startActivity(Intent(this, AddNewQtlActivity::class.java))
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }


}
