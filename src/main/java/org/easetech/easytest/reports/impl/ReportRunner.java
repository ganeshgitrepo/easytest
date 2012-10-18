package org.easetech.easytest.reports.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.easetech.easytest.reports.data.ReportDataContainer;
import org.easetech.easytest.reports.data.ReportTotalsBean;
import org.easetech.easytest.reports.data.TestResultBean;
import org.easetech.easytest.reports.impl.ReportExporter.EXPORT_FORMAT;
import org.easetech.easytest.util.RunAftersWithOutputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class receives the preprared data from the ReportBuilder and runs the reports
 * @author gpcmol
 *
 */
public class ReportRunner {
	private static final Logger LOG = LoggerFactory.getLogger(ReportRunner.class);

	public void createReports(ReportDataContainer testReportContainer) {
		Map<String, List<TestResultBean>> methodTestResults = testReportContainer.getMethodTestResults();
		//Map<String, ReportTotalsBean> totals = testReportContainer.getTotals();
		
		JRDataSource defaultDataSource = new JRBeanCollectionDataSource(testReportContainer.getTestResults());
		
		ReportExporter testReportExporter = new ReportExporter();
//			List<ReportTotals> totalsList = new ArrayList<ReportTotals>();
//			totalsList.add(totals.get(key));
//			JRDataSource totalsDataSource = new JRBeanCollectionDataSource(totalsList);
			
			Map<String, Object> jasperParameters = new HashMap<String, Object>();
			jasperParameters.put("TEST_CLASS_NAME", testReportContainer.getClassName());
			
			String destinationFolder = null; // "c:/Temp/output"; /* not mandatory */
			EXPORT_FORMAT[] formats = { EXPORT_FORMAT.PDF }; //, EXPORT_FORMAT.HTML
			
			try {
				testReportExporter.printDefaultReport(defaultDataSource, jasperParameters, destinationFolder, formats);
				//testReportExporter.printTotalsReport(totalsDataSource, jasperParameters, destinationFolder, formats);
			} catch (JRException e) {
				LOG.error("JRException occurred during generation of report", e);
			} catch (IOException e) {
				LOG.error("IOException occurred during generation of report", e);
			}
	}
	
}
