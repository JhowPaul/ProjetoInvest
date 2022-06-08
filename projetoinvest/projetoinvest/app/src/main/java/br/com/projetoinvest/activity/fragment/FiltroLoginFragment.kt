package br.com.projetoinvest.activity.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.projetoinvest.R
import br.com.projetoinvest.activity.activity.LoginActivity
import br.com.projetoinvest.activity.activity.MainActivity
import br.com.projetoinvest.activity.modelo.Usuario
import br.com.projetoinvest.activity.repository.UsuarioFS
import br.com.projetoinvest.databinding.FragmentFiltroLoginBinding


class FiltroLoginFragment : Fragment() {

    private lateinit var binding: FragmentFiltroLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFiltroLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEntrar.setOnClickListener {
            var isValido = true
            var usuario= binding.tieUsuario.text.toString()
            var senha=binding.tieSenha.text.toString()
            
            if (usuario == null || usuario.trim().length == 0) {
                isValido = false
                binding.tilUsuario.setError(getString(R.string.msg_campo_obrigatorio))

            } else {
                binding.tilUsuario.setError(null)

                if (senha == null || senha.trim().length == 0) {
                    isValido = false
                    binding.tilSenha.setError(getString(R.string.msg_campo_obrigatorio))
                } else {
                    binding.tilSenha.setError(null)
                }

                if (isValido) {
                    val usuario=Usuario(
                        usuario,
                        senha
                    )
                    val executarSucesso={
                        binding.tilUsuario.setError(null)
                        binding.tilSenha.setError(null)
                        binding.tieUsuario.setText("")
                        binding.tieSenha.setText("")
                        Toast.makeText(activity, "Pessoa inserida com sucesso", Toast.LENGTH_LONG).show()
                    }
                    val executarErro = {msg:String ->
                        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
                    }
                    UsuarioFS.salvarUsuario(usuario, executarSucesso, executarErro)
                }
            }
        }
    }
}
