package org.easetech.easytest.reports.old;

import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.easetech.easytest.reports.data.ReportTotalsBean;
import org.easetech.easytest.reports.data.TestResultBean;

public class OldCode {
	
//	public Map<String, ReportTotalsBean> getTotals() {
//		Map<String, ReportTotalsBean> methodTotals = new LinkedHashMap<String, ReportTotalsBean>();
//		for (String key : this.methodTestResults.keySet()) {
//			ReportTotalsBean testReportTotals = new ReportTotalsBean();
//			testReportTotals.setItem(key);
//
//			List<TestResultBean> methodResults = this.methodTestResults.get(key);
//			Long minValue = 0L;
//			Long maxValue = 0L;
//			Long totalValue = 0L;
//			for (TestResultBean testResultBean : methodResults) {
//				//System.out.println(testResultBean);
//				if (testResultBean.getPassed() != null && testResultBean.getPassed()) {
//					testReportTotals.addPassed();
//				} else if (testResultBean.getPassed() != null && !testResultBean.getPassed()) {
//					testReportTotals.addFailed();
//				} else if (testResultBean.getException() != null && testResultBean.getException()) {
//					testReportTotals.addException();
//				}
//				/*
//				Long millisecondsDifference = ReportsUtils
//						.getMillisecondsDifference(testResultBean.getStart(),
//								testResultBean.getEnd());
//				if (totalValue != 0) {
//					minValue = Math.min(minValue, millisecondsDifference);
//				} else {
//					minValue = millisecondsDifference;
//				}
//				maxValue = Math.max(maxValue, millisecondsDifference);
//				totalValue += millisecondsDifference;
//				*/
//			}
//
//			testReportTotals.setMinDurationInMs(minValue);
//			testReportTotals.setMaxDurationInMs(maxValue);
//			testReportTotals.setAvgDurationInMs(totalValue
//					/ methodResults.size());
//
//			BufferedImage percentageImage = this.getPercentageImage(key, testReportTotals);
//			testReportTotals.setPercentageImage(percentageImage);
//			
//			BufferedImage durationImage = this.getDurationImage(key, testReportTotals);
//			testReportTotals.setDurationImage(durationImage);
//			
//			methodTotals.put(key, testReportTotals);
//		}
//		return methodTotals;
//	}

}
