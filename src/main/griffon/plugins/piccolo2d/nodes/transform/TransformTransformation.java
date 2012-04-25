/*
 * Copyright 2012 the original author or authors.
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
package griffon.plugins.piccolo2d.nodes.transform;

import edu.umd.cs.piccolo.PNode;

import java.awt.geom.AffineTransform;

/**
 * @author Andres Almiray
 */
public class TransformTransformation implements Transformation {
    private AffineTransform transform;
    private boolean append = false;

    public boolean isAppend() {
        return append;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }

    public AffineTransform getTransform() {
        return transform;
    }

    public void setTransform(AffineTransform transform) {
        this.transform = transform;
    }

    public void apply(PNode node) {
        if (null == transform) return;
        if (append) {
            node.transformBy(transform);
        } else {
            node.setTransform(transform);
        }
    }
}
