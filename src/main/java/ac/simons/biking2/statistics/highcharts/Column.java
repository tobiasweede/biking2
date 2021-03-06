/*
 * Copyright 2014-2016 michael-simons.eu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
package ac.simons.biking2.statistics.highcharts;

import ac.simons.biking2.support.Sink;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Michael J. Simons, 2014-02-11
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Column {

    @SuppressWarnings({"checkstyle:hiddenfield"})
    public static final class Builder<P> {

        private final Sink<P, Column> sink;

        private Number borderWidth;

        private Number pointPadding;

        Builder(final Sink<P, Column> sink) {
            this.sink = sink;
        }

        public Builder<P> withBorderWidth(final Number borderWidth) {
            this.borderWidth = borderWidth;
            return this;
        }

        public Builder<P> withPointPadding(final Number pointPadding) {
            this.pointPadding = pointPadding;
            return this;
        }

        public P build() {
            return this.sink.setObject(new Column(borderWidth, pointPadding));
        }
    }

    /**
     * The width of the border surronding each column or bar. Defaults to 1.
     */
    private final Number borderWidth;

    /**
     * Padding between each column or bar, in x axis units. Defaults to 0.1.
     */
    private final Number pointPadding;

    @JsonCreator
    Column(
            @JsonProperty("borderWidth") final Number borderWidth,
            @JsonProperty("pointPadding") final Number pointPadding
    ) {
        this.borderWidth = borderWidth;
        this.pointPadding = pointPadding;
    }

    public Number getBorderWidth() {
        return borderWidth;
    }

    public Number getPointPadding() {
        return pointPadding;
    }
}
