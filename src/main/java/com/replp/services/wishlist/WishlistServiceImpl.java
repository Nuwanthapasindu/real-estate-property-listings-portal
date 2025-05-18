package com.replp.services.wishlist;

import com.replp.dao.PublicUserDao;
import com.replp.model.Property;
import com.replp.model.PublicUser;
import com.replp.services.PropertyService;
import com.replp.services.publicAuthService.PublicAuthService;
import com.replp.services.publicAuthService.PublicAuthServiceImpl;

import java.util.List;
import java.util.Optional;

public class WishlistServiceImpl implements WishlistService {
    private final PropertyService propertyService = new PropertyService();
    private final PublicAuthService publicAuthService = new PublicAuthServiceImpl();
    private final PublicUserDao publicUserDao = new PublicUserDao();

    @Override
    public boolean addToWishlist(String userId, String propertyId) {
        // find user by id
        Optional<PublicUser> userOptional =publicAuthService.findById(userId);

        // find property by id
        Optional<Property> property = propertyService.findByID(propertyId);

        // add property to wishlist
        if (userOptional.isPresent() && property.isPresent()) {
            PublicUser user = userOptional.get();
            // get user wishlist
            List<String> wishlist = user.getWishList();
            // add property to wishlist
            if (wishlist == null) wishlist = new java.util.ArrayList<>();
            wishlist.add(property.get().getId());
            // update user wishlist
            user.setWishList(wishlist);
            return publicUserDao.updateWishList(user);

        }else return false;

    }
}
