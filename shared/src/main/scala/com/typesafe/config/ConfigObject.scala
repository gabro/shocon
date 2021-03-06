/* Copyright 2016 UniCredit S.p.A.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.typesafe.config

import java.{util => ju}
import scala.collection.JavaConverters._

trait ConfigObject extends ju.AbstractMap[String, ConfigValue] with ConfigValue {

	def toConfig = Config(inner)
  def unwrapped: ju.Map[String, Any]

  override def render: String = this.entrySet().asScala.map(kv => kv.getKey+" -> "+kv.getValue).mkString("[", ",", "]")
  override def valueType: ConfigValueType = ConfigValueType.OBJECT

}
