package com.replp.services.wishlist;

import com.replp.model.Property;

import java.util.List;

public interface WishlistService {

    /**
     * Adds a property to the user's wishlist.
     *
     * @param userId the ID of the user whose wishlist is to be updated
     * @param propertyId the ID of the property to be added to the wishlist
     * @return true if the property was successfully added to the wishlist, false otherwise
     */
    boolean addToWishlist(String userId, String propertyId);


    /**
     * Retrieves the wishlist of a user.
     *
     * @param userId the ID of the user whose wishlist is to be retrieved
     * @return a list of property IDs that are in the user's wishlist
     */
    List<Property> getWishlist(String userId);

    /**
     * Removes a property from a user's wishlist.
     *
     * @param userId the ID of the user whose wishlist is to be updated
     * @param propertyId the ID of the property to be removed from the wishlist
     * @return true if the property was successfully removed from the wishlist, false otherwise
     */
    boolean removeWishlistFromUser(String userId, String propertyId);

}
