/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 23 Jul, 2014 10:17:23 am
 * @author SPA
 * @mb-bg-ext-web
 *
 */
/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 23 Jul, 2014 10:17:23 am
 * @author SPA
 * @mb-bg-ext-web
 * ConnectivityCheckUtil.java
 *
 */
package com.mb.ext.web.util;

import java.util.GregorianCalendar;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mb.ext.core.message.ErrorCode;
import com.mb.ext.core.service.spec.ConnectionDTO;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.entity.AbstractBaseEntity;
import com.mb.framework.util.ConfigConstants;
import com.mb.framework.util.log.LogHelper;
import com.mb.framework.util.property.PropertyRepository;

/**
 * @author SPA
 * 
 */
@Repository
@Component
public class ConnectivityCheckUtil extends AbstractDAO<AbstractBaseEntity>
{

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	@Qualifier("mailSender")
	private JavaMailSender sender;

	/**
	 * 
	 * This method is used for testing database connection;
	 * 
	 * @return
	 */
	public ConnectionDTO getDBConnectivity()
	{

		String dbConnMessage = ConfigConstants.FAILURE_MSG;
		ConnectionDTO conn = new ConnectionDTO();

		try
		{

			String result = em.createNativeQuery("select 1 from DUAL").getSingleResult().toString();

			if (null != result)
			{

				dbConnMessage = ConfigConstants.SUCCESS_MSG;
			}
		}
		catch (Exception e)
		{
			logger.error("Error occurred in testing database connectivity", e);
		}
		conn.setHostName(propertyRepository.getProperty(ConfigConstants.DB_HOST));
		conn.setPort(propertyRepository.getProperty(ConfigConstants.DB_PORT));
		conn.setAccessTime(GregorianCalendar.getInstance().getTime().toString());
		conn.setVersion(propertyRepository.getProperty(ConfigConstants.VERSION_ID));
		conn.setMessage(dbConnMessage);
		logger.debug("Connection details for database" + conn.getHostName() + conn.getPort() + conn.getAccessTime() + conn.getMessage());
		return conn;
	}

	/**
	 * 
	 * This method is used for testing smtp host connectivity.
	 * 
	 * @return ConnectionDTO
	 */
	public ConnectionDTO getHostConnectivity()
	{

		ConnectionDTO conn = new ConnectionDTO();
		String hostConnStatus = ConfigConstants.FAILURE_MSG;
		try
		{
			final String[] recipients = new String[] { propertyRepository.getProperty(ErrorCode.RC_TO_USER1), propertyRepository.getProperty(ErrorCode.RC_TO_USER2), propertyRepository.getProperty(ErrorCode.RC_TO_USER3) };

			// send test email
			sender.send(new MimeMessagePreparator()
			{
				/**
				 * 
				 * This method is used to prepare the Mimemessage template.
				 * 
				 * @param mimeMessage
				 * @throws Exception
				 */
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception
				{
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
					messageHelper.setTo(recipients);

					messageHelper.setFrom(propertyRepository.getProperty(ErrorCode.MAIL_SENDER));

					logger.debug("The mail sender is " + propertyRepository.getProperty(ErrorCode.MAIL_SENDER));
					messageHelper.setSubject("Test Mail");
					messageHelper.setText("SMTP Connection is successful");

				}

			});

			hostConnStatus = ConfigConstants.SUCCESS_MSG;
		}
		catch (Exception e)
		{
			logger.error("Error occurred in testing smtp connectivity", e);
		}

		conn.setHostName(propertyRepository.getProperty(ConfigConstants.WS_ECHO_HOST));
		conn.setPort(propertyRepository.getProperty(ConfigConstants.WS_ECHO_PORT));
		conn.setAccessTime(GregorianCalendar.getInstance().getTime().toString());
		conn.setVersion(propertyRepository.getProperty(ConfigConstants.VERSION_ID));
		conn.setMessage(hostConnStatus);
		logger.debug("Connection details for host" + conn.getHostName() + conn.getPort() + conn.getAccessTime() + conn.getMessage());
		return conn;
	}

}
