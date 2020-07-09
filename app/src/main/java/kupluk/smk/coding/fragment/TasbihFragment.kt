package kupluk.smk.coding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_tasbih.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TasbihFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super .onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasbih, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var awal = 0

        btnplus.setOnClickListener {

            var awal = awal++
            textView.setText(awal.toString())
        }
        btnReset.setOnClickListener {

            if ( awal == 0 ) {
                textView.setText(awal.toString())
            } else {
                awal = 0

            }
            textView.setText(awal.toString())
        }

    }
}