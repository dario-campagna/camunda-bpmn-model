/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.xml.model.impl.type.attribute;

import org.camunda.bpm.xml.model.type.ModelElementType;

/**
 * <p>Base class for String attributes
 *
 * @author Daniel Meyer
 *
 */
public class StringAttribute extends AttributeImpl<String> {

  public StringAttribute(ModelElementType owningElementType) {
    super(owningElementType);
  }

  protected String convertXmlValueToModelValue(String rawValue) {
    return rawValue;
  }

  protected String convertModelValueToXmlValue(String modelValue) {
    return modelValue;
  }

}