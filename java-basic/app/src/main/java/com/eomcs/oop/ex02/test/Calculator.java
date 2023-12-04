package com.eomcs.oop.ex02.test;

public class Calculator {

  int result = 0;


  static void plus(Calculator instance, int value) {
    instance.result += value;
  }

  static void minus(Calculator instance, int value) {
    instance.result -= value;
  }

  static void multiple(Calculator instance, int value) {
    instance.result *= value;
  }

  static void divide(Calculator instance, int value) {
    instance.result /= value;
  }

  static int abs(int a) {
    //
    // if (a >= 0)
    // return a;
    // else
    // return a * -1;
    //
    return a >= 0 ? a : a * -1;
  }
}
