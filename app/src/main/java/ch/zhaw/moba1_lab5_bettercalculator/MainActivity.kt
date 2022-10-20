package ch.zhaw.moba1_lab5_bettercalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ch.zhaw.moba1_lab5_bettercalculator.R.id.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private var firstNo: Number? = null
    private var secondNo: Number? = null
    private var operation: String = ""
    private lateinit var resultField: TextView

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
                clear -> clear()

                // numbers
                number_0 -> setOperand(0)
                number_01 -> setOperand(1)
                number_02 -> setOperand(2)
                number_03 -> setOperand(3)
                number_04 -> setOperand(4)
                number_05 -> setOperand(5)
                number_06 -> setOperand(6)
                number_07 -> setOperand(7)
                number_08 -> setOperand(8)
                number_09 -> setOperand(9)
            }
        }
    }

    private fun clear() {
        firstNo = null
        secondNo = null
        operation = ""
        resultField.text = "0"
    }

    // TODO
    private fun reset() {
        firstNo = null
        secondNo = null
        operation = ""

    }

    private fun setOperation(op: String) {
        if (firstNo == null) {
            resultField.text = "enter number first"
        } else {
            operation = op
        }
    }

    private fun setOperand(operand: Int) {
        if (firstNo == null) {
            firstNo = operand
            resultField.text = operand.toString()
        } else if (operation == "") {
            resultField.text = "choose operation for current result: " + resultField.text.toString()
        } else {
            secondNo = operand
            resultField.text = operand.toString()
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
        resultField.text = calc.toString() // display result
        //var operationTemp: String = operation
        reset() // reset for new calculation
        firstNo = calc // set current result as first operand for next calculation
        //operation = operationTemp
    }

}