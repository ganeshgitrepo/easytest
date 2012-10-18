package org.easetech.easytest.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.io.FileUtils;

/**
 * This class contains common utils
 * 
 * @author gpcmol
 * 
 */
public class CommonUtils {

	/**
	 * Rounds a value with number of decimals
	 * 
	 * @param valueToRound
	 * @param numberOfDecimalPlaces
	 * @return rounded double
	 */
	public static Double getRounded(double valueToRound,
			int numberOfDecimalPlaces) {
		BigDecimal bigDecimal = new BigDecimal(valueToRound).setScale(
				numberOfDecimalPlaces, RoundingMode.HALF_UP);
		return bigDecimal.doubleValue();
	}

	/**
	 * Create directory
	 * 
	 * @param destinationFolder
	 * @return
	 */
	public static String createDefaultOutputFolder(String destinationFolder) {
		if (destinationFolder == null || destinationFolder.equals("")) {
			destinationFolder = System.getProperty("user.dir")
					+ File.separatorChar + "target" + File.separatorChar
					+ "reports";
			try {
				FileUtils.forceMkdir(new File(destinationFolder));
			} catch (IOException e) {
				System.out.println("Error creating directory "
						+ destinationFolder + " (" + e.getMessage() + ")");
			}
		}
		return destinationFolder;
	}

}
