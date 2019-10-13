package com.fizhu.androidchart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;

public class ContohPieChartActivity extends AppCompatActivity {

    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contoh_pie_chart);

        //TODO 1 CAST VIEW CHART
        pieChart = findViewById(R.id.chart_pie);


        //TODO 2 PENGATURAN PIE CHART
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);


        //TODO 3 ATUR JUDUL PIE CHART YANG NANTI DI TAMPILKAN DITENGAH CHART
        pieChart.setCenterText("Judul\nPie Chart");


        //TODO 4 PENGATURAN PIE CHART LANJOOOOOT
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);


        pieChart.setTransparentCircleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(110);

        pieChart.setDrawCenterText(true);

        pieChart.setRotationAngle(0);

        pieChart.setRotationEnabled(true);
        pieChart.setHighlightPerTapEnabled(true);


        pieChart.animateY(1400, Easing.EaseInOutQuad);


        //TODO 5 PENGATURAN LEGEND PIE CHART, NGATUR POSISI DAN TAMPILAN LEGEND NYA
        Legend legend = pieChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setXEntrySpace(7f);
        legend.setYEntrySpace(0f);
        legend.setYOffset(0f);

        pieChart.setEntryLabelColor(Color.WHITE);
        pieChart.setEntryLabelTextSize(12f);


        // TODO 6 MANGGIL FUNSI SET DATA BIAR DATANYA DI TAMPILIN DI PIE CHART
        setData();
    }

    private void setData() {


        //TODO 7 BUAT ARRAYLIST DATA YANG NANTI DIISI SAMA DATA YANG MAU DITAMPILIN DI PIE CHART
        ArrayList<PieEntry> entries = new ArrayList<>();

        //TODO 8 NAMBAHIN DATA KE ARRAYLIST YANG NANTINYA DI TAMPILIN, caranya >> entries.add(new PieEntry(Isi dengan value dengan tipe data float, "Isi dengan Nama Label"));
        entries.add(new PieEntry(1500f, "Label Satu"));
        entries.add(new PieEntry(2000f, "Label Dua"));
        entries.add(new PieEntry(1000f, "Label Tiga"));
        entries.add(new PieEntry(125f, "Label Empat"));


        // TODO 9 MASUKIN DATA ARRAYLIST TADI KE PIE CHART
        PieDataSet dataSet = new PieDataSet(entries, "Label Result");


        // TODO 10 PENGATURAN LANJOOOOT
        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);


        // TODO 11 PENGATURAN WARNA DALEMAN PIE CHART
        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);


        // TODO 12 PENGATURAN LANJOOT LAGIII
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        pieChart.setData(data);

        // undo all highlights
        pieChart.highlightValues(null);

        pieChart.invalidate();
    }
}
