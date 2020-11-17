package ru.job4j.poly;

public interface Transport {
   void toDrive();

   void passengers(int amount);

   double refuel(int gasAmount);
}