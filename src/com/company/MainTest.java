package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void levQwerty() {
        assertEquals(1.5, Main.levQwerty("kot", "kita"), "Distance must be equal to 1.5 - 1 del, 1 0.5 sub");
        assertEquals(2, Main.levQwerty("drab", "dal"), "Distance must be equal to 2. 1 del - 1 1 sub");
        assertEquals(1, Main.levQwerty("past", "pist"), "Distance must be equal to 1 - 1 1 sub ");
        assertEquals(4, Main.levQwerty("         ", "kita"), "Distance must be equal to 4 - 4 ins");
        assertEquals(3, Main.levQwerty("kot", "      "), "Distance must be equal to 3 - 3 ins");
        assertEquals(2.5, Main.levQwerty("konto", "jimri"), "Distance must be equal to 2.5 - 5 0.5 sub ");
    }
}