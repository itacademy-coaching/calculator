package mobi.asta.calculator

import android.databinding.ObservableField

interface CalculatorPresenter {
    fun onClearClick()
    fun onPersentClick()
    fun onBtn9Click()
    fun onBtnAddClick()
    fun onBtnEqualClick()
    fun onBtn7Click()
    fun onPlusMinusClick()
    fun onDivisionClick()
    fun onBtn8Click()
    fun onMultiplicationClick()
    fun onBtn4Click()
    fun onBtn5Click()
    fun onBtn6Click()
    fun onSubtractionClick()
    fun onBtn1Click()
    fun onBtn2Click()
    fun onBtn3Click()
    fun onBtn0Click()
    fun onBtnDotClick()

    fun getBinding() : CalculatorResult
}

enum class CalculatorOperation(val s : String) {
    NONE(""), ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/")
}

class CalculatorResult {
    val text1 = ObservableField<String>()
    val text2 = ObservableField<String>()
}

class CalculatorPresenterImp() : CalculatorPresenter {

    val result = CalculatorResult()

    override fun getBinding() : CalculatorResult {
        return result
    }

    override fun onBtn7Click() {
        updateValues(7)
    }

    override fun onBtnEqualClick() {
        result.text1.set("$lastValueClick${lastOperation.s}$currentValueClick")
        when (lastOperation) {
            CalculatorOperation.ADDITION -> result.text2.set("${lastValueClick + currentValueClick}")
            CalculatorOperation.SUBTRACTION -> result.text2.set("${lastValueClick - currentValueClick}")
            CalculatorOperation.MULTIPLICATION -> result.text2.set("${lastValueClick * currentValueClick}")
            CalculatorOperation.DIVISION -> result.text2.set("${lastValueClick / currentValueClick}")
        }

        clearOperation()
    }

    override fun onBtnAddClick() {
        lastOperation = CalculatorOperation.ADDITION
    }

    private var lastValueClick : Int = 0
    private var currentValueClick : Int = 0
    private var lastResult : Double = 0.0
    private var lastOperation : CalculatorOperation = CalculatorOperation.NONE

    override fun onClearClick() {
        result.text1.set("0")
        result.text2.set("0")
        clearOperation()
    }

    private fun clearOperation() {
        lastResult = 0.0
        lastValueClick = 0
        currentValueClick = 0
        lastOperation = CalculatorOperation.NONE
    }

    override fun onPersentClick() {
    }

    override fun onBtn9Click() {
        updateValues(9)
    }

    override fun onPlusMinusClick() {
        lastOperation = CalculatorOperation.MULTIPLICATION
        updateValues(-1)
        onBtnEqualClick()
    }

    override fun onDivisionClick() {
        lastOperation = CalculatorOperation.DIVISION
    }

    override fun onBtn8Click() {
        updateValues(8)
    }

    override fun onMultiplicationClick() {
        lastOperation = CalculatorOperation.MULTIPLICATION
    }

    override fun onBtn4Click() {
        updateValues(4)
    }

    override fun onBtn5Click() {
        updateValues(5)
    }

    override fun onBtn6Click() {
        updateValues(6)
    }

    override fun onSubtractionClick() {
        lastOperation = CalculatorOperation.SUBTRACTION
    }

    override fun onBtn1Click() {
        updateValues(1)
    }

    override fun onBtn2Click() {
        updateValues(2)
    }

    override fun onBtn3Click() {
        updateValues(3)
    }

    override fun onBtn0Click() {
        updateValues(0)
    }

    override fun onBtnDotClick() {

    }

    private fun updateValues(value : Int) {
        when (lastOperation) {
            CalculatorOperation.NONE -> {
                val v = "$currentValueClick$value"
                currentValueClick = v.toInt()
            }
            else -> {
                lastValueClick = currentValueClick
                currentValueClick = value

            }
        }

        result.text2.set("$currentValueClick")

        lastOperation.takeIf { it != CalculatorOperation.NONE }.let {
            result.text1.set("$lastValueClick${lastOperation.s}")
        }
    }

}