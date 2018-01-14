package net.portes.graficas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createChart()
    }

    private fun createChart() {
        val mBarChart = BarGraphic()
        mBarChart.createBarGraphic(barChart)

        val mPieChart = PieGraphic()
        mPieChart.createPieGraphic(pieChart)

    }
}
