package net.portes.graficas

import android.graphics.Color
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import net.portes.graficas.R.id.barChart

/**
 * Created by portes on 13/01/18.
 */
class BarGraphic {
    val barWidth = 0.3f
    val barSpace = 0.0f
    val groupSpace = 0.1f

    private var mUtilsGraphics = UtilsGraphics()
    private val mMonths = arrayOf("18", "19", "20", "21", "22", "23")
    private val mDisccount = floatArrayOf(806.73f, 627.46f, 493.00f, 313.73f, 179.27f, 232f)
    private val mMoney = floatArrayOf(18f,14f, 11f, 7f, 54f, 43f)
    private val mDisccountTotal = floatArrayOf(3675.15f, 3854.41f, 3988.80f, 4168.15f, 4302.61f, 4481.85f)

    fun createBarGraphic(barChart: Chart<*>) {
        val barChart = mUtilsGraphics.getSampleChart(barChart, "Costos", Color.GRAY, Color.CYAN, 2000, true) as BarChart
        barChart.setDrawGridBackground(true)
        barChart.setDrawBarShadow(true)
        barChart.data = getBarData()

        barChart.barData.barWidth = barWidth
        barChart.xAxis.axisMinimum = 0f
        barChart.xAxis.axisMaximum = 0 + barChart.barData.getGroupWidth(groupSpace, barSpace) * 6
        barChart.groupBars(0f, groupSpace, barSpace)

        axisX(barChart.xAxis)
        axisLeft(barChart.axisLeft)
        axisRight(barChart.axisRight)

        barChart.invalidate()

    }

    private fun axisX(axis: XAxis) {
        axis.isGranularityEnabled = true
        axis.position = XAxis.XAxisPosition.BOTTOM
        axis.valueFormatter = IndexAxisValueFormatter(mMonths)
        axis.setCenterAxisLabels(true)
        axis.setDrawGridLines(false)
    }

    private fun axisLeft(axis: YAxis) {
        axis.spaceTop = 30f
        axis.axisMinimum = 0f
    }

    private fun axisRight(axis: YAxis) {
        axis.isEnabled = false

    }

    private fun getBarData(): BarData {
        val mBarDataSetDisccount = BarDataSet(getArrayBarEntryesDisccount(), mUtilsGraphics.mCutofLegend[0])
        mBarDataSetDisccount.color = mUtilsGraphics.mColors[0]
        val mBarDataSetPercentaje = BarDataSet(getArrayBarEntryesPercentaje(), mUtilsGraphics.mCutofLegend[1])
        mBarDataSetPercentaje.color = mUtilsGraphics.mColors[1]
        val mBarDataSetTotal = BarDataSet(getArrayBarEntryesTotal(), mUtilsGraphics.mCutofLegend[2])
        mBarDataSetTotal.color = mUtilsGraphics.mColors[2]

        val mBarData = BarData(mBarDataSetDisccount, mBarDataSetPercentaje, mBarDataSetTotal)
        return mBarData
    }

    private fun getArrayBarEntryesDisccount(): ArrayList<BarEntry> {
        val mArrayEntryes = ArrayList<BarEntry>()
        mDisccount.indices.mapTo(mArrayEntryes) { BarEntry(it.toFloat(), mDisccount[it]) }
        return mArrayEntryes
    }

    private fun getArrayBarEntryesPercentaje(): ArrayList<BarEntry> {
        val mArrayEntryes = ArrayList<BarEntry>()
        mMoney.indices.mapTo(mArrayEntryes) { BarEntry(it.toFloat(), mMoney[it]) }
        return mArrayEntryes
    }
    private fun getArrayBarEntryesTotal(): ArrayList<BarEntry> {
        val mArrayEntryes = ArrayList<BarEntry>()
        mDisccountTotal.indices.mapTo(mArrayEntryes) { BarEntry(it.toFloat(), mDisccountTotal[it]) }
        return mArrayEntryes
    }
}