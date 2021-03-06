/*
 *  Copyright 2014 TWO SIGMA OPEN SOURCE, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.twosigma.beakerx.chart.serializer;

import com.twosigma.beakerx.chart.categoryplot.plotitem.CategoryGraphics;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.util.List;

public abstract class CategoryGraphicsSerializer<T extends CategoryGraphics> extends GraphicsSerializer<T> {

  public void serialize(T graphics, JsonGenerator jgen, SerializerProvider sp) throws IOException {

    super.serialize(graphics, jgen, sp);

    jgen.writeObjectField("showItemLabel", graphics.getShowItemLabel());
    jgen.writeObjectField("center_series", graphics.getCenterSeries());
    jgen.writeObjectField("use_tool_tip", graphics.getUseToolTip());


    if (graphics.getSeriesNames() != null) {
      jgen.writeObjectField("seriesNames", graphics.getSeriesNames());
    }
    if (graphics.getValue() != null) {
      jgen.writeObjectField("value", graphics.getValue());

    }
    if (graphics.getColors() != null) {
      jgen.writeObjectField("colors", graphics.getColors());
    } else {
      jgen.writeObjectField("color", graphics.getColor());
    }

    String[][] itemLabels = graphics.getItemLabels();
    if (itemLabels != null){
      jgen.writeObjectField("itemLabels", itemLabels);
    }
  }
}
