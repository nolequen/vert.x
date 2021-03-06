/*
 * Copyright (c) 2011-2013 The original author or authors
 *  ------------------------------------------------------
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *      The Eclipse Public License is available at
 *      http://www.eclipse.org/legal/epl-v10.html
 *
 *      The Apache License v2.0 is available at
 *      http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.core.http.impl.pool;

import io.vertx.core.impl.ContextImpl;
import io.vertx.core.impl.ContextInternal;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public abstract class Waiter<C> {

  public final ContextImpl context;

  protected Waiter(ContextImpl context) {
    this.context = context;
  }

  /**
   * Handle connection failure, this callback is on a Netty even loop.
   *
   * @param ctx the context used to create the connection
   * @param failure the failure
   */
  public abstract void handleFailure(ContextInternal ctx, Throwable failure);

  /**
   * Init connection, this callback is on a Netty event loop.
   *
   * @param ctx the context used to create the connection
   * @param conn the connection
   */
  public abstract void initConnection(ContextInternal ctx, C conn);

  /**
   * Handle connection success, , this callback is on a Netty event loop.
   *
   * @param ctx the context used to create the connection
   * @param conn the connection
   * @return wether the waiter uses the connection
   */
  public abstract boolean handleConnection(ContextInternal ctx, C conn) throws Exception;

}
