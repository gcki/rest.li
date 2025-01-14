/*
   Copyright (c) 2023 LinkedIn Corp.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.linkedin.d2.jmx;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


public class XdsClientJmx implements XdsClientJmxMBean {

  private final AtomicInteger _connectionLostCount = new AtomicInteger();
  private final AtomicInteger _connectionClosedCount = new AtomicInteger();
  private final AtomicInteger _reconnectionCount = new AtomicInteger();

  private final AtomicBoolean _isConnected = new AtomicBoolean();

  @Override
  public int getConnectionLostCount()
  {
    return _connectionLostCount.get();
  }

  @Override
  public int getConnectionClosedCount()
  {
    return _connectionClosedCount.get();
  }

  @Override
  public int getReconnectionCount()
  {
    return _reconnectionCount.get();
  }

  @Override
  public int isDisconnected()
  {
    return _isConnected.get() ? 0 : 1;
  }

  public void incrementConnectionLostCount()
  {
    _connectionLostCount.incrementAndGet();
  }

  public void incrementConnectionClosedCount()
  {
    _connectionClosedCount.incrementAndGet();
  }

  public void incrementReconnectionCount()
  {
    _reconnectionCount.incrementAndGet();
  }

  public void setIsConnected(boolean connected)
  {
    _isConnected.getAndSet(connected);
  }
}
