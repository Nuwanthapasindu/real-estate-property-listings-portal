package com.replp.services.wishlist;

public interface WishlistService {

    /**
     * Adds a property to the user's wishlist.
     *
     * @param userId the ID of the user whose wishlist is to be updated
     * @param propertyId the ID of the property to be added to the wishlist
     * @return true if the property was successfully added to the wishlist, false otherwise
     */
    boolean addToWishlist(String userId, String propertyId);

}
