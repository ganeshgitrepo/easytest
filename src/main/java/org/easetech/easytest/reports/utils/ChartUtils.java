package org.easetech.easytest.reports.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.easetech.easytest.reports.data.ReportTotalsBean;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ChartUtils {

	/**
	 * Returns a BufferedImage of JFreeChart object
	 * @param chart JFreeChart object
	 * @param width width
	 * @param height height
	 * @return BufferedImage
	 */
	public static BufferedImage getBufferedImageChartImage(JFreeChart chart,
			int width, int height) {
		BufferedImage createBufferedImage = chart.createBufferedImage(width,
				height);
		return createBufferedImage;
	}

	public static JFreeChart getPieChart(String title, DefaultPieDataset dataset) {
		JFreeChart pieChart = ChartFactory.createPieChart(title, dataset, true, // legend
				true, // tooltips
				false // URLs
				);

		PiePlot plot = (PiePlot) pieChart.getPlot();

		// green=passed, red=failed, grey=exception
		Color[] colors = { Color.GREEN, Color.RED, Color.GRAY };
		PieChartColorRendererHelper renderer = new PieChartColorRendererHelper(colors);
		renderer.setColor(plot, dataset);

		return pieChart;
	}
	
	public static DefaultPieDataset getPieChartDataset(ReportTotalsBean testReportTotals) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Passed ("+testReportTotals.getPercentagePassed()+"%)", testReportTotals.getPercentagePassed());
		dataset.setValue("Failed ("+testReportTotals.getPercentageFailed()+"%)", testReportTotals.getPercentageFailed());
		dataset.setValue("Exception ("+testReportTotals.getPercentageException()+"%)", testReportTotals.getPercentageException());
		return dataset;
	}
	
	public static DefaultCategoryDataset getBarChartDataset(ReportTotalsBean testReportTotals) {
		  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		  dataset.setValue(testReportTotals.getMinDurationInMs(), "Ms.", "Min. duration");
//		  dataset.setValue(testReportTotals.getAvgDurationInMs(), "Ms.", "Avg. duration");
//		  dataset.setValue(testReportTotals.getMaxDurationInMs(), "Ms.", "Max. duration");
		  return dataset;
	}
	
	public static JFreeChart getBarChart(String title, DefaultCategoryDataset dataset) {
		  JFreeChart chart = ChartFactory.createBarChart("","Min/Avg/Max", "", dataset, PlotOrientation.VERTICAL, false, true, false);
		  CategoryPlot plot = chart.getCategoryPlot(); 
		  plot.setRangeGridlinePaint(Color.red); 
		  return chart;
	}

}
