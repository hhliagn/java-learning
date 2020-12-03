package com.javalearning.demo.excel.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.Map;

public class NumberUtils {

	public static <T> T getOrDefault(T value,T defaultValue) {
		return value == null ? defaultValue : value;
	}

	public static Integer ifNullReturnZero(Integer num) {
		return num == null ? 0 : num;
	}

	// 保留两位小数
	public static Double keepTwoDecimal(Double val) {
		if (val == null)
			return null;
		return Math.round(val * 100) / 100d;
	}

	public static String formatDoubleStr(double value, int precision) {
		String repr = Double.toString(value);
		if (precision == 0) {
			return StringUtils.substringBefore(repr, ".");
		} else {
			int pos = repr.indexOf(".");
			return StringUtils.substring(repr, 0, pos + precision + 1);
		}
	}
	
	public static String formatKeepTwoDecimal(Double val){
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(val);
	}

	public static String formatDouble(double value, int scale) {
		return new BigDecimal(value).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}

	// 分转元（字符串）
	public static String fenUnit2YuanString(Integer val) {
		if (val == null || val == 0) {
			return "0.00";
		} else {
			/* 不能直接除以100，使用double会出现精度问题，导致默认自动转换为科学计数法，如99899899101
			// 出现的情况，1）整数 2）带一位小数，3）带二位小数
			Double res = val / 100d;
			String v = String.valueOf(res);
			if (v.contains(".")) {
				// 校验小数位数
				if (v.substring(v.indexOf(".") + 1).length() == 1) {
					v += "0";
				}
			} else {
				// 补加
				v += ".00";
			}
			*/
			String res = fenUnit2YuanString(Long.valueOf(String.valueOf(val)));
			return res;
		}
	}
	
	// 分转元（字符串）
	public static String fenUnit2YuanString(Long val) {
		if (val == null || val == 0) {
			return "0.00";
		} else {
			
			/* 不能直接除以100，使用double会出现精度问题，导致默认自动转换为科学计数法，如99899899101
			// 出现的情况，1）整数 2）带一位小数，3）带二位小数
			Double res = val / 100d;
			Double res = val / 100d;
			String v = String.valueOf(res);
			if (v.contains(".")) {
				// 校验小数位数
				if (v.substring(v.indexOf(".") + 1).length() == 1) {
					v += "0";
				}
			} else {
				// 补加
				v += ".00";
			}
			*/
			String tempVal = String.valueOf(val);
			StringBuffer result = new StringBuffer();
			if(tempVal.length() == 1){
				result.append("0.0").append(tempVal);    
			}else if(tempVal.length() == 2){
				result.append("0.").append(tempVal);    
			}else{
				result = new StringBuffer(tempVal);
				result = result.insert(tempVal.length() - 2, '.');
			}
			return result.toString();
		}
	}
	
	// 元转分
	public static Integer yuanUnit2Fen(Double val) {
		if (val == null)
			return null;
		//return (int) (val * 100);
		return yuanUnit2Fen(String.valueOf(val));
	}

	// 元转分
	public static Integer yuanUnit2Fen(String val) {
		if (StringUtils.isBlank(val)) {
			return 0;
		}
//		Double parseDouble = Double.parseDouble(val) * 100D;
//		return parseDouble.intValue();
		int index = val.indexOf(".");
		int length = val.length();   
		Integer result = 0;
		if(index == -1){
			result = Integer.valueOf(val + "00");
		}else if(length - index >= 3){    
			result = Integer.valueOf((val.substring(0, index+3)).replace(".", ""));    
        }else if(length - index == 2){    
        	result = Integer.valueOf((val.substring(0, index+2)).replace(".", "")+0);    
        }else{    
        	result = Integer.valueOf((val.substring(0, index+1)).replace(".", "")+"00");    
        }
		return result;
	}

	public static Long yuanUnit2FenWithLong(String val){
		if (StringUtils.isBlank(val)) {
			return 0L;
		}
//		Double parseDouble = Double.parseDouble(val) * 100D;
//		return parseDouble.intValue();
		int index = val.indexOf(".");
		int length = val.length();
		Long result = 0L;
		if(index == -1){
			result = Long.valueOf(val + "00");
		}else if(length - index >= 3){
			result = Long.valueOf((val.substring(0, index+3)).replace(".", ""));
		}else if(length - index == 2){
			result = Long.valueOf((val.substring(0, index+2)).replace(".", "")+0);
		}else{
			result = Long.valueOf((val.substring(0, index+1)).replace(".", "")+"00");
		}
		return result;
	}

