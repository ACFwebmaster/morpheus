package org.opencypher.spark.impl.spark

import org.opencypher.spark.api.expr.{Expr, Var}
import org.opencypher.spark.api.record.RecordSlot
import org.opencypher.spark.api.spark.{SparkCypherGraph, SparkCypherRecords}
import org.opencypher.spark.api.value.CypherValue

// TODO: Figure out where this should live in relationship to existing instances etc
object operations {

  implicit final class RichSparkCypherGraph(val graph: SparkCypherGraph) extends AnyVal {
    def filter(subject: SparkCypherRecords, expr: Expr, parameters: Map[String, CypherValue] = Map.empty)
              (implicit engine: SparkCypherEngine)
    : SparkCypherRecords =
      engine.filter(graph, subject, expr, parameters)

    def select(subject: SparkCypherRecords, fields: IndexedSeq[Var])(implicit engine: SparkCypherEngine): SparkCypherRecords =
      ???

    def project(subject: SparkCypherRecords, expr: Expr)(implicit engine: SparkCypherEngine): SparkCypherRecords =
      ???

    def alias(subject: SparkCypherRecords, alias: (Expr, Var))(implicit engine: SparkCypherEngine): SparkCypherRecords =
      ???

    def join(subject: SparkCypherRecords, other: SparkCypherRecords)(lhs: RecordSlot, rhs: RecordSlot)(implicit engine: SparkCypherEngine): SparkCypherRecords =
      ???
  }
}
