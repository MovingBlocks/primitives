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
 * Represents a 3D sphere.
 */
public class Spheref implements Externalizable {

    /**
     * The x coordinate of the sphere's center.
     */
    public float x;
    /**
     * The y coordinate of the sphere's center.
     */
    public float y;
    /**
     * The z coordinate of the sphere's center.
     */
    public float z;
    /**
     * The sphere's radius.
     */
    public float r;

    /**
     * Create a new {@link Spheref} with center position <code>(0, 0, 0)</code> and radius = <code>0</code>.
     */
    public Spheref() {
    }

    /**
     * Create a new {@link Spheref} as a copy of the given <code>source</code>.
     *
     * @param source
     *          the {@link Spheref} to copy from
     */
    public Spheref(Spheref source) {
        this.x = source.x;
        this.y = source.y;
        this.z = source.z;
        this.r = source.r;
    }

    /**
     * Create a new {@link Spheref} with center position <code>c</code> and radius <code>r</code>.
     *
     * @param c
     *          the center position of the sphere
     * @param r
     *          the radius of the sphere
     */
    public Spheref(Vector3fc c, float r) {
        this.x = c.x();
        this.y = c.y();
        this.z = c.z();
        this.r = r;
    }

    /**
     * Create a new {@link Spheref} with center position <code>(x, y, z)</code> and radius <code>r</code>.
     *
     * @param x
     *          the x coordinate of the sphere's center
     * @param y
     *          the y coordinate of the sphere's center
     * @param z
     *          the z coordinate of the sphere's center
     * @param r
     *          the radius of the sphere
     */
    public Spheref(float x, float y, float z, float r) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
    }

    /**
     * Translate <code>this</code> by the given vector <code>xyz</code>.
     *
     * @param xyz
     *          the vector to translate by
     * @return this
     */
    public Spheref translate(Vector3fc xyz) {
        return translate(xyz.x(), xyz.y(), xyz.z(), this);
    }

    /**
     * Translate <code>this</code> by the given vector <code>xyz</code> and store the result in <code>dest</code>.
     *
     * @param xyz
     *          the vector to translate by
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Spheref translate(Vector3fc xyz, Spheref dest) {
        return translate(xyz.x(), xyz.y(), xyz.z(), dest);
    }

    /**
     * Translate <code>this</code> by the vector <code>(x, y, z)</code>.
     *
     * @param x
     *          the x coordinate to translate by
     * @param y
     *          the y coordinate to translate by
     * @param z
     *          the z coordinate to translate by
     * @return this
     */
    public Spheref translate(float x, float y, float z) {
        return translate(x, y, z, this);
    }

    /**
     * Translate <code>this</code> by the vector <code>(x, y, z)</code> and store the result in <code>dest</code>.
     *
     * @param x
     *          the x coordinate to translate by
     * @param y
     *          the y coordinate to translate by
     * @param z
     *          the z coordinate to translate by
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Spheref translate(float x, float y, float z, Spheref dest) {
        dest.x = this.x + x;
        dest.y = this.y + y;
        dest.z = this.z + z;
        return dest;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(r);
        result = prime * result + Float.floatToIntBits(x);
        result = prime * result + Float.floatToIntBits(y);
        result = prime * result + Float.floatToIntBits(z);
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Spheref other = (Spheref) obj;
        if (Float.floatToIntBits(r) != Float.floatToIntBits(other.r))
            return false;
        if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
            return false;
        if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
            return false;
        if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
            return false;
        return true;
    }

    /**
     * Return a string representation of this sphere.
     * <p>
     * This method creates a new {@link DecimalFormat} on every invocation with the format string "<code>0.000E0;-</code>".
     *
     * @return the string representation
     */
    public String toString() {
        return Runtime.formatNumbers(toString(Options.NUMBER_FORMAT));
    }

    /**
     * Return a string representation of this sphere by formatting the components with the given {@link NumberFormat}.
     *
     * @param formatter
     *          the {@link NumberFormat} used to format the components with
     * @return the string representation
     */
    public String toString(NumberFormat formatter) {
        return "[" + Runtime.format(x, formatter) + " " + Runtime.format(y, formatter) + " " + Runtime.format(z, formatter) + " " + Runtime.format(r, formatter) + "]";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeFloat(x);
        out.writeFloat(y);
        out.writeFloat(z);
        out.writeFloat(r);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        x = in.readFloat();
        y = in.readFloat();
        z = in.readFloat();
        r = in.readFloat();
    }

}
