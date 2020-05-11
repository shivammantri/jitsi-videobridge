/*
 * Copyright @ 2017 - Present, 8x8 Inc
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
package org.jitsi.videobridge;

/**
 * Expresses the ideal video constraints for an endpoint. We may wish to support
 * track-based constraints in the future.
 */
public class EndpointConstraints
    extends Constraints
{
    private final String endpointId;

    EndpointConstraints(String endpointId, int idealHeight)
    {
        super(idealHeight);
        this.endpointId = endpointId;
    }

    static EndpointConstraints makePinnedEndpointConstraints(String endpointId)
    {
        return new EndpointConstraints(endpointId, 180);
    }

    static EndpointConstraints makeSelectedEndpointConstraints(String endpointId)
    {
        return new EndpointConstraints(endpointId, 720);
    }

    public EndpointConstraints unless(EndpointConstraints endpointConstraints)
    {
        return endpointConstraints != null ? endpointConstraints : this;
    }

    public String getEndpointId()
    {
        return endpointId;
    }
}
