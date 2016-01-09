/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simufiles;

import java.util.LinkedList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GraphSimu extends ApplicationFrame {

    public GraphSimu(String applicationTitle, String chartTitle, LinkedList<Stat> stats, boolean onlyTotal) {
        super(applicationTitle);
        final JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Le nombre de paquets par seconde pour les deux files et au total", // chart title
                "X", // x axis label
                "Y", // y axis label
                createDataset(stats, onlyTotal), // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
        setContentPane(chartPanel);
    }

    private XYDataset createDataset(LinkedList<Stat> stats, boolean onlyTotal) {
        final XYSeries series1 = new XYSeries("File 1");
        final XYSeries series2 = new XYSeries("File 2");
        final XYSeries series3 = new XYSeries("Total");

        int periode_max = 20;
        int periode = 0;
        for (Stat stat : stats) {
            if (periode % periode_max == 0) {

                double time = stat.getTime();
                int nb_paquets1 = stat.getPaquets1();
                int nb_paquets2 = stat.getPaquets2();
                int nb_paquets_total = nb_paquets1 + nb_paquets2;
                series1.add(time, nb_paquets1);
                if (!onlyTotal) {
                    series2.add(time, nb_paquets2);
                    series3.add(time, nb_paquets_total);
                }
            }
            periode++;
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        if (!onlyTotal) {
            dataset.addSeries(series2);
            dataset.addSeries(series3);
        }

        return dataset;
    }

    public static void main(String[] args) {

        /**
         * mu1, mu2, lambda, nb_periode, nb_paquets_max
         */
        Simulator simulator = new Simulator(1, 1, 1, 10, 100000);
        LinkedList<Stat> stats = simulator.run();

        GraphSimu chart = new GraphSimu(
                "Statistiques de simu",
                "Numer of Schools vs years",
                stats,
                true);

        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
