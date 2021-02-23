/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pilang;

/**
 *
 * @author Ravindu Denuwan
 */
public class KeyCode {

    private String key;

    /**
     * Assign KeyCode for PiKrypt
     * @param key
     */
    public KeyCode(String key) {
        this.key = key;
    }

    /**
     * Returns key value
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * Set key value
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

}
