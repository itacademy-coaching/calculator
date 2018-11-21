package mobi.asta.calculator

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import mobi.asta.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var presenter : CalculatorPresenter = CalculatorPresenterImp()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main)

        binding.viewModel = presenter.getBinding()

        findViewById<Button>(R.id.button).setOnClickListener {
            presenter.onClearClick()
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            presenter.onPlusMinusClick()
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            presenter.onPersentClick()
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            presenter.onDivisionClick()
        }

        findViewById<Button>(R.id.button5).setOnClickListener {
            presenter.onBtn7Click()
        }
        findViewById<Button>(R.id.button6).setOnClickListener {
            presenter.onBtn8Click()
        }

        findViewById<Button>(R.id.button7).setOnClickListener {
            presenter.onBtn9Click()
        }
        findViewById<Button>(R.id.button8).setOnClickListener {
            presenter.onMultiplicationClick()
        }
        findViewById<Button>(R.id.button9).setOnClickListener {
            presenter.onBtn4Click()
        }
        findViewById<Button>(R.id.button10).setOnClickListener {
            presenter.onBtn5Click()
        }
        findViewById<Button>(R.id.button11).setOnClickListener {
            presenter.onBtn6Click()
        }
        findViewById<Button>(R.id.button12).setOnClickListener {
            presenter.onSubtractionClick()
        }

        findViewById<Button>(R.id.button13).setOnClickListener {
            presenter.onBtn1Click()
        }
        findViewById<Button>(R.id.button14).setOnClickListener {
            presenter.onBtn2Click()
        }
        findViewById<Button>(R.id.button15).setOnClickListener {
            presenter.onBtn3Click()
        }
        findViewById<Button>(R.id.button16).setOnClickListener {
            presenter.onBtnAddClick()
        }

        findViewById<Button>(R.id.button17).setOnClickListener {
            presenter.onBtn0Click()
        }
        findViewById<Button>(R.id.button18).setOnClickListener {
            presenter.onBtnDotClick()
        }

        findViewById<Button>(R.id.button19).setOnClickListener {
            presenter.onBtnEqualClick()
        }
    }
}
