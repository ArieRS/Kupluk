package kupluk.smk.coding.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_add_news.*
import kupluk.smk.coding.R
import kupluk.smk.coding.data.News

class NewsActivity : AppCompatActivity() {
    companion object {
        const val PICK_IMAGE = 1
    }

    private var mImageUri: Uri? = null
    private lateinit var mStorageRef: StorageReference
    private lateinit var mDatabaseRef: DatabaseReference
    private var key: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_news)
        mStorageRef = FirebaseStorage.getInstance().getReference("uploads")
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads")

        val update = intent.getIntExtra("EXTRA_UPDATE", 0)
        if (update == 1) {
            btn_submit.visibility = View.GONE
            getData()
        }
        if (update == 0) {
            btn_update.visibility = View.GONE
        }

        btn_choose_file.setOnClickListener { openFileChooser() }
        btn_submit.setOnClickListener {
            uploadFile()
        }
        btn_update.setOnClickListener {
            updateFile()
        }
    }

    private fun getData() {
        val title = intent.getStringExtra("EXTRA_TITLE")
        val description = intent.getStringExtra("EXTRA_DESCRIPTION")
        val image = intent.getStringExtra("EXTRA_IMAGE")
        key = intent.getStringExtra("EXTRA_KEY").toString()
        edt_news_title.setText(title)
        edt_news_description.setText(description)
        Glide.with(this)
            .load(image)
            .into(view_image)
    }

    private fun openFileChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, PICK_IMAGE)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            mImageUri = data.data
            Glide.with(this).load(mImageUri).into(view_image)
        }
    }

    private fun getFileExtension(uri: Uri): String? {
        val cR = contentResolver
        val mime = MimeTypeMap.getSingleton()
        return mime.getExtensionFromMimeType(cR.getType(uri))
    }

    private fun uploadFile() {
        if (mImageUri != null) {
            val fileReference = mStorageRef.child(System.currentTimeMillis().toString() + "." + getFileExtension(mImageUri!!))
            val uploadTask = mStorageRef.putFile(mImageUri!!)
                uploadTask.continueWithTask{
                    if (!it.isSuccessful) {
                        Log.d("upload", "gagal")
                    }
                    mStorageRef.downloadUrl
                }.addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.d("urldownload", it.result.toString())
                        val uploadID = mDatabaseRef.push().key
                        val upload = News(edt_news_title.text.toString(), edt_news_description.text.toString(), it.result.toString(), uploadID.toString())
                        mDatabaseRef.child(uploadID.toString()).setValue(upload)
                        Toast.makeText(this, "Berhasil Upload", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
        } else {
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show()
        }
    }
    private fun updateFile() {
        if (mImageUri != null) {
            mStorageRef.child(System.currentTimeMillis().toString() + "." + getFileExtension(mImageUri!!))
            val uploadTask = mStorageRef.putFile(mImageUri!!)
                uploadTask.continueWithTask{
                    if (!it.isSuccessful) {
                        Log.d("upload", "gagal")
                    }
                    mStorageRef.downloadUrl
                }.addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.d("urldownload", it.result.toString())
                        val upload = News(edt_news_title.text.toString(), edt_news_description.text.toString(), it.result.toString(), key)
                        mDatabaseRef.child(key).setValue(upload)
                        Toast.makeText(this, "Berhasil Upload", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
        } else {
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show()
        }
    }
}