package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.calculadora.databinding.ActivityMainBinding
import java.lang.RuntimeException


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonCero.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"0")
        }
        binding.botonUno.setOnClickListener {
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"1")
        }
        binding.botonDos.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"2")
        }
        binding.botonTres.setOnClickListener {
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"3")
        }
        binding.botonCuatro.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"4")
        }
        binding.botonCinco.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"5")
        }
        binding.botonSeis.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"6")
        }
        binding.botonSiete.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"7")
        }
        binding.botonOcho.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"8")
        }
        binding.botonNueve.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"9")
        }
        binding.botonComa.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+".")
        }
        binding.botonSumar.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"+")
        }
        binding.botonRestar.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"-")
        }
        binding.botonDividir.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"/")
        }
        binding.botonParentesis1.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"(")
        }
        binding.botonParentesis2.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+")")
        }
        binding.botonMultiplicar.setOnClickListener{
            val str: String = binding.pantallaSolucion.text.toString()
            if(!str.get(index = str.length-1).equals("*")){
                binding.pantallaSolucion.text = (binding.pantallaSolucion.text.toString()+"*")
            }
        }
        binding.botonAC.setOnClickListener{
            binding.pantallaSolucion.text = ""
            binding.pantallaDatos.text = ""
        }

        binding.botonC.setOnClickListener{
            var str: String = binding.pantallaSolucion.text.toString()
            if(!str.equals("")){
                str= str.substring(0,str.length-1)
                binding.pantallaSolucion.text = str
            }
        }

        binding.botonIgual.setOnClickListener{
            val str: String = binding.pantallaSolucion.text.toString()
            val result: Double = evaluate(str)
            val r = result.toString()
            binding.pantallaSolucion.text = r
            binding.pantallaDatos.text = str
        }


    }
    fun evaluate(str: String): Double{
        return object : Any(){
            var pos = -1
            var ch = 0

            fun nextChar(){
                ch = if(++pos<str.length)str[pos].toInt()else -1
            }
            fun eat(charToEdt: Int): Boolean{
                while (ch==' '.toInt())nextChar()
                if(ch==charToEdt){
                    nextChar()
                    return true
                }
                return false
            }
            fun parse():Double{
                nextChar()
                val x = parseExpression()
                if (pos<str.length) throw RuntimeException("Unexpected : " +ch.toChar())
                return x
            }
            fun parseExpression(): Double{
                var x = parseTerm()
                while(true) {
                    if(eat('+'.toInt())) x += parseTerm()
                    else if (eat('-'.toInt())) x -=parseTerm()
                    else return x
                }
            }
            fun parseTerm(): Double{
                var x = parseFactor()
                while (true){
                    if (eat('*'.toInt()))x *= parseFactor()
                    else if(eat('/'.toInt()))x /= parseFactor()
                    else return x

                }
            }
            fun parseFactor(): Double {
                if (eat('+'.toInt())) return parseFactor()
                if (eat('-'.toInt())) return -parseFactor()

                var x: Double
                val startPos = pos
                if (eat('('.toInt())) {
                    x = parseExpression()
                    eat(')'.toInt())
                } else if (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) {

                    while (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) nextChar()

                    x = str.substring(startPos, pos).toDouble()

                } else if (ch >= 'a'.toInt() && ch <= 'z'.toInt()) {

                    while (ch>='a'.toInt() && ch<='z'.toInt())nextChar()
                    val func = str.substring(startPos, pos)
                    x = parseFactor()
                    if(func=="sqrt"){
                        x = Math.sqrt(x)
                    }else if(func == "sin"){
                        x = Math.sin(Math.toRadians(x))
                    }else if (func == "cos"){
                        x = Math.cos(Math.toRadians(x))
                    }else if (func == "tan"){
                        x = Math.tan(Math.toRadians(x))
                    }else if(func == "log"){
                        x = Math.log10(x)
                    }else if(func == "ln"){
                        x = Math.log(x)
                    }
                }else{
                    throw RuntimeException("Unexpected : "+ ch.toChar())
                }
                if (eat('^'.toInt())) x = Math.pow(x,parseFactor())
                return x
            }
        }.parse()
    }

}

