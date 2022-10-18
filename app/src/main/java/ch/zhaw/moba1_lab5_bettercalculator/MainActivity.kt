package ch.zhaw.moba1_lab5_bettercalculator

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import ch.zhaw.moba1_lab5_bettercalculator.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import ch.zhaw.moba1_lab5_bettercalculator.R.id.*


class MainActivity : AppCompatActivity(), View.OnClickListener{
    private var firstNo: Number? = null
    private var secondNo: Number? = null
    private var operation: String = ""
    //private var result: String = ""
    private lateinit var resultField: TextView

    //private lateinit var appBarConfiguration: AppBarConfiguration
    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_full_calculator)
        resultField = findViewById(result)

        arrayOf<Button>(
            // operations
            findViewById(divide),
            findViewById(multiply),
            findViewById(minus),
            findViewById(plus),
            findViewById(equals),
            findViewById(clear),

            // numbers
            findViewById(number_0),
            findViewById(number_01),
            findViewById(number_02),
            findViewById(number_03),
            findViewById(number_04),
            findViewById(number_05),
            findViewById(number_06),
            findViewById(number_07),
            findViewById(number_08),
            findViewById(number_09),
            ).forEach {it.setOnClickListener(this)}
    }

    override fun onClick(view: View?) {
        // TODO
        if (view != null) {
            when (view!!.id) {
                // operations
                divide -> setOperation("/")
                multiply -> setOperation("*")
                minus -> setOperation("-")
                plus -> setOperation("+")
                equals -> calculate()
                clear -> reset()

                // TODO numbers
            }
        }
    }

    private fun reset() {
        //firstNo = null
        //secondNo = null
        //result = ""
        operation = ""
    }

    private fun setOperation(op: String) {
        if (firstNo == null) {
            resultField.text = "enter number first"
        }
        operation = op
    }

    private fun setOperand() {
        if (firstNo == null && secondNo == null) {
        }
    }

    private fun calculate() {
            val result = when (operation) {
                "+" -> (firstNo!!.toDouble() + secondNo!!.toDouble())
                "-" -> (firstNo!!.toDouble() - secondNo!!.toDouble())
                "*" -> (firstNo!!.toDouble() * secondNo!!.toDouble())
                "/" -> (firstNo!!.toDouble() / secondNo!!.toDouble())
                else -> 0.0
            }
            putResult(result)
    }

    private fun putResult(calc: Double) {
        //resultField.text = calc.toString()
    }

}