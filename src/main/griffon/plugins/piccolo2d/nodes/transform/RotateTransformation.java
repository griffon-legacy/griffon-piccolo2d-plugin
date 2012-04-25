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

/**
 * @author Andres Almiray
 */
public class RotateTransformation implements Transformation {
    private double theta = 0d;
    private boolean inplace = false;
    private double x = Double.NEGATIVE_INFINITY;
    private double y = Double.NEGATIVE_INFINITY;

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public boolean isInplace() {
        return inplace;
    }

    public void setInplace(boolean inplace) {
        this.inplace = inplace;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void apply(PNode node) {
        if (inplace) {
            node.rotateInPlace(theta);
        } else if (x != Double.NEGATIVE_INFINITY && y != Double.NEGATIVE_INFINITY) {
            node.rotateAboutPoint(theta, x, y);
        } else {
            node.rotate(theta);
        }
    }
}
