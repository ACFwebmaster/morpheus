package org.opencypher.morpheus.adapters

import org.apache.spark.graph.api.{NodeFrame, RelationshipFrame}
import org.opencypher.okapi.api.io.conversion.{ElementMapping, NodeMappingBuilder, RelationshipMappingBuilder}

object MappingAdapter {

  implicit class RichNodeDataFrame(val nodeDf: NodeFrame) extends AnyVal {
    def toNodeMapping: ElementMapping = NodeMappingBuilder
      .on(nodeDf.idColumn)
      .withImpliedLabels(nodeDf.labelSet.toSeq: _*)
      .withPropertyKeyMappings(nodeDf.properties.toSeq:_*)
      .build
  }

  implicit class RichRelationshipDataFrame(val relDf: RelationshipFrame) extends AnyVal {
    def toRelationshipMapping: ElementMapping = RelationshipMappingBuilder
      .on(relDf.idColumn)
      .withSourceStartNodeKey(relDf.sourceIdColumn)
      .withSourceEndNodeKey(relDf.targetIdColumn)
      .withRelType(relDf.relationshipType)
      .withPropertyKeyMappings(relDf.properties.toSeq: _*)
      .build
  }
}
