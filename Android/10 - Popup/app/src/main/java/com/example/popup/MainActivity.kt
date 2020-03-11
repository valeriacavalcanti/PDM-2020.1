package com.example.popup

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.sql.Time
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var btMensagem: Button
    private lateinit var btInput: Button
    private lateinit var btData: Button
    private lateinit var btHora: Button
    private lateinit var btFaixa: Button
    private lateinit var btEscolha: Button
    private lateinit var btUnico: Button
    private lateinit var btVarios: Button
    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btMensagem = findViewById(R.id.btMensagem)
        this.btInput = findViewById(R.id.btInput)
        this.btData = findViewById(R.id.btData)
        this.btHora = findViewById(R.id.btHora)
        this.btFaixa = findViewById(R.id.btFaixa)
        this.btEscolha = findViewById(R.id.btEscolha)
        this.btUnico = findViewById(R.id.btUnico)
        this.btVarios = findViewById(R.id.btVarios)

        this.btMensagem.setOnClickListener({ mensagem() })
        this.btInput.setOnClickListener({ input() })
        this.btData.setOnClickListener({ data() })
        this.btHora.setOnClickListener({ hora() })
        this.btFaixa.setOnClickListener({ faixa() })
        this.btEscolha.setOnClickListener({ escolha() })
        this.btUnico.setOnClickListener({ unico() })
        this.btVarios.setOnClickListener({ varios() })
    }

    fun mensagem(){
        val janela = AlertDialog.Builder(this)

        janela.setTitle("Mensagem")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Que bom !")

        janela.setPositiveButton("Ok"){ dialog, which ->
            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar"){ dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.setNeutralButton("Genérico"){ dialog, which ->
            Toast.makeText(this, "Genérico", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()
    }

    fun input(){
        val janela = AlertDialog.Builder(this)
        this.view = EditText(this)

        janela.setTitle("Input")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Digite uma frase")
        janela.setView(this.view)

        janela.setPositiveButton("Ok"){ dialog, which ->
            val msg = (this.view as EditText).text.toString()
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar"){ dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()
    }

    fun data(){
        val janela = AlertDialog.Builder(this)
        this.view = DatePicker(this)

        janela.setTitle("DatePicker")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Escolha uma data")
        janela.setView(this.view)

        janela.setPositiveButton("Ok"){ dialog, which ->
            val dp = this.view as DatePicker
            val msg = "${dp.dayOfMonth}/${dp.month + 1}/${dp.year}"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar"){ dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()
    }

    fun hora(){
        val janela = AlertDialog.Builder(this)
        this.view = TimePicker(this)

        (this.view as TimePicker).setIs24HourView(true)

        janela.setTitle("TimePicker")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Escolha uma hora")
        janela.setView(this.view)

        janela.setPositiveButton("Ok"){ dialog, which ->
            val tp = this.view as TimePicker
            var msg = ""

            if (Build.VERSION.SDK_INT < 23){
                msg = "${tp.currentHour}:${tp.currentMinute}"
            }else{
                msg = "${tp.hour}:${tp.minute}"
            }

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar"){ dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()
    }

    fun faixa(){
        val janela = AlertDialog.Builder(this)
        this.view = SeekBar(this)

        val sb = this.view as SeekBar

        sb.max = 100

        janela.setTitle("Input")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Defina um valor")
        janela.setView(this.view)

        janela.setPositiveButton("Ok"){ dialog, which ->
            val msg = (this.view as SeekBar).progress.toString()
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar"){ dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()
    }

    fun escolha(){
        val janela = AlertDialog.Builder(this)
        this.view = Switch(this)

        janela.setTitle("Input")
        janela.setIcon(R.mipmap.ic_launcher)
        janela.setMessage("Escolha um estado")
        janela.setView(this.view)

        janela.setPositiveButton("Ok"){ dialog, which ->
            val msg = (this.view as Switch).isChecked.toString()
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        janela.setNegativeButton("Cancelar"){ dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }

        janela.create().show()
    }

    fun unico(){

    }

    fun varios(){

    }
}
