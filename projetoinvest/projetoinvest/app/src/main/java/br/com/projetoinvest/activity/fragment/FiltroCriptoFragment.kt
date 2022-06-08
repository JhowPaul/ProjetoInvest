package br.com.projetoinvest.activity.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.projetoinvest.R
import br.com.projetoinvest.databinding.FragmentFiltroCriptoBinding


class FiltroCriptoFragment : Fragment() {

    private lateinit var binding: FragmentFiltroCriptoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFiltroCriptoBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAplicar.setOnClickListener {
            var isValido = true

            if (isValido != false) {
                Toast.makeText(activity, "OK", Toast.LENGTH_LONG).show()
            }
        /*if (isValido != false) {
        startActivity(Intent(this,LoginActivity::class.kotlin))
        }
         */

        }
    }
}