	public static Integer byteToIntCanNull(Byte val) {
		return val == null ? null : val.intValue();
	}

	public static Byte intToByteCanNull(Integer val) {
		return val == null ? null : val.byteValue();
	}

	public static String cutTrailingZero(double d)
	{
		if(d == (long) d)
			return String.format("%d",(long)d);
		else
			return String.format("%s",d);
	}

	/**
	 * @param dividend 被除数
	 * @param divisor 除数
	 */
	public static Integer divide(Integer dividend, Integer divisor) {
		if (dividend == null || divisor == null || divisor == 0) {
			return 0;
		}
		return dividend / divisor;
	}

	/**
	 * @param dividend 被除数
	 * @param divisor 除数
	 */
	public static Double divide(Integer dividend, Double divisor) {
		if (dividend == null || divisor == null || divisor == 0) {
			return 0d;
		}
		return dividend / divisor;
	}

	/**
	 * @param dividend 被除数
	 * @param divisor 除数
	 */
	public static Double divide(Double dividend, Integer divisor) {
		if (dividend == null || divisor == null || divisor == 0) {
			return 0d;
		}
		return dividend / divisor;
	}

	public static void mergeCounts(Map<String, Long> sourceCounts, Map<String, Long> targetCounts) {
		for (String key : sourceCounts.keySet()) {
			Long count = targetCounts.get(key);
			if (count == null) {
				count = sourceCounts.get(key);
			} else {
				count = sourceCounts.get(key) + count;
			}
			targetCounts.put(key, count);
		}
	}

	/**
	 * 去掉小数点后的字符串
	 *
	 * @param str
	 * @return
	 */
	public static String dropDot(String str) {
		return str != null && str.contains(".") ? str.split("\\.")[0] : str;
	}

	public static long strFenToLong(String str) {
		if (StringUtils.isEmpty(str)) {
			return 0L;
		}

		try {
			return Long.valueOf(str);
		} catch (Exception e) {
			return 0L;
		}
	}

	@Deprecated
	public static Integer formatDoublePrice(Double price) {
		int priceInt = (int) (price * 100);
		return Integer.valueOf(priceInt);
	}


	//四舍五入法
	public static long roundingOff(Long amount, Double rate) {
		//使用参数为float或double的BigDecimal创建对象会丢失精度。因此强烈建议不要使用参数为float或double的BigDecimal创建对象。
		String rateStr = String.valueOf(rate);
		try {
			BigDecimal b = new BigDecimal(amount).multiply(new BigDecimal(rateStr), MathContext.UNLIMITED);
			BigDecimal b2 = b.setScale(0, BigDecimal.ROUND_HALF_UP);
			return b2.longValue();
		}catch (Exception e){
			e.printStackTrace();
		}

		return 0;
	}

	//进一法
	public static long ceil(Long amount, Double rate) {
		//使用参数为float或double的BigDecimal创建对象会丢失精度。因此强烈建议不要使用参数为float或double的BigDecimal创建对象。
		String rateStr = String.valueOf(rate);
		try {
			BigDecimal b = new BigDecimal(amount).multiply(new BigDecimal(rateStr), MathContext.UNLIMITED);
			BigDecimal b2 = b.setScale(1, BigDecimal.ROUND_HALF_UP);
			System.out.println("==" + b2.toPlainString());
			return  (long)Math.ceil(b2.doubleValue());
		}catch (Exception e){
			e.printStackTrace();
		}

		return 0;
	}

	//舍尾法
	public static long floor(Long amount, Double rate) {
		//使用参数为float或double的BigDecimal创建对象会丢失精度。因此强烈建议不要使用参数为float或double的BigDecimal创建对象。
		String rateStr = String.valueOf(rate);
		try {
			BigDecimal b = new BigDecimal(amount).multiply(new BigDecimal(rateStr), MathContext.UNLIMITED);
			BigDecimal b2 = b.setScale(0, BigDecimal.ROUND_DOWN);
			return b2.longValue();
		}catch (Exception e){
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 获取负数金额
	 * */
	public static Long getNegativeAmt(Long amt) {
		return Math.abs(amt) * -1;
	}

	/**
	 * 获取正数金额
	 * */
	public static Long getPositiveAmt(Long amt) {
		return Math.abs(amt);
	}

}
