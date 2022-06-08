package br.com.projetoinvest.activity.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.projetoinvest.R
import br.com.projetoinvest.databinding.FragmentFiltroFundoInvestBinding


class FiltroFundoInvestFragment : Fragment() {

    private lateinit var binding: FragmentFiltroFundoInvestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFiltroFundoInvestBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAplicar.setOnClickListener {
            var isValido = true
            var aplicmin = binding.tieAplicMin.text.toString()
            var risco = binding.tieRisco.text.toString() 

            if (aplicmin == null || aplicmin.trim().length == 0) {
                isValido = false
                binding.tilAplicMin.setError(getString(R.string.msg_campo_obrigatorio))
            } else {
                binding.tilAplicMin.setError(null)


            }


            if (risco == null || risco.trim().length == 0) {
                isValido = false
                binding.tilRisco.setError(getString(R.string.msg_campo_obrigatorio))
            } else {
                binding.tilRisco.setError(null)


            }
            
            
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