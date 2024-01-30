package com.dmortizcal.bluebank.utils;

public class NoEncontrado extends RuntimeException {
    public NoEncontrado(String table, String id) {
        super("Could not found " + table + " " + id);
    }
}