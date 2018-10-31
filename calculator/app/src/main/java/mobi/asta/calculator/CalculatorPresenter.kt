package mobi.asta.calculator

interface CalculatorPresenter {
    fun onClearClick()
    fun onPersentClick()
    fun onBtn9Click()
    fun onBtnAddClick()
    fun onBtnEqualClick()
    fun onBtn7Click()
}

enum class CalculatorOperation(val s : String) {
    NONE(""), ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/")
}

class CalculatorPresenterImp(val view : CalculatorView) : CalculatorPresenter {
    override fun onBtn7Click() {
        updateValues(7)
    }

    override fun onBtnEqualClick() {
        view.fillTextView1("$lastValueClick${lastOperation.s}$currentValueClick")
        when (lastOperation) {
            CalculatorOperation.ADDITION -> view.fillTextView2("${lastValueClick + currentValueClick}")
            CalculatorOperation.SUBTRACTION -> view.fillTextView2("${lastValueClick - currentValueClick}")
            CalculatorOperation.MULTIPLICATION -> view.fillTextView2("${lastValueClick * currentValueClick}")
            CalculatorOperation.DIVISION -> view.fillTextView2("${lastValueClick / currentValueClick}")
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
        view.fillTextView1("0")
        view.fillTextView2("0")
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

    private fun updateValues(value : Int) {
        view.fillTextView2("$value")
        lastValueClick = currentValueClick
        currentValueClick = value

        lastOperation.takeIf { it != CalculatorOperation.NONE }.let {
            view.fillTextView1("$lastValueClick${lastOperation.s}")
        }
    }

}