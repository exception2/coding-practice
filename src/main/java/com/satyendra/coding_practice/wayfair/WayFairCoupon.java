package wayfair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WayFairCoupon {
    private static Map<String, List<Coupon>> couponMap = new HashMap<>();
    private static Map<String, String> categoryMap = new HashMap<>();
    private static Map<String, Product> productMap = new HashMap<>();
    private static Map<String, String> bestCouponMap = new HashMap<>();
    public static void main(String[] args) {
        List<Coupon> coupons1 = List.of(new Coupon("Comforters Sale"));
        couponMap.put("Comforter Sets", coupons1);
        List<Coupon> coupons2 = List.of(new Coupon("Savings on Bedding"));
        couponMap.put("Bedding", coupons2);
        List<Coupon> coupons3 = List.of(new Coupon("Low price for Bed & Bath"));
        couponMap.put("Bed & Bath", coupons3);

        categoryMap.put("Comforter Sets", "Bedding");
        categoryMap.put("Bedding", "Bed & Bath");
        categoryMap.put("Bed & Bath", null);
        categoryMap.put("Soap Dispensers", "Bathroom Accessories");
        categoryMap.put("Bathroom Accessories", "Bed & Bath");
        categoryMap.put("Toy Organizers", "Baby And Kids");
        categoryMap.put("Baby And Kids", null);

        calculateBestCoupon();

        System.out.println(findBestCoupon("Comforter Sets", bestCouponMap));
        System.out.println(findBestCoupon("Bedding", bestCouponMap));
        System.out.println(findBestCoupon("Bathroom Accessories", bestCouponMap));
        System.out.println(findBestCoupon("Soap Dispensers", bestCouponMap));
        System.out.println(findBestCoupon("Toy Organizers", bestCouponMap));
    }

    private static String findBestCoupon(String category, Map<String, String> bestCouponMap) {
        //String coupon = iterateCoupons(category);
        //bestCouponMap.put(category, coupon);
        return bestCouponMap.get(category);
    }

    private static void calculateBestCoupon() {
        for(Map.Entry<String, List<Coupon>> entry : couponMap.entrySet()) {
            bestCouponMap.put(entry.getKey(), entry.getValue().get(0).couponName);
        }
        for(String key : categoryMap.keySet()) {
            traverse(key);
        }
    }

    private static String iterateCoupons(String category) {
        if(bestCouponMap.containsKey(category)) {
            return bestCouponMap.get(category);
        }
        if(categoryMap.get(category) == null) {
            return null;
        }
        return iterateCoupons(categoryMap.get(category));
    }
    private static String traverse(String category) {
        if(bestCouponMap.containsKey(category)) {
            //bestCouponMap.put(category, bestCouponMap.get(category));
            return bestCouponMap.get(category);
        }
        if(categoryMap.get(category) == null) {
            bestCouponMap.put(category, null);
            return null;
        }
        String coupon = traverse(categoryMap.get(category));
        bestCouponMap.put(category, coupon);
        return coupon;
    }


    static class Coupon {
        String couponName;
        String dateModified;
        Double discount;
        Coupon(String couponName) {
            this.couponName = couponName;
        }
        Coupon(String couponName, String dateModified) {
            this.couponName = couponName;
            this.dateModified = dateModified;
        }
        Coupon(String couponName, String dateModified, Double discount) {
            this.couponName = couponName;
            this.dateModified = dateModified;
            this.discount = discount;
        }
    }
    static class Product {
        Double price;
        String categoryName;

        Product(Double price, String categoryName) {
            this.categoryName = categoryName;
            this.price = price;
        }
    }
}
