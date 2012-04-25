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

import edu.umd.cs.piccolo.nodes.PHtmlView
import edu.umd.cs.piccolox.nodes.PComposite
import edu.umd.cs.piccolox.nodes.PStyledText
import edu.umd.cs.piccolox.pswing.PSwingCanvas
import edu.umd.cs.piccolox.swing.PScrollPane
import griffon.plugins.piccolo2d.nodes.transform.RotateTransformation
import griffon.plugins.piccolo2d.nodes.transform.ScaleTransformation
import griffon.plugins.piccolo2d.nodes.transform.TransformTransformation
import griffon.plugins.piccolo2d.nodes.transform.TranslateTransformation
import groovy.swing.factory.ScrollPaneFactory
import griffon.plugins.piccolo2d.factory.*

/**
 * @author Andres Almiray
 */
class Piccolo2dGriffonAddon {
    Map factories = [
            pcanvas: new PCanvasFactory(),
            phtmlView: new PBeanFactory(PHtmlView),
            pimage: new PImageFactory(),
            ppath: new PPathFactory(),
            ptext: new PTextFactory(),
            pnode: new PNodeFactory(),
            // == extras ==
            pswingCanvas: new PCanvasFactory(PSwingCanvas),
            pscrollPane: new ScrollPaneFactory(PScrollPane),
            pstyledText: new PBeanFactory(PStyledText),
            pcomposite: new PBeanFactory(PComposite),
            // == transformations ==
            ptransformations: new TransformationsFactory(),
            protate: new PBeanFactory(RotateTransformation),
            pscale: new PBeanFactory(ScaleTransformation),
            ptranslate: new PBeanFactory(TranslateTransformation),
            ptransform: new PBeanFactory(TransformTransformation),
            // == shapes ==
            pline: new PLineFactory(),
            prectangle: new PRectangleFactory(),
            proundRectangle: new PRoundRectangleFactory(),
            pellipse: new PEllipseFactory(),
            ppolyLine: new PPolyLineFactory()
    ]
}
