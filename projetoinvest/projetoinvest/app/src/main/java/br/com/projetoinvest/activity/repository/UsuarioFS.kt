package br.com.projetoinvest.activity.repository

import br.com.projetoinvest.activity.activity.LoginActivity
import br.com.projetoinvest.activity.modelo.Renda
import br.com.projetoinvest.activity.modelo.Usuario
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UsuarioFS {


    companion object {

        fun salvarUsuario(usuario: Usuario, executarSucesso:(() -> Unit),executarFalha:((msg: String) -> Unit)){

            val db= Firebase.firestore
            val mapaUsuario = hashMapOf(

                "usuario" to usuario.usuario,
                "senha" to usuario.senha,


                )
            db.collection("usuario")
                .add(mapaUsuario)
                .addOnSuccessListener { resultSucess ->
                    if (resultSucess.id != null){
                        executarSucesso.invoke()
                    }else{
                        executarFalha.invoke("Falha: id não retornado")
                    }


                }
                .addOnFailureListener{ exception ->
                    exception.stackTrace
                }

            fun getAllUsuario(executarSucesso: ((List<Usuario>) -> Unit), executarFalha: ((msg: String) -> Unit)) {
                lateinit var listaUsuario: ArrayList<Usuario>
                val db = Firebase.firestore
                db.collection("usuario").get()
                    .addOnSuccessListener { querySnapshot ->
                        if (querySnapshot!= null && querySnapshot.documents!= null &&
                            querySnapshot.documents.size> 0){

                            listaUsuario= ArrayList<Usuario>()
                            querySnapshot.documents.forEach{ documentSnapshot->
                                val Usuario =Usuario(
                                    documentSnapshot?.getString("usuario")!!,
                                    documentSnapshot?.getString("senha")!!
                                )
                                listaUsuario.add(usuario)
                            }
                            executarSucesso.invoke(listaUsuario)
                        }else{
                            executarFalha.invoke("nenhum resultado foi encontrado ")
                        }
                    }
                    .addOnFailureListener { exception ->
                        executarFalha.invoke("Erro inesperado:" + exception.message)
                        exception.stackTrace
                    }

            }

            fun getUsuarioByNome(nome:String,executarSucesso: (( List<Usuario>) -> Unit), executarFalha: ((msg: String) -> Unit)) {
                lateinit var listaUsuario: ArrayList<Usuario>
                val db = Firebase.firestore
                db.collection("usuario")
                    .whereEqualTo("usuario",usuario)
                    .get()
                    .addOnSuccessListener { querySnapshot ->
                        if (querySnapshot!= null && querySnapshot.documents!= null &&
                            querySnapshot.documents.size> 0){

                            listaUsuario= ArrayList<Usuario>()
                            querySnapshot.documents.forEach{ documentSnapshot->
                                val usuario =Usuario(
                                    documentSnapshot?.getString("usuario")!!,
                                    documentSnapshot?.getString("senha")!!
                                )
                                listaUsuario.add(usuario)
                            }
                            executarSucesso.invoke(listaUsuario)
                        }else{
                            executarFalha.invoke("nenhum resultado foi encontrado ")
                        }
                    }
                    .addOnFailureListener { exception ->
                        executarFalha.invoke("Erro inesperado:" + exception.message)
                        exception.stackTrace
                    }

            }
        }
    }
}