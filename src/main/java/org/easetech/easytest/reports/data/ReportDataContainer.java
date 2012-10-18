package org.easetech.easytest.reports.data;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.easetech.easytest.reports.utils.ChartUtils;
import org.easetech.easytest.util.CommonUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Accumulates all the test results during a test run. Results are used as input
 * for the TestReportHelper
 * 
 * @author gpcmol
 * 
 */
public class ReportDataContainer {
	
	private String className;

	/**
	 * Holds the test results
	 */
	private List<TestResultBean> testResults;
	
	/**
	 * Holds the test results for method
	 */
	private Map<String, List<TestResultBean>> methodTestResults;
	
	
//TODO map method, list duration
	public ReportDataContainer() {
		this.testResults = new ArrayList<TestResultBean>();
		this.methodTestResults = new LinkedHashMap<String, List<TestResultBean>>();
	}
	
	public ReportDataContainer(String className) {
		this();
		this.className = className;
	}

	public void addTestResult(String method, Map<String, Object> input,
			Object output, Boolean passed, String result, Boolean exception,
			String exceptionResult) {
		TestResultBean testResultBean = new TestResultBean(method, input,
				output, passed, result, exception, exceptionResult, new Date());

		String key = testResultBean.getMethod();
		List<TestResultBean> list = this.methodTestResults.get(key);
		if (list == null) {
			list = new ArrayList<TestResultBean>();
			this.methodTestResults.put(key, list);
		}
		list.add(testResultBean);

		this.testResults.add(testResultBean);
	}

	/* ------------------------------------------------- */


	private BufferedImage getPercentageImage(String methodName, ReportTotalsBean testReportTotals) {
		DefaultPieDataset pieChartDataset = ChartUtils.getPieChartDataset(testReportTotals);
		JFreeChart pieChart = ChartUtils.getPieChart("", pieChartDataset);
		BufferedImage percentageImage = ChartUtils.getBufferedImageChartImage(pieChart, 220, 220);
		return percentageImage;
	}
	
	private BufferedImage getDurationImage(String methodName, ReportTotalsBean testReportTotals) {
		DefaultCategoryDataset barChartDataset = ChartUtils.getBarChartDataset(testReportTotals);
		JFreeChart barChart = ChartUtils.getBarChart("" + methodName, barChartDataset);
		BufferedImage durationImage = ChartUtils.getBufferedImageChartImage(barChart, 220, 220);
		return durationImage;
	}

	public List<TestResultBean> getTestResults() {
		return testResults;
	}

	public Map<String, List<TestResultBean>> getMethodTestResults() {
		return methodTestResults;
	}

	public String getClassName() {
		return className;
	}
	
}
