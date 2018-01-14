package net.portes.graficas

import android.graphics.Color
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.data.DataSet

/**
 * Created by portes on 13/01/18.
 */
open class UtilsGraphics {
    private val mMonths = arrayOf("Vigente", "Vencido", "Exigible")
    val mCutofLegend = arrayOf("Descuento", "Porcentaje", "TOTAL")

    val mColors = intArrayOf(Color.parseColor("#31708f"), Color.parseColor("#a94442"), Color.parseColor("#fcf8e3"))
    fun getSampleChart(mChart: Chart<*>, mDescription: String, mTextColor: Int, mBackground: Int, mAnimateY: Int, mIspieChart: Boolean): Chart<*> {
        mChart.description.text = mDescription
        mChart.description.textSize = 15f
        mChart.description.textColor = mTextColor
        mChart.animateY(mAnimateY)

        if (mIspieChart) {
            setLegendBar(mChart)
        } else {
            setLegendPie(mChart)
        }

        return mChart
    }

    fun getData(dataSet: DataSet<*>): DataSet<*> {
        dataSet.setColors(*mColors)
        dataSet.valueTextSize = 10f
        return dataSet
    }

    private fun setLegendPie(mChart: Chart<*>) {
        val mLegend = mChart.legend
        mLegend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        mLegend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        mLegend.orientation = Legend.LegendOrientation.VERTICAL
        val mArrayEntryes = ArrayList<LegendEntry>()

        for (i in mMonths.indices) {
            val mLegendEntry = LegendEntry()
            mLegendEntry.formColor = mColors[i]
            mLegendEntry.label = mMonths[i]
            mArrayEntryes.add(mLegendEntry)
        }
        mLegend.setCustom(mArrayEntryes)
    }

    private fun setLegendBar(mChart: Chart<*>) {
        val mLegend = mChart.legend
        mLegend.form = Legend.LegendForm.CIRCLE
        mLegend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        mLegend.textSize = 20f
        val mArrayEntryes = ArrayList<LegendEntry>()
        for (i in mMonths.indices) {
            val mLegendEntry = LegendEntry()
            mLegendEntry.formColor = mColors[i]
            mLegendEntry.label = mMonths[i]
            mArrayEntryes.add(mLegendEntry)
        }
        mLegend.setCustom(mArrayEntryes)
    }
}