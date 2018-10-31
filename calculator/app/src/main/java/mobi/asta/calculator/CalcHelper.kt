package mobi.asta.calculator

class CalcHelper {
    enum class OperatorsType {
        none, addition, subtraction, multiplication, division
    }

    private var _firsValue : Double = 0.toDouble()

    private var currentType = OperatorsType.none


    fun getCurrentType() : OperatorsType {
        return currentType
    }

    fun clear() {
        _firsValue = 0.0
        currentType = OperatorsType.none
    }

    fun addition(value : String) {
        _firsValue = java.lang.Double.valueOf(value)!!
        currentType = OperatorsType.addition
    }

    fun subtraction(value : String) {
        _firsValue = java.lang.Double.valueOf(value)!!
        currentType = OperatorsType.subtraction
    }

    fun multiplication(value : String) {
        _firsValue = java.lang.Double.valueOf(value)!!
        currentType = OperatorsType.multiplication
    }

    fun division(value : String) {
        _firsValue = java.lang.Double.valueOf(value)!!
        currentType = OperatorsType.division
    }

    fun summary(value : String) : String {
        val secondValue = java.lang.Double.valueOf(value)!!
        var summary = _firsValue
        try {
            when (currentType) {
                CalcHelper.OperatorsType.addition -> summary += secondValue
                CalcHelper.OperatorsType.subtraction -> summary -= secondValue
                CalcHelper.OperatorsType.multiplication -> summary *= secondValue
                CalcHelper.OperatorsType.division -> {
                    if (secondValue == 0.0)
                        return "Жаль, но делить нельзя!"
                    summary /= secondValue
                }
                else -> return "Давайте уже считать!"
            }
        } finally {
            currentType = OperatorsType.none
        }


        return summary.toString()
    }

}