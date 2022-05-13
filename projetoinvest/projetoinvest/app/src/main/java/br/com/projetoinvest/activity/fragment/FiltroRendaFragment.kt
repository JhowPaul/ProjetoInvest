package br.com.projetoinvest.activity.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.projetoinvest.R
import br.com.projetoinvest.databinding.FragmentFiltroRendaBinding

class FiltroRendaFragment : Fragment() {

    private lateinit var binding: FragmentFiltroRendaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFiltroRendaBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAplicar.setOnClickListener {

            var isValido = true
            val valor = binding.tieValor.text.toString()


            if (valor == null || valor.trim().length == 0) {
                isValido = false
                binding.tilValor.setError(getString(R.string.msg_campo_obrigatorio))
            } else {
                binding.tilValor.setError(null)


            }
            if (isValido != false) {
                Toast.makeText(activity, "OK", Toast.LENGTH_LONG).show()


            }
        }

     }
    }

