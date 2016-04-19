package com.mb.ext.web.exception;

import java.util.List;
import java.util.Locale;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mb.ext.web.message.Errors;
import com.mb.ext.web.util.MessageHelper;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.exception.SystemException;
import com.mb.framework.util.log.LogHelper;
import com.mb.framework.web.exception.BadRequestException;
import com.mb.framework.web.exception.ConflictException;
import com.mb.framework.web.exception.ForbiddenException;
import com.mb.framework.web.exception.PreconditionFailedException;
import com.mb.framework.web.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	@Autowired
	private MessageSource messageSource;

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	public RestResponseEntityExceptionHandler()
	{
		super();
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusinessException(final BusinessException ex, final WebRequest request)
	{
		logger.error("Exception thrown in RestresponseEntity Handler is" + ex);
		final Errors errors = MessageHelper.createError(ex.getErrorCode(), MessageHelper.getMessageByErrorId(messageSource, ex.getErrorCode()));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.EXPECTATION_FAILED, request);
	}

	@ExceptionHandler(SystemException.class)
	public ResponseEntity<Object> handleSystemException(final SystemException ex, final WebRequest request)
	{
		logger.error("Exception thrown in RestresponseEntity Handler is" + ex);
		final Errors errors = MessageHelper.createError(ex.getErrorCode(), MessageHelper.getMessageByErrorId(messageSource, ex.getErrorCode()));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	// 400
	@ExceptionHandler({ ConstraintViolationException.class, BadRequestException.class, DataIntegrityViolationException.class })
	public ResponseEntity<Object> handleBadRequest(final RuntimeException ex, final WebRequest request)
	{
		logger.error("Exception thrown in RestresponseEntity Handler is" + ex);
		final Errors errors = MessageHelper.createError(MessageHelper.getDefaultErrorCode(), MessageHelper.getDefaultMessage(messageSource));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request)
	{
		logger.error("Exception thrown in RestresponseEntity Handler is" + ex);
		final Errors errors = MessageHelper.createError(MessageHelper.getDefaultErrorCode(), MessageHelper.getDefaultMessage(messageSource));
		// ex.getCause() instanceof JsonMappingException, JsonParseException //
		// for additional information later on
		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request)
	{
		logger.error("Exception thrown in RestresponseEntity Handler is" + ex);
		Errors errors = new Errors();
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		Locale currentLocale = LocaleContextHolder.getLocale();
		for (FieldError fieldError : fieldErrors)
		{
			String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);
			errors.appendError(fieldError.getField(), localizedErrorMessage);
		}

		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}

	// 403

	@ExceptionHandler({ ForbiddenException.class })
	public ResponseEntity<Object> handleForbidden(final ForbiddenException ex, final WebRequest request)
	{
		logger.error("Exception thrown in RestresponseEntity Handler is" + ex);
		final Errors errors = MessageHelper.createError(MessageHelper.getDefaultErrorCode(), MessageHelper.getDefaultMessage(messageSource));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
	}

	// 404

	@ExceptionHandler({ ResourceNotFoundException.class })
	public ResponseEntity<Object> handleNotFound(final ResourceNotFoundException ex, final WebRequest request)
	{
		logger.error("Exception thrown in RestresponseEntity Handler is" + ex);
		final Errors errors = MessageHelper.createError(MessageHelper.getDefaultErrorCode(), MessageHelper.getDefaultMessage(messageSource));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	protected ResponseEntity<Object> handleBadRequest(final EntityNotFoundException ex, final WebRequest request)
	{
		logger.error("Exception thrown in RestresponseEntity Handler is" + ex);
		final Errors errors = MessageHelper.createError(MessageHelper.getDefaultErrorCode(), MessageHelper.getDefaultMessage(messageSource));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	// 409

	@ExceptionHandler({ InvalidDataAccessApiUsageException.class, DataAccessException.class, ConflictException.class })
	protected ResponseEntity<Object> handleConflict(final RuntimeException ex, final WebRequest request)
	{
		logger.error("Exception thrown in RestresponseEntity Handler is" + ex);
		final Errors errors = MessageHelper.createError(MessageHelper.getDefaultErrorCode(), MessageHelper.getDefaultMessage(messageSource));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	// 4xx
	// 412
	@ExceptionHandler({ PreconditionFailedException.class })
	protected ResponseEntity<Object> handlePreconditionFailed(final RuntimeException ex, final WebRequest request)
	{
		logger.error("Exception thrown in RestresponseEntity Handler is" + ex);
		final Errors errors = MessageHelper.createError(MessageHelper.getDefaultErrorCode(), MessageHelper.getDefaultMessage(messageSource));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.PRECONDITION_FAILED, request);
	}

	// *500
	@ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
	public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request)
	{
		logger.error("Exception thrown in RestresponseEntity Handler is" + ex);
		logger.error("500 Status Code", ex);
		final Errors errors = MessageHelper.createError(MessageHelper.getDefaultErrorCode(), MessageHelper.getDefaultMessage(messageSource));
		return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
