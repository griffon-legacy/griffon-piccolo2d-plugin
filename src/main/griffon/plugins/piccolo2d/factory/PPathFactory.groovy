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

import edu.umd.cs.piccolo.nodes.PPath

import java.awt.Shape
import java.awt.geom.Point2D

import static org.codehaus.griffon.factory.FactoryUtils.toFloat

/**
 * @author Andres Almiray
 */
class PPathFactory extends PBeanFactory {
    PPathFactory() {
        super(PPath)
    }

    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
        Shape shape = null
        if (value instanceof Shape) {
            shape = value
            value == null
        }
        if (attributes.containsKey('shape')) {
            shape = attributes.remove(('shape'))
        }

        if (shape) return new PPath(shape)
        return super.newInstance(builder, name, value, attributes)
    }
}

/**
 * @author Andres Almiray
 */
class PRectangleFactory extends AbstractPiccoloFactory {
    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
        float x = toFloat(attributes.remove('x') ?: 0f)
        float y = toFloat(attributes.remove('y') ?: 0f)
        float w = toFloat(attributes.remove('width') ?: 0f)
        float h = toFloat(attributes.remove('height') ?: 0f)
        PPath.createRectangle(x, y, w, h)
    }
}

/**
 * @author Andres Almiray
 */
class PEllipseFactory extends AbstractPiccoloFactory {
    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
        float x = toFloat(attributes.remove('x') ?: 0f)
        float y = toFloat(attributes.remove('y') ?: 0f)
        float w = toFloat(attributes.remove('width') ?: 0f)
        float h = toFloat(attributes.remove('height') ?: 0f)
        PPath.createEllipse(x, y, w, h)
    }
}

/**
 * @author Andres Almiray
 */
class PRoundRectangleFactory extends AbstractPiccoloFactory {
    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
        float x = toFloat(attributes.remove('x') ?: 0f)
        float y = toFloat(attributes.remove('y') ?: 0f)
        float w = toFloat(attributes.remove('width') ?: 0f)
        float h = toFloat(attributes.remove('height') ?: 0f)
        float aw = toFloat(attributes.remove('arcWeight') ?: 0f)
        float ah = toFloat(attributes.remove('arcHeight') ?: 0f)
        PPath.createRoundRectangle(x, y, w, h, aw, ah)
    }
}

/**
 * @author Andres Almiray
 */
class PLineFactory extends AbstractPiccoloFactory {
    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
        float x1 = toFloat(attributes.remove('x1') ?: 0f)
        float y1 = toFloat(attributes.remove('y1') ?: 0f)
        float x2 = toFloat(attributes.remove('x2') ?: 0f)
        float y2 = toFloat(attributes.remove('y2') ?: 0f)
        PPath.createRectangle(x1, y1, x2, y2)
    }
}

/**
 * @author Andres Almiray
 */
class PPolyLineFactory extends AbstractPiccoloFactory {
    @Override
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
        def points = attributes.remove('points')
        if (!points || (!(points instanceof List) && points.size() % 2 == 1)) {
            throw new IllegalArgumentException("In $name you must specify a value for points: as aList of even numbers")
        }
        def list = []
        for (int i = 0; i < points.size(); i++) {
            list << new Point2D.Float(toFloat(points[i]), toFloat(points[i++]))
        }
        PPath.createPolyline(list as Point2D[])
    }
}