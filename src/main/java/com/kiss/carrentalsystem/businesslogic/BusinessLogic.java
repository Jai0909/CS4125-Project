package com.kiss.carrentalsystem.businesslogic;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.dto.CarDTO;

import java.util.concurrent.TimeUnit;

public class BusinessLogic {

    // These constants are declared to set the discount percentage and the time intervals
    private static final double ADMIN_DISCOUNT = 0.10;
    private static final double ONE_WEEK_DISCOUNT = 0.05;
    private static final double ONE_MONTH_DISCOUNT = 0.15;
    private static final int WEEK_IN_DAYS = 7;
    private static final int MONTH_IN_DAYS = 30;

    //This method calculates the total discount of the booking
    public double calculateDiscount(BookingDTO bookingDTO, boolean isAdmin, CarDTO car) {
        // This then calculates the days car will be rented for by getting the difference between booking start and end dates
        long diffInMillies = Math.abs(bookingDTO.getBookingEndDate().getTime() - bookingDTO.getBookingStartDate().getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        double totalDiscount = 0.0;

        // Admin Discount is applied if the user is admin
        if (isAdmin) {
            totalDiscount += ADMIN_DISCOUNT;
        }

        double basePrice = car.getBasePrice();

        // Time Discount is applied based on the duration of the renting period accordingly
        if (diffInDays >= WEEK_IN_DAYS) {
            totalDiscount += ONE_WEEK_DISCOUNT;
        }

        if (diffInDays >= MONTH_IN_DAYS) {
            totalDiscount += ONE_MONTH_DISCOUNT;
        }

        return applyDiscount(basePrice, totalDiscount);
    }

    // This calculates the final price after discount based on the discount percentage
    private double applyDiscount(double price, double discount){
        double reduction = price * discount;
        return price - reduction;
    }
}
