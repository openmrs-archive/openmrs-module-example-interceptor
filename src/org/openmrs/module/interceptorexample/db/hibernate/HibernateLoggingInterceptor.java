/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.interceptorexample.db.hibernate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 * Example interceptor that is added to the hibernate sessions via the sessionfactory.<br/>
 * <br/>
 * See the /metadata/moduleApplicationContext.xml for how this is done.<br/>
 * <br/>
 * See /metadata/log4j.xml for why these .info statements are appearing in the logs
 */
public class HibernateLoggingInterceptor extends EmptyInterceptor {
	
	private static final long serialVersionUID = 6119616890833647300L;
	
	private static Log log = LogFactory.getLog(HibernateLoggingInterceptor.class);
	
	/**
	 * @see org.hibernate.EmptyInterceptor#onCollectionRecreate(java.lang.Object,
	 *      java.io.Serializable)
	 */
	@Override
	public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
		log.info("collection: " + collection + " key: " + key);
		
		super.onCollectionRecreate(collection, key);
	}
	
	/**
	 * @see org.hibernate.EmptyInterceptor#onCollectionRemove(java.lang.Object,
	 *      java.io.Serializable)
	 */
	@Override
	public void onCollectionRemove(Object collection, Serializable key) throws CallbackException {
		log.info("collection: " + collection + " key: " + key);
		
		super.onCollectionRemove(collection, key);
	}
	
	/**
	 * @see org.hibernate.EmptyInterceptor#onCollectionUpdate(java.lang.Object,
	 *      java.io.Serializable)
	 */
	@Override
	public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
		log.info("collection: " + collection + " key: " + key);
		
		super.onCollectionUpdate(collection, key);
	}
	
	/**
	 * @see org.hibernate.EmptyInterceptor#onDelete(java.lang.Object, java.io.Serializable,
	 *      java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		log.info("entity: " + entity + " id: " + id + " state: " + Arrays.toString(state) + " propertynames: "
		        + Arrays.toString(propertyNames) + " types: " + Arrays.toString(types));
		
		super.onDelete(entity, id, state, propertyNames, types);
	}
	
	/**
	 * @see org.hibernate.EmptyInterceptor#onSave(java.lang.Object, java.io.Serializable,
	 *      java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		log.info("entity: " + entity + " id: " + id + " state: " + Arrays.toString(state) + " propertynames: "
		        + Arrays.toString(propertyNames) + " types: " + Arrays.toString(types));
		
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	/**
	 * @see org.hibernate.EmptyInterceptor#postFlush(java.util.Iterator)
	 */
	@Override
	public void postFlush(Iterator entities) {
		if (log.isInfoEnabled()) {
			StringBuilder output = new StringBuilder();
			while (entities.hasNext())
				output.append(entities.next()).append(", ");
			
			log.info("entities: " + output);
		}
		
		super.postFlush(entities);
	}
	
}
