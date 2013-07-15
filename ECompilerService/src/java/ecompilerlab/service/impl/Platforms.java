/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ecompilerlab.service.impl;

/**
 *
 * @author Shehan
 */
public enum Platforms {

    JAVA("Java"),
    C("C"),
    C_PLUS("C++"),
    C_SHARP("C#"),
    PYTHON("Python");
    private String value;

    Platforms(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
