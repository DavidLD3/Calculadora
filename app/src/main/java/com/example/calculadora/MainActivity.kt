package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding
import java.lang.RuntimeException


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var pantalla = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pantalla =  savedInstanceState?.getString("pantalla") ?: ""
        binding.pantallaSolucion.text = pantalla

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
            val str: String = binding.pantallaSolucion.text.toString()
            if(!str.get(index = str.length-1).equals("-")){
                binding.pantallaSolucion.text = (binding.pantallaSolucion.text.toString()+"-")
            }
        }

        binding.botonDividir.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"/")
        }

        binding.botonMultiplicar.setOnClickListener{
            val str: String = binding.pantallaSolucion.text.toString()
            if(!str.get(index = str.length-1).equals("*")){
                binding.pantallaSolucion.text = (binding.pantallaSolucion.text.toString()+"*")
            }
        }
        binding.botonParentesis1.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"(")
        }
        binding.botonParentesis2.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+")")
        }
        binding.botonPi?.setOnClickListener{
            binding.pantallaSolucion.text =(binding.pantallaSolucion.text.toString()+"3.141592")
            binding.pantallaDatos.text=(binding.botonPi?.text.toString())

        }
        binding.botonRaiz?.setOnClickListener{
            if(binding.pantallaSolucion.text.toString().isEmpty()){
                Toast.makeText(this, "Introduzca un numero correcto", Toast.LENGTH_SHORT).show()
            }else{
                val str: String = binding.pantallaSolucion.text.toString()
                val r = Math.sqrt(str.toDouble())
                val result = r.toString()
                binding.pantallaSolucion.text = result
            }
        }
        binding.botonCuadrado?.setOnClickListener{
            if(binding.pantallaSolucion.text.toString().isEmpty()){
                Toast.makeText(this, "Introducza un numero correcto", Toast.LENGTH_SHORT).show()
            }else{
                val j: Double = binding.pantallaSolucion.text.toString().toDouble()
                val cuadrado = j*j
                binding.pantallaSolucion.text = cuadrado.toString()
                binding.pantallaDatos.text = cuadrado.toString()
            }
        }
        binding.botonFactorial?.setOnClickListener {
            if (binding.pantallaSolucion.text.toString().isNotEmpty()) {
                val valor: Int = binding.pantallaSolucion.text.toString().toInt()
                val fact: Int = factorial(valor)
                binding.pantallaSolucion.text = fact.toString()
                binding.pantallaDatos.text = fact.toString()
            } else {
                Toast.makeText(this, "Introduzca un numero correcto", Toast.LENGTH_SHORT).show()
            }
        }
        binding.botonLn?.setOnClickListener {
            val str: String = binding.pantallaSolucion.text.toString()
            try {
                val result = Math.log(str.toDouble())
                binding.pantallaSolucion.text = result.toString()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Número incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
        binding.botonLog?.setOnClickListener {
            val str: String = binding.pantallaSolucion.text.toString()
            try {
                val result = Math.log10(str.toDouble())
                binding.pantallaSolucion.text = result.toString()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Nunmero incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
        binding.botonSin?.setOnClickListener {
            val str: String = binding.pantallaSolucion.text.toString()
            try {
                val result = Math.sin(str.toDouble())
                binding.pantallaSolucion.text = result.toString()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Numero incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
        binding.botonCos?.setOnClickListener {
            val str: String = binding.pantallaSolucion.text.toString()
            try {
                val result = Math.cos(str.toDouble())
                binding.pantallaSolucion.text = result.toString()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Numero incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
        binding.botonTan?.setOnClickListener {
            val str: String = binding.pantallaSolucion.text.toString()
            try {
                val result = Math.tan(str.toDouble())
                binding.pantallaSolucion.text = result.toString()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Numero incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
        binding.botonInv?.setOnClickListener {
            val str: String = binding.pantallaSolucion.text.toString()
            try {
                val result = 1.0 / str.toDouble()
                binding.pantallaSolucion.text = result.toString()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Formato de número incorrecto", Toast.LENGTH_SHORT).show()
            } catch (e: ArithmeticException) {
                Toast.makeText(this, "División por cero", Toast.LENGTH_SHORT).show()
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
            binding.pantallaDatos.text = if (str.isNotEmpty()) str else "No hay expresión para evaluar"
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("pantalla",binding.pantallaSolucion.text.toString())
    }
    fun evaluate(str: String): Double{
        return object : Any(){
            var pos = -1
            var ch = 0

            fun nextChar(){
                ch = if (++pos < str.length) str[pos].code else -1
            }
            fun eat(charToEdt: Int): Boolean{
                while (ch == ' '.code) nextChar()
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
                    if(eat('+'.code)) x += parseTerm()
                    else if (eat('-'.code)) x -=parseTerm()
                    else return x
                }
            }
            fun parseTerm(): Double{
                var x = parseFactor()
                while (true){
                    if (eat('*'.code))x *= parseFactor()
                    else if(eat('/'.code))x /= parseFactor()
                    else return x

                }
            }
            fun parseFactor(): Double {
                if (eat('+'.code)) return parseFactor()
                if (eat('-'.code)) return -parseFactor()

                var x: Double
                val startPos = pos
                if (eat('('.code)) {
                    x = parseExpression()
                    eat(')'.code)
                } else if (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) {

                    while (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) nextChar()

                    x = str.substring(startPos, pos).toDouble()

                } else if (ch >= 'a'.code && ch <= 'z'.code) {

                    while (ch >= 'a'.code && ch <= 'z'.code)nextChar()
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
                if (eat('^'.code)) x = Math.pow(x,parseFactor())
                return x
            }
        }.parse()
    }

    fun factorial (n:Int) :Int{
        return if (n==1 || n==0)1
        else n* factorial(n-1)
    }

}

