package net.portes.graficas

import android.graphics.Color
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.DataSet
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import kotlinx.android.synthetic.main.activity_main.*
import net.portes.graficas.R.id.pieChart

/**
 * Created by portes on 13/01/18.
 */
open class PieGraphic {
    private var mUtilsGraphics = UtilsGraphics()
    private  val mMoney =   floatArrayOf(58661.39f, 4022.18f, 0.00f)

    fun createPieGraphic(pieChart : Chart<*>) {
        val pieChart = mUtilsGraphics.getSampleChart(pieChart, "", Color.GRAY, Color.WHITE, 2000, false) as PieChart

        pieChart.data = getPieData()
        pieChart.holeRadius = 70f
        pieChart.centerText = "TOTAL $44566"
        pieChart.transparentCircleRadius = 12f
        pieChart.setCenterTextSize(20f)
        pieChart.setEntryLabelTextSize(12f)
        pieChart.setDrawEntryLabels(true)
        pieChart.invalidate()
    }

    private fun getArrayPieEntryes(): ArrayList<PieEntry> {
        val mArrayEntryes = ArrayList<PieEntry>()
        mMoney.indices.mapTo(mArrayEntryes) { PieEntry(mMoney[it]) }
        return mArrayEntryes
    }
    private fun getPieData(): PieData {
        val mPieDataSet = mUtilsGraphics.getData(PieDataSet(getArrayPieEntryes(), "")) as PieDataSet
        mPieDataSet.valueTextSize = 15f
        mPieDataSet.valueTextColor = Color.WHITE
        mPieDataSet.valueFormatter = PercentFormatter()
        return PieData(mPieDataSet)
    }

}