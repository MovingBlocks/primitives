// Copyright 2021 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0
package org.terasology.joml.geom;

import org.joml.Options;
import org.joml.Runtime;
import org.joml.Vector3fc;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Represents an undirected line segment between two points.
 */
public class LineSegmentf implements Externalizable {

    /**
     * The x coordinate of the first point.
     */
    public float aX;
    /**
     * The y coordinate of the first point.
     */
    public float aY;
    /**
     * The z coordinate of the first point.
     */
    public float aZ;
    /**
     * The x coordinate of the second point.
     */
    public float bX;
    /**
     * The y coordinate of the second point.
     */
    public float bY;
    /**
     * The z coordinate of the second point.
     */
    public float bZ;

    /**
     * Create a new {@link LineSegmentf} of zero length on the point <code>(0, 0, 0)</code>.
     */
    public LineSegmentf() {
    }

    /**
     * Create a new {@link LineSegmentf} as a copy of the given <code>source</code>.
     *
     * @param source
     *          the {@link LineSegmentf} to copy from
     */
    public LineSegmentf(LineSegmentf source) {
        this.aX = source.aX;
        this.aY = source.aY;
        this.aZ = source.aZ;
        this.aX = source.bX;
        this.bY = source.bY;
        this.bZ = source.bZ;
    }

    /**
     * Create a new {@link LineSegmentf} between the given two points.
     *
     * @param a
     *          the first point
     * @param b
     *          the second point
     */
    public LineSegmentf(Vector3fc a, Vector3fc b) {
        this.aX = a.x();
        this.aY = a.y();
        this.aZ = a.z();
        this.bX = b.x();
        this.bY = b.y();
        this.bZ = b.z();
    }

    /**
     * Create a new {@link LineSegmentf} between the two points.
     *
     * @param aX
     *          the x coordinate of the first point
     * @param aY
     *          the y coordinate of the first point
     * @param aZ
     *          the z coordinate of the first point
     * @param bX
     *          the x coordinate of the second point
     * @param bY
     *          the y coordinate of the second point
     * @param bZ
     *          the z coordinate of the second point
     */
    public LineSegmentf(float aX, float aY, float aZ, float bX, float bY, float bZ) {
        super();
        this.aX = aX;
        this.aY = aY;
        this.aZ = aZ;
        this.bX = bX;
        this.bY = bY;
        this.bZ = bZ;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(aX);
        result = prime * result + Float.floatToIntBits(aY);
        result = prime * result + Float.floatToIntBits(aZ);
        result = prime * result + Float.floatToIntBits(bX);
        result = prime * result + Float.floatToIntBits(bY);
        result = prime * result + Float.floatToIntBits(bZ);
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LineSegmentf other = (LineSegmentf) obj;
        if (Float.floatToIntBits(aX) != Float.floatToIntBits(other.aX))
            return false;
        if (Float.floatToIntBits(aY) != Float.floatToIntBits(other.aY))
            return false;
        if (Float.floatToIntBits(aZ) != Float.floatToIntBits(other.aZ))
            return false;
        if (Float.floatToIntBits(bX) != Float.floatToIntBits(other.bX))
            return false;
        if (Float.floatToIntBits(bY) != Float.floatToIntBits(other.bY))
            return false;
        if (Float.floatToIntBits(bZ) != Float.floatToIntBits(other.bZ))
            return false;
        return true;
    }

    /**
     * Return a string representation of this line segment.
     * <p>
     * This method creates a new {@link DecimalFormat} on every invocation with the format string "<code>0.000E0;-</code>".
     *
     * @return the string representation
     */
    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    /**
     * Return a string representation of this line segment by formatting the vector components with the given {@link NumberFormat}.
     *
     * @param formatter
     *          the {@link NumberFormat} used to format the vector components with
     * @return the string representation
     */
    public String toString(NumberFormat formatter) {
        return "(" + Runtime.format(aX, formatter) + " " + Runtime.format(aY, formatter) + " " + Runtime.format(aZ, formatter) + ") - "
             + "(" + Runtime.format(bX, formatter) + " " + Runtime.format(bY, formatter) + " " + Runtime.format(bZ, formatter) + ")";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeFloat(aX);
        out.writeFloat(aY);
        out.writeFloat(aZ);
        out.writeFloat(bX);
        out.writeFloat(bY);
        out.writeFloat(bZ);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        aX = in.readFloat();
        aY = in.readFloat();
        aZ = in.readFloat();
        bX = in.readFloat();
        bY = in.readFloat();
        bZ = in.readFloat();
    }

}
