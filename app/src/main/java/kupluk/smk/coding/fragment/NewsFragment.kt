package kupluk.smk.coding.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_news.*
import kupluk.smk.coding.R
import kupluk.smk.coding.activity.AddNewsActivity
import kupluk.smk.coding.adapter.NewsAdapter
import kupluk.smk.coding.data.News

class NewsFragment : Fragment() {

    private lateinit var list: ArrayList<News>
    private lateinit var ref: DatabaseReference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ref = FirebaseDatabase.getInstance().getReference("uploads")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                list = java.util.ArrayList<News>()
                for (postSnapshot in snapshot.children) {
                    val upload = postSnapshot.getValue(News::class.java)
                    list.add(upload!!)
                }
                rv_news.apply {
                    layoutManager = LinearLayoutManager(view.context)
                    adapter = NewsAdapter(list, view.context)
                }
            }
        })


        fab_add_news.setOnClickListener {
            startActivity(Intent(view.context, AddNewsActivity::class.java))
        }


    }
}