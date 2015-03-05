/**
 * 
 */
package com.guozha.buyserver.framework.log;

import com.guozha.buyserver.framework.sys.business.BusinessObject;

/**
 * @author peng.shi
 *
 */
public interface AuditLog extends BusinessObject
{
	String getId();
	
	LogType getLogType();
	
}
