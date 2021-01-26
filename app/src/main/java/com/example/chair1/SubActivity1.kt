package com.example.chair1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_sub1.*
import lecho.lib.hellocharts.gesture.ZoomType
import lecho.lib.hellocharts.model.Axis
import lecho.lib.hellocharts.model.Column
import lecho.lib.hellocharts.model.ColumnChartData
import lecho.lib.hellocharts.model.SubcolumnValue
import lecho.lib.hellocharts.util.ChartUtils


class SubActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sub1)

        var columns = ArrayList<Column>()

        for(i in 0..0){
            var values = ArrayList<SubcolumnValue>()
            for(j in 0..5){
                values.add(SubcolumnValue(Math.random().toFloat()*100f, ChartUtils.pickColor()))
            }
            var column = Column(values)
            columns.add(column)
        }
        var data = ColumnChartData(columns)

        chart.columnChartData = data
        chart.zoomType = ZoomType.HORIZONTAL_AND_VERTICAL

        var axisX = Axis()
        var axisY = Axis()

        axisX.name = "부위"
        axisY.name = "수치값"

        data.axisXBottom = axisX
        data.axisYLeft = axisY
    }
}
