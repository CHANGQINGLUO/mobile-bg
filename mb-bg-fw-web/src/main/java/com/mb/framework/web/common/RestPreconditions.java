/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 18 May, 2014 11:53:24 am
 * @author SPA
 * @mb-bg-ext-web
 *
 */
/**
 * 
 */
package com.mb.framework.web.common;

import org.springframework.http.HttpStatus;

import com.mb.framework.web.exception.ConflictException;
import com.mb.framework.web.exception.ForbiddenException;
import com.mb.framework.web.exception.ResourceNotFoundException;

/**
 * @author SPA
 *
 */
/**
 * Simple static methods to be called at the start of your own methods to verify correct arguments and state. 
 If the Precondition fails, an {@link HttpStatus} code is thrown
 */
public final class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    // API

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     * 
     * @param reference
     *            an object reference
     * @return the non-null reference that was validated
     * @throws ResourceNotFoundException
     *             if {@code reference} is null
     */
    public static <T> T checkNotNull(final T reference) {
        if (reference == null) {
            throw new ResourceNotFoundException();
        }
        return reference;
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     * 
     * @param reference
     *            an object reference
     * @return the non-null reference that was validated
     * @throws ConflictException
     *             if {@code reference} is null
     */
    public static <T> T checkRequestElementNotNull(final T reference) {
        if (reference == null) {
            throw new ConflictException();
        }
        return reference;
    }

    /**
     * Ensures the truth of an expression
     * 
     * @param expression
     *            a boolean expression
     */
    public static void checkRequestState(final boolean expression) {
        if (!expression) {
            throw new ConflictException();
        }
    }

    /**
     * Check if some value was found, otherwise throw exception.
     * 
     * @param expression
     *            has value true if found, otherwise false
     * @throws ResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static void checkFound(final boolean expression) {
        if (!expression) {
            throw new ResourceNotFoundException();
        }
    }

    /**
     * Check if some value was found, otherwise throw exception.
     * 
     * @param expression
     *            has value true if found, otherwise false
     * @throws ResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }

        return resource;
    }

    /**
     * Check if some value was found, otherwise throw exception.
     * 
     * @param expression
     *            has value true if found, otherwise false
     * @throws ForbiddenException
     *             if expression is false, means operation not allowed.
     */
    public static void checkAllowed(final boolean expression) {
        if (!expression) {
            throw new ForbiddenException();
        }
    }

}
