/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.carbondata.core.service.impl;

import org.apache.carbondata.core.cache.dictionary.DictionaryColumnUniqueIdentifier;
import org.apache.carbondata.core.metadata.AbsoluteTableIdentifier;
import org.apache.carbondata.core.service.PathService;
import org.apache.carbondata.core.util.path.CarbonStorePath;
import org.apache.carbondata.core.util.path.CarbonTablePath;

/**
 * Create helper to get path details
 */
public class PathFactory implements PathService {

  private static PathService pathService = new PathFactory();

  /**
   * @param absoluteTableIdentifier
   * @param
   * @return store path related to tables
   */
  @Override public CarbonTablePath getCarbonTablePath(
      AbsoluteTableIdentifier absoluteTableIdentifier,
      DictionaryColumnUniqueIdentifier dictionaryColumnUniqueIdentifier) {
    if (null != dictionaryColumnUniqueIdentifier && null != dictionaryColumnUniqueIdentifier
        .getCarbonTablePath()) {
      return dictionaryColumnUniqueIdentifier.getCarbonTablePath();
    }
    return CarbonStorePath.getCarbonTablePath(absoluteTableIdentifier);
  }

  public static PathService getInstance() {
    return pathService;
  }
}
