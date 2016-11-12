package com.ctsig.common.base;

import com.ctsig.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 只返回成功的布尔值
	 * @return
	 */
	protected Result success() {
		return new Result(true);
	}
	
	/**
	 * 返回成功的布尔值和数据
	 * @param data
	 * @return
	 */
	protected Result success(Object data) {
		return new Result(true, data);
	}
	
	/**
	 * 返回成功的布尔值、消息和数据
	 * @param data
	 * @return
	 */
	protected Result success(String msg, Object data) {
		return new Result(true, msg, data);
	}
	
	/**
	 * 返回成功的布尔值、消息
	 * @param msg
	 * @return
	 */
	protected Result success(String msg) {
		return new Result(true, msg, null);
	}
	
	/**
	 * 只返回失败的布尔值
	 * @return
	 */
	protected Result failure() {
		return new Result(false);
	}
	
	/**
	 * 返回失败的布尔值和数据
	 * @param data
	 * @return
	 */
	protected Result failure(Object data) {
		return new Result(false, data);
	}
	
	/**
	 * 返回失败的布尔值、消息和数据
	 * @param data
	 * @return
	 */
	protected Result failure(String msg, Object data) {
		return new Result(false, msg, data);
	}
	/**
	 * 返回失败的布尔值、消息
	 * @param msg
	 * @return
	 */
	protected Result failure(String msg) {
		return new Result(false, msg, null);
	}
}
