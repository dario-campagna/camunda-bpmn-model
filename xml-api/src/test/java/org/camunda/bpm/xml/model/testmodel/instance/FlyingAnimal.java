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
package org.camunda.bpm.xml.model.testmodel.instance;

import org.camunda.bpm.xml.model.ModelBuilder;
import org.camunda.bpm.xml.model.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.xml.model.type.ModelElementTypeBuilder;
import org.camunda.bpm.xml.model.type.child.SequenceBuilder;
import org.camunda.bpm.xml.model.type.reference.ElementReferenceCollection;

import java.util.Collection;

import static org.camunda.bpm.xml.model.testmodel.TestModelConstants.*;

/**
 * @author Daniel Meyer
 *
 */
public abstract class FlyingAnimal extends Animal {

  private static ElementReferenceCollection<FlyingAnimal, FlightPartnerRef> flightPartnerRefsColl;

  public static void registerType(ModelBuilder modelBuilder) {

    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FlyingAnimal.class, TYPE_NAME_FLYING_ANIMAL)
      .namespaceUri(MODEL_NAMESPACE)
      .extendsType(Animal.class)
      .abstractType();

    SequenceBuilder sequence = typeBuilder.sequence();

    flightPartnerRefsColl = sequence.elementCollection(FlightPartnerRef.class, ELEMENT_NAME_FLIGHT_PARTNER_REF)
      .idElementReferenceCollection(FlyingAnimal.class)
      .build();

    typeBuilder.build();

  }

  FlyingAnimal(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public Collection<FlyingAnimal> getFlightPartnerRefs() {
    return flightPartnerRefsColl.getReferenceTargetElements(this);
  }

  public Collection<FlightPartnerRef> getFlightPartnerRefElements() {
    return flightPartnerRefsColl.getReferenceSourceCollection().get(this);
  }
}