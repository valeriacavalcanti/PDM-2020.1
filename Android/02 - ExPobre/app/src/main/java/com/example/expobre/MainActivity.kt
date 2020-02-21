package com.example.expobre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvNumeros: TextView
    private lateinit var btNovo: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvNumeros = findViewById(R.id.tvNumeros)
        this.btNovo = findViewById(R.id.btNovo)

        // Forma 1
        // this.gerarNovoJogo(null)

        // Forma 2
        // this.btNovo.setOnClickListener( { gerarNovoJogo(it) })

        // Forma 3
        //this.btNovo.setOnClickListener({
        //    this.gerarNovoJogo(null)
        //})

        // Forma 4
        this.btNovo.setOnClickListener(OnClickBotao())
    }

    /*
    fun gerarNovoJogo(view: View?){
        this.tvNumeros.text = Megasena.getInstance().joinToString(" ")
    }
    */


    inner class OnClickBotao : View.OnClickListener{
        override fun onClick(v: View?) {
            this@MainActivity.tvNumeros.text = Megasena.getInstance().joinToString(" ")
        }

    }
}
