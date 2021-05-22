package com.uvg.intentbundle

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    var num1:Int = 0
    var numero1:String = ""
    var num2:Int = 0
    var numero2:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bundle= intent.extras

        if (bundle!=null){
            val texto = bundle.getString("valor")
            txtTexto.text = texto

            val valor2 = bundle.getString("valor2")
            Toast.makeText(this,valor2,Toast.LENGTH_SHORT).show()

            val valor3 = bundle.getString("valor3","no value")
            Toast.makeText(this, valor3, Toast.LENGTH_SHORT).show()


        }

        btnRegresar.setOnClickListener{
            val intent: Intent = Intent() //construtor vacio
            intent.putExtra("resultado","valor desde pantalla")
            setResult(RESULT_OK,intent)
            finish()
        }

        numero1 = ETnumero1.toString()
        numero2 = ETnumero2.toString()
    }

    fun conversionStringaNumero(palabra:String){

    }
}
