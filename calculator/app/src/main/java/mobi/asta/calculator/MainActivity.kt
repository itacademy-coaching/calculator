package mobi.asta.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), CalculatorView {
    override fun fillTextView1(value : String?) {
        findViewById<TextView>(R.id.textView).text = value
    }

    override fun fillTextView2(value : String?) {
        findViewById<TextView>(R.id.textView2).text = value
    }

    var presenter : CalculatorPresenter = CalculatorPresenterImp(this)

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClear = findViewById<Button>(R.id.button)
        val btnPersent = findViewById<Button>(R.id.button2)
        val btn9 = findViewById<Button>(R.id.button7)
        findViewById<Button>(R.id.button16).setOnClickListener{
            presenter.onBtnAddClick()
        }

        findViewById<Button>(R.id.button19).setOnClickListener{
            presenter.onBtnEqualClick()
        }

        findViewById<Button>(R.id.button5).setOnClickListener{
            presenter.onBtn7Click()
        }

        btnClear.setOnClickListener {
            presenter.onClearClick()
        }

        btn9.setOnClickListener {
            presenter.onBtn9Click()
        }
    }
}
