package kupluk.smk.coding.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_qtl.*
import kupluk.smk.coding.R
import kupluk.smk.coding.adapter.QtlAdapter
import kupluk.smk.coding.model.QtlModel


class QtlActivity : AppCompatActivity() {
    lateinit var ref: DatabaseReference
    lateinit var auth: FirebaseAuth
    var dataku: MutableList<QtlModel> = ArrayList()
    private var adapter: QtlAdapter? = null
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qtl)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        ref = FirebaseDatabase.getInstance().getReference()
        getData()
        fab_add_qtl.setOnClickListener {
            startActivity(Intent(this, AddNewQtlActivity::class.java))
        }

    }

    private fun getData() {
        ref = FirebaseDatabase.getInstance().getReference()
        auth = FirebaseAuth.getInstance()
        val getUserID: String = auth?.getCurrentUser()?.getUid().toString()
        ref.child(getUserID).child("Kupluk").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(datasnapshot: DataSnapshot) {
                dataku = ArrayList()
                for (snapshot in datasnapshot.children) {
                    val dataModel = snapshot.getValue(QtlModel::class.java)
                    dataModel?.key = (snapshot.key!!)
                    dataku.add(dataModel!!)
                }
                rv_qtl.layoutManager = LinearLayoutManager(applicationContext)
                rv_qtl.adapter = QtlAdapter(applicationContext, dataku)
            }
        })
    }

}