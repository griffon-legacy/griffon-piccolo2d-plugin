/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package griffon.plugins.piccolo2d.factory

import edu.umd.cs.piccolo.PCamera
import edu.umd.cs.piccolo.PCanvas
import edu.umd.cs.piccolo.PNode
import edu.umd.cs.piccolox.pswing.PSwingCanvas
import javax.swing.JComponent
import edu.umd.cs.piccolox.pswing.PSwing

/**
 * @author Andres Almiray
 */
class PCanvasFactory extends PBeanFactory {
    PCanvasFactory() {
        this(PCanvas)
    }

    PCanvasFactory(Class beanClass) {
        super(beanClass)
        if (!PCanvas.isAssignableFrom(beanClass)) {
            throw new IllegalArgumentException("Can't use type $beanClass with ${this.class.name}")
        }
    }

    @Override
    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        if (child instanceof PCamera) {
            parent.layer.addCamera child
        } else if (child instanceof PNode) {
            parent.layer.addChild child
        } else if(parent instanceof PSwingCanvas && child instanceof JComponent) {
            parent.layer.addChild new PSwing(child)
        }
    }
}
