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
package org.opencypher.caps.cosc.impl.datasource

import java.net.URI

import org.opencypher.caps.api.exception.IllegalArgumentException
import org.opencypher.caps.api.graph.CypherSession
import org.opencypher.caps.cosc.impl.COSCConverters._
import org.opencypher.caps.cosc.impl.COSCSession

abstract class COSCPropertyGraphDataSourceFactoryImpl(val companion: COSCGraphSourceFactoryCompanion)
    extends COSCPropertyGraphDataSourceFactory {

  override final val name: String = getClass.getSimpleName

  override final def schemes: Set[String] = companion.supportedSchemes

  override final def sourceFor(uri: URI)(implicit cypherSession: CypherSession): COSCPropertyGraphDataSource = {
    implicit val coscSession = cypherSession.asCosc
    if (schemes.contains(uri.getScheme)) sourceForURIWithSupportedScheme(uri)
    else throw IllegalArgumentException(s"a supported scheme: ${schemes.toSeq.sorted.mkString(", ")}", uri.getScheme)
  }

  protected def sourceForURIWithSupportedScheme(uri: URI)(implicit coscSession: COSCSession): COSCPropertyGraphDataSource
}