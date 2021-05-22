package com.uvg.intentbundle

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class MainActivity2 : AppCompatActivity() {

    var num1:Float? = 0f
    var numero1:String = ""
    var num2:Float? = 0f
    var numero2:String = ""
    var operacion:Int = 0
    var resultado:Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bundle= intent.extras

        if (bundle!=null){
            operacion = bundle.getInt("tipoOperacion")
        }


        btnRegresar.setOnClickListener{
            numero1 = ETnumero1.text.toString() //obtener el numero del usuario
            numero2 = ETnumero2.text.toString() //obtener el numero del usuario

            /*
            ETnumero1.setOnEditorActionListener{
                EditorInfo.IME_ACTION_SEND -> {
                numero1 = ETnumero1.text.toString()
            }
            }

             */

            conversionStringaNumero() //se convierten a numeros
            operacion(operacion,num1,num2)

            if (resultado !=null) {

                val intent: Intent = Intent() //construtor vacio
                intent.putExtra("resultado", resultado.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
            else {
                val intent: Intent = Intent()
                setResult(RESULT_CANCELED,intent)
                finish()
            }
        }
    }

    fun conversionStringaNumero(){
        try {
            num1 = numero1.toFloat()
            System.out.println(num1!!)
            num2 = numero2.toFloat()
            System.out.println(num2!!)
        }
        catch (ime:InputMismatchException){return}
    }

    fun operacion(tipo:Int, nume1:Float?, nume2:Float?){
        if (nume1 != null){
            if (nume2 != null) {
                if (tipo == 1) {
                    //se realiza una suma
                    resultado = nume1 + nume2
                } else if (tipo == 2) {
                    //se realiza una resta
                    resultado = nume1 - nume2
                } else if (tipo == 3) {
                    resultado = nume1*nume2
                    //se realiza una multiplicacion
                } else if (tipo == 4) {
                    resultado = nume1/nume2
                    //se realiza una division
                }
            }
        }
        else {
            resultado = 0f
        }

    }
}
