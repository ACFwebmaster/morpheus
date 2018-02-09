/*
 * Copyright (c) 2016-2018 "Neo4j, Inc." [https://neo4j.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opencypher.caps.cosc.impl

import java.net.URI

import org.opencypher.caps.api.physical.RuntimeContext
import org.opencypher.caps.api.value.CypherValue.CypherMap

object COSCRuntimeContext {
  val empty = COSCRuntimeContext(CypherMap.empty, _ => None)
}

case class COSCRuntimeContext(
  parameters: CypherMap,
  resolve: URI => Option[COSCGraph]
) extends RuntimeContext[COSCRecords, COSCGraph]